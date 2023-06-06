package com.example.qrcodegen.QRCodeGenerator.QR;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QRJpaRepository extends JpaRepository<QR, UUID> {

}
