package com.example.qrcodegen.QRCodeGenerator.QR;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class QR {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String product_name;
	private double product_price;
	private String description;
	private String retailer;
	private String url;
	@Transient
	private byte[] qr_code;
	
	public QR() {
		
	}

	public QR(UUID id, String product_name, double product_price, String description, String retailer, String url,
			byte[] qr_code) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.description = description;
		this.retailer = retailer;
		this.url = url;
		this.qr_code = qr_code;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRetailer() {
		return retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getQr_code() {
		return qr_code;
	}

	public void setQr_code(byte[] qr_code) {
		this.qr_code = qr_code;
	}
	
	
	
	
	
	
}
