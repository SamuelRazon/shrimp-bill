package com.shrimpbill.bill_api.dto;

public class FacturaCompletaDto {
    // — Factura —
    private String token;
    private String csdEmisor;
    private String qrDatos;
    private Long usuarioId;

    // — Datos fiscales de la factura —
    private String rfcFactura;
    private String razonSocialFactura;
    private String regimenFiscalFactura;
    private String cfdiFactura;
    private String emailFactura;
    private String codigoPostalFactura;
    private String ciudadFactura;
    private String estadoFactura;
    private String calleFactura;
    private String numeroExteriorFactura;
    private String numeroInteriorFactura;
    private String coloniaFactura;
    private String ventaEnLineaFactura;

    // — Domicilio del usuario —
    private String codigoPostalDom;
    private String ciudadDom;
    private String estadoDom;
    private String calleDom;
    private String numeroExteriorDom;
    private String numeroInteriorDom;
    private String coloniaDom;

    // — Datos fiscales personales del usuario —
    private String rfcUsuario;
    private String razonSocialUsuario;
    private String regimenFiscalUsuario;
    private String usoCfdiUsuario;

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
    
    public String getRfcFactura() {
        return rfcFactura;
    }
    
    public void setRfcFactura(String rfcFactura) {
        this.rfcFactura = rfcFactura;
    }
    
    public String getRazonSocialFactura() {
        return razonSocialFactura;
    }
    
    public void setRazonSocialFactura(String razonSocialFactura) {
        this.razonSocialFactura = razonSocialFactura;
    }
    
    public String getRegimenFiscalFactura() {
        return regimenFiscalFactura;
    }
    
    public void setRegimenFiscalFactura(String regimenFiscalFactura) {
        this.regimenFiscalFactura = regimenFiscalFactura;
    }
    
    public String getCfdiFactura() {
        return cfdiFactura;
    }
    
    public void setCfdiFactura(String cfdiFactura) {
        this.cfdiFactura = cfdiFactura;
    }
    
    public String getEmailFactura() {
        return emailFactura;
    }
    
    public void setEmailFactura(String emailFactura) {
        this.emailFactura = emailFactura;
    }
    
    public String getCodigoPostalFactura() {
        return codigoPostalFactura;
    }
    
    public void setCodigoPostalFactura(String codigoPostalFactura) {
        this.codigoPostalFactura = codigoPostalFactura;
    }
    
    public String getCiudadFactura() {
        return ciudadFactura;
    }
    
    public void setCiudadFactura(String ciudadFactura) {
        this.ciudadFactura = ciudadFactura;
    }
    
    public String getEstadoFactura() {
        return estadoFactura;
    }
    
    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }
    
    public String getCalleFactura() {
        return calleFactura;
    }
    
    public void setCalleFactura(String calleFactura) {
        this.calleFactura = calleFactura;
    }
    
    public String getNumeroExteriorFactura() {
        return numeroExteriorFactura;
    }
    
    public void setNumeroExteriorFactura(String numeroExteriorFactura) {
        this.numeroExteriorFactura = numeroExteriorFactura;
    }
    
    public String getNumeroInteriorFactura() {
        return numeroInteriorFactura;
    }
    
    public void setNumeroInteriorFactura(String numeroInteriorFactura) {
        this.numeroInteriorFactura = numeroInteriorFactura;
    }
    
    public String getColoniaFactura() {
        return coloniaFactura;
    }
    
    public void setColoniaFactura(String coloniaFactura) {
        this.coloniaFactura = coloniaFactura;
    }
    
    public String getVentaEnLineaFactura() {
        return ventaEnLineaFactura;
    }
    
    public void setVentaEnLineaFactura(String ventaEnLineaFactura) {
        this.ventaEnLineaFactura = ventaEnLineaFactura;
    }
    
    public String getCodigoPostalDom() {
        return codigoPostalDom;
    }
    
    public void setCodigoPostalDom(String codigoPostalDom) {
        this.codigoPostalDom = codigoPostalDom;
    }
    
    public String getCiudadDom() {
        return ciudadDom;
    }
    
    public void setCiudadDom(String ciudadDom) {
        this.ciudadDom = ciudadDom;
    }
    
    public String getEstadoDom() {
        return estadoDom;
    }
    
    public void setEstadoDom(String estadoDom) {
        this.estadoDom = estadoDom;
    }
    
    public String getCalleDom() {
        return calleDom;
    }
    
    public void setCalleDom(String calleDom) {
        this.calleDom = calleDom;
    }
    
    public String getNumeroExteriorDom() {
        return numeroExteriorDom;
    }
    
    public void setNumeroExteriorDom(String numeroExteriorDom) {
        this.numeroExteriorDom = numeroExteriorDom;
    }
    
    public String getNumeroInteriorDom() {
        return numeroInteriorDom;
    }
    
    public void setNumeroInteriorDom(String numeroInteriorDom) {
        this.numeroInteriorDom = numeroInteriorDom;
    }
    
    public String getColoniaDom() {
        return coloniaDom;
    }
    
    public void setColoniaDom(String coloniaDom) {
        this.coloniaDom = coloniaDom;
    }
    
    public String getRfcUsuario() {
        return rfcUsuario;
    }
    
    public void setRfcUsuario(String rfcUsuario) {
        this.rfcUsuario = rfcUsuario;
    }
    
    public String getRazonSocialUsuario() {
        return razonSocialUsuario;
    }
    
    public void setRazonSocialUsuario(String razonSocialUsuario) {
        this.razonSocialUsuario = razonSocialUsuario;
    }
    
    public String getRegimenFiscalUsuario() {
        return regimenFiscalUsuario;
    }
    
    public void setRegimenFiscalUsuario(String regimenFiscalUsuario) {
        this.regimenFiscalUsuario = regimenFiscalUsuario;
    }
    
    public String getUsoCfdiUsuario() {
        return usoCfdiUsuario;
    }
    
    public void setUsoCfdiUsuario(String usoCfdiUsuario) {
        this.usoCfdiUsuario = usoCfdiUsuario;
    }
    
}

