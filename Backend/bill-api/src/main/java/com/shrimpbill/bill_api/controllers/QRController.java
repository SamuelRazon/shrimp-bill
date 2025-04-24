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

/**
 * Controlador para generación de códigos QR como imágenes PNG.
 * <p>
 * Expone un endpoint que recibe parámetros de token, fecha, hora y servicio,
 * y devuelve un PNG con el código QR generado.
 * </p>
 */
@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Cambia "*" por tu dominio Angular si es necesario
public class QRController {
    private final GenerateQRService qrService;

        /**
     * Constructor con inyección de servicio de generación de QR.
     *
     * @param qrService servicio {@link GenerateQRService} encargado de generar el PNG.
     */
    public QRController(GenerateQRService qrService) {
        this.qrService = qrService;
    }

    /**
     * Genera y devuelve un PNG con el código QR que contiene la información
     * de token, fecha, hora y servicio.
     *
     * @param allParams mapa con parámetros:
     *                  
     *                    token: cadena única del ticket</li>
     *                    date: fecha en formato ISO (yyyy-MM-dd)</li>
     *                    time: hora en formato HH:mm</li>
     *                    service: nombre o código del servicio</li>
     *                
     * @param response  HttpServletResponse (no usado directamente, pero necesario para firmas).
     * @return ResponseEntity<byte[]> con el PNG y status 200.
     * @throws Exception en caso de fallo en generación del QR.
     */
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
