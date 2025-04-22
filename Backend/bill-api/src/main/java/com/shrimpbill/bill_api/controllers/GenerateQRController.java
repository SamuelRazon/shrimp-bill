package com.shrimpbill.bill_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Cambia "*" por tu dominio Angular si es necesario
public class GenerateQRController {
    
}
