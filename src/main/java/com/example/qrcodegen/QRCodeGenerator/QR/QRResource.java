package com.example.qrcodegen.QRCodeGenerator.QR;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.zxing.WriterException;

import jakarta.validation.Valid;

@RestController
public class QRResource {
	
	@Autowired
	QRJpaRepository qjr;
	
	@GetMapping("/qrcode")
	public List<QR> getCodes() {
		Iterable<QR> qrs = qjr.findAll();
		 qrs.forEach((qr) -> {
			 try {
				qr.setQr_code(QRCodeGenerator.getQRCodeImage(qr.getUrl(), 100, 100));
			} catch (WriterException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 });
		 
		 return (List<QR>) qrs;
	}
	
	@GetMapping("/qrcode/{id}")
	public QR getCodeByUID(@PathVariable UUID id) throws WriterException, IOException {
		Optional<QR> qr = qjr.findById(id);
		qr.get().setQr_code(QRCodeGenerator.getQRCodeImage(qr.get().getUrl(), 100, 100));
		
		return qr.get();
	}
	
	@PostMapping("/qrcode")
	public ResponseEntity<Object> addQR(@Valid @RequestBody QR qr) throws WriterException, IOException {
		qr.setQr_code(QRCodeGenerator.getQRCodeImage(qr.getUrl(), 100, 100));
		QR saveQR = qjr.save(qr);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveQR.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping("/qrcode/{id}")
	public ResponseEntity<Object> updateQR(@PathVariable UUID id, @Valid @RequestBody QR qr){
		Optional<QR> qrr = qjr.findById(id);
		qrr.get().setProduct_name(qr.getProduct_name());
		qrr.get().setProduct_price(qr.getProduct_price());
		qrr.get().setDescription(qr.getDescription());
		qrr.get().setRetailer(qr.getRetailer());
		qrr.get().setUrl(qr.getUrl());
		
		qjr.save(qrr.get());

		return ResponseEntity.ok(qrr.get());
		
	}
	
	
	@DeleteMapping("/qrcode/{id}")
	public void deleteQR(@PathVariable UUID id) {
		qjr.deleteById(id);
		
	}
	
	
	
	

}
