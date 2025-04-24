package com.shrimpbill.bill_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrimpbill.bill_api.dto.FacturawithDatosFiscalesFacturaDto;
import com.shrimpbill.bill_api.models.FacturaModel;
import com.shrimpbill.bill_api.repositories.DatosFiscalesFacturaRepository;
import com.shrimpbill.bill_api.repositories.FacturaRepository;

// 3. Controlador sin autenticación
@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaRepository facturaRepo;
    private final DatosFiscalesFacturaRepository datosRepo;

    public FacturaController(FacturaRepository facturaRepo,
                             DatosFiscalesFacturaRepository datosRepo) {
        this.facturaRepo = facturaRepo;
        this.datosRepo   = datosRepo;
    }

    @PostMapping("/crea-sin-auth")
    public ResponseEntity<?> creaFacturaSinAuth(
            @RequestBody FacturawithDatosFiscalesFacturaDto dto) {
        // 1. Crear y guardar factura
        FacturaModel fact = new FacturaModel();
        fact.setToken(dto.getToken());
        fact.setCsd_emisor(dto.getCsdEmisor());
        fact.setQr_datos(dto.getQrDatos());
        // (opcional) enlazar usuario si viene
        if (dto.getUsuarioId() != null) {
            usuarioRepo.findById(dto.getUsuarioId())
                .ifPresent(fact::setUsuario);
        }
        FacturaModel facturaGuardada = facturaRepo.save(fact);

        // 2. Crear y guardar datos fiscales apuntando a la factura recién creada
        DatosFiscalesFacturaModel df = new DatosFiscalesFacturaModel();
        df.setRfc(dto.getRfc());
        df.setRazonSocial(dto.getRazonSocial());
        df.setRegimenFiscal(dto.getRegimenFiscal());
        df.setCfdi(dto.getCfdi());
        df.setEmail(dto.getEmail());
        df.setCodigoPostal(dto.getCodigoPostal());
        df.setCiudad(dto.getCiudad());
        df.setEstado(dto.getEstado());
        df.setCalle(dto.getCalle());
        df.setNumeroExterior(dto.getNumeroExterior());
        df.setNumeroInterior(dto.getNumeroInterior());
        df.setColonia(dto.getColonia());
        df.setVentaEnLinea(dto.getVentaEnLinea());
        df.setFactura(facturaGuardada);
        DatosFiscalesFacturaModel datosGuardados = datosRepo.save(df);

        // 3. (opcional) enlazar el lado inverso y volver a guardar factura
        facturaGuardada.setDatosFiscalesFactura(datosGuardados);
        facturaRepo.save(facturaGuardada);

        // 4. Devolver HTTP 201 con la factura completa
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(facturaGuardada);
    }
}
