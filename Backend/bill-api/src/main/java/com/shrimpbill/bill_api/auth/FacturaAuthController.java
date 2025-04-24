package com.shrimpbill.bill_api.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shrimpbill.bill_api.dto.FacturaCompletaDto;
import com.shrimpbill.bill_api.models.DatosFiscalesFacturaModel;
import com.shrimpbill.bill_api.models.DatosFiscalesUsuarioModel;
import com.shrimpbill.bill_api.models.DomicilioModel;
import com.shrimpbill.bill_api.models.FacturaModel;
import com.shrimpbill.bill_api.models.UsuarioModel;
import com.shrimpbill.bill_api.repositories.DatosFiscalesFacturaRepository;
import com.shrimpbill.bill_api.repositories.DatosFiscalesUsuarioRepository;
import com.shrimpbill.bill_api.repositories.DomicilioRepository;
import com.shrimpbill.bill_api.repositories.FacturaRepository;
import com.shrimpbill.bill_api.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/facturas")
public class FacturaAuthController {

    private final FacturaRepository facturaRepo;
    private final DatosFiscalesFacturaRepository datosFactRepo;
    private final DomicilioRepository domicilioRepo;
    private final DatosFiscalesUsuarioRepository datosUsuRepo;
    private final UsuarioRepository usuarioRepo;

    public FacturaAuthController(FacturaRepository facturaRepo,
                                 DatosFiscalesFacturaRepository datosFactRepo,
                                 DomicilioRepository domicilioRepo,
                                 DatosFiscalesUsuarioRepository datosUsuRepo,
                                 UsuarioRepository usuarioRepo) {
        this.facturaRepo    = facturaRepo;
        this.datosFactRepo  = datosFactRepo;
        this.domicilioRepo  = domicilioRepo;
        this.datosUsuRepo   = datosUsuRepo;
        this.usuarioRepo    = usuarioRepo;
    }

    @PostMapping("/conusuario")
    public ResponseEntity<?> creaFacturaConUsuario(
            @RequestBody FacturaCompletaDto dto) {

        // 1. Obtén el usuario; aquí asumo que viene el usuarioId en el DTO
        UsuarioModel usuario = usuarioRepo.findById(dto.getUsuarioId())
            .orElseThrow(() -> 
                new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Usuario no encontrado"));

        // 2. Crear y guardar la factura
        FacturaModel fact = new FacturaModel();
        fact.setToken(dto.getToken());
        fact.setCsd_emisor(dto.getCsdEmisor());
        fact.setQr_datos(dto.getQrDatos());
        fact.setUsuario(usuario);
        fact = facturaRepo.save(fact);

        // 3. Datos fiscales de la factura
        DatosFiscalesFacturaModel dff = new DatosFiscalesFacturaModel();
        dff.setRfc(dto.getRfcFactura());
        dff.setRazonSocial(dto.getRazonSocialFactura());
        dff.setRegimenFiscal(dto.getRegimenFiscalFactura());
        dff.setCfdi(dto.getCfdiFactura());
        dff.setEmail(dto.getEmailFactura());
        dff.setCodigoPostal(dto.getCodigoPostalFactura());
        dff.setCiudad(dto.getCiudadFactura());
        dff.setEstado(dto.getEstadoFactura());
        dff.setCalle(dto.getCalleFactura());
        dff.setNumeroExterior(dto.getNumeroExteriorFactura());
        dff.setNumeroInterior(dto.getNumeroInteriorFactura());
        dff.setColonia(dto.getColoniaFactura());
        dff.setVentaEnLinea(dto.getVentaEnLineaFactura());
        dff.setFactura(fact);
        dff = datosFactRepo.save(dff);

        // Enlaza de vuelta (opcional para la respuesta JSON)
        fact.setDatosFiscalesFactura(dff);
        facturaRepo.save(fact);

        // 4. Domicilio del usuario
        DomicilioModel dom = new DomicilioModel();
        dom.setUsuario(usuario);
        dom.setCodigoPostal(dto.getCodigoPostalDom());
        dom.setCiudad(dto.getCiudadDom());
        dom.setEstado(dto.getEstadoDom());
        dom.setCalle(dto.getCalleDom());
        dom.setNumeroExterior(dto.getNumeroExteriorDom());
        dom.setNumeroInterior(dto.getNumeroInteriorDom());
        dom.setColonia(dto.getColoniaDom());
        domicilioRepo.save(dom);

        // 5. Datos fiscales personales del usuario
        DatosFiscalesUsuarioModel dfu = new DatosFiscalesUsuarioModel();
        dfu.setUsuario(usuario);
        dfu.setRfc(dto.getRfcUsuario());
        dfu.setRazonSocial(dto.getRazonSocialUsuario());
        dfu.setRegimenFiscal(dto.getRegimenFiscalUsuario());
        dfu.setCfdi(dto.getUsoCfdiUsuario());
        datosUsuRepo.save(dfu);

        // 6. Devolver la factura completa
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(fact);
    }
}
