package com.shrimpbill.bill_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador base para endpoints de usuarios relacionados con QR.
 * Actualmente definido como placeholder para futuras rutas de usuarios
 * que involucren QR. Si no se requiere lógica adicional aquí,
 * se puede eliminar o completar con métodos concretos.
 */
@Controller
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Cambia "*" por tu dominio Angular si es necesario
public class GenerateQRController {
    
}
