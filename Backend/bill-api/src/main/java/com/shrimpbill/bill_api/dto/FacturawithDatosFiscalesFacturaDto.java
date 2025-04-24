package com.shrimpbill.bill_api.dto;

public class FacturawithDatosFiscalesFacturaDto {
    // campos de FacturaModel
    private String token;
    private String csdEmisor;
    private String qrDatos;
    private Long usuarioId;    // opcional por si se asocia usuario

    // campos de DatosFiscalesFacturaModel
    private String rfc;
    private String razonSocial;
    private String regimenFiscal;
    private String cfdi;
    private String email;
    private String codigoPostal;
    private String ciudad;
    private String estado;
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String colonia;
    private String ventaEnLinea;

    // getters + setters…
}
