package com.shrimpbill.bill_api.dto;

/**
 * Datos que regresara y tomaran para el uso de la peticion de subida de una factura a traves de un usuario logeado
 */
public class FacturawithDatosFiscalesFacturaDto {
    // campos de FacturaModel
    private String token;
    private String csdEmisor;
    private String qrDatos;
    private Long usuarioId;

    // campos de DatosFiscalesFacturaModel
    private String rfc;
    private String razonSocial;
    private String regimenFiscal;
    private String uso_cfdi;
    private String email;
    private String codigoPostal;
    private String ciudad;
    private String estado;
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String colonia;
    private String ventaEnLinea;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCsdEmisor() {
        return csdEmisor;
    }

    public void setCsdEmisor(String csdEmisor) {
        this.csdEmisor = csdEmisor;
    }

    public String getQrDatos() {
        return qrDatos;
    }

    public void setQrDatos(String qrDatos) {
        this.qrDatos = qrDatos;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    public String getCfdi() {
        return uso_cfdi;
    }

    public void setCfdi(String uso_cfdi) {
        this.uso_cfdi = uso_cfdi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getVentaEnLinea() {
        return ventaEnLinea;
    }

    public void setVentaEnLinea(String ventaEnLinea) {
        this.ventaEnLinea = ventaEnLinea;
    }
}
