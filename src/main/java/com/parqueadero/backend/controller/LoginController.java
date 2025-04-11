package com.parqueadero.backend.controller;

import com.parqueadero.backend.dto.LoginDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@PostMapping("/login")
	public String login(@RequestBody LoginDTO login) {
	    if ("admin".equals(login.getUsuario()) && "1234".equals(login.getContraseña())) {
	        return "Login exitoso";
	    }
	    return "Credenciales inválidas";
	}

    
}
