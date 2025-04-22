package com.shrimpbill.bill_api.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

@Service
public class GenerateQRService {

    /**
     * Generar QR a partir de datis clave, para ser procesado en el frontend
     * @param token Token de la compra realizada
     * @param date Fecha de la compra realizada
     * @param time Hora de la compra realizada
     * @return bytes que contienen la imagen del qr generado
     */
    public byte[] generateQr(String token, String date, String time){
        String data = String.format("token=%s&date=%s&fecha%s", token, date, time);
        String url;
        try { // Esto esta mal hecho
            url = "https://localhost:8080/verficacion?" + URLEncoder.encode(data, "UTF-8"); 
            //Remplazar URL por el dominio adecuado
        } catch (UnsupportedEncodingException e) {
            url = null;
            e.printStackTrace();
        }

        try{
            BitMatrix matrix = new MultiFormatWriter()
                .encode(url, BarcodeFormat.QR_CODE, 300, 300);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix, "PNG", stream);   
            return stream.toByteArray();
        }catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding error", e);
        } catch (WriterException e) {
            throw new RuntimeException("QR code generation error", e);
        } catch (IOException e){
            throw new RuntimeException("IO exception o algo asi", e);
        } 

    }
}

