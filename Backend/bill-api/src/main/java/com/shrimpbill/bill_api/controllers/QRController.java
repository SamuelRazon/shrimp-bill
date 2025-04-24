package com.shrimpbill.bill_api.controllers;

import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.shrimpbill.bill_api.services.GenerateQRService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Cambia "*" por tu dominio Angular si es necesario
public class QRController {
    private final GenerateQRService qrService;

    public QRController(GenerateQRService qrService) {
        this.qrService = qrService;
    }


    @GetMapping(path = "/qr-ticket", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]>  getQr( @RequestParam Map<String, String> allParams, HttpServletResponse response)  throws Exception {
        String token = allParams.get("token");
        String date = allParams.get("date");
        String time = allParams.get("time");
        String service = allParams.get("service");

        byte[] qr = qrService.generateQr(token, date, time, service);
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(qr, headers, HttpStatus.OK);
    }
}
