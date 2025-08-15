package com.cristofer.apirest.apirest.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristofer.apirest.apirest.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Autenticacion", description = "Operaciones relacionadas con el login y el registro de usuarios")
public class AuthController {

    @Autowired
    private AuthService authService;

    // tomar los usuarios
    @Operation(summary = "Iniciar sesión")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> Login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    // crear un usuario
    @Operation(summary = "Registrar un nuevo usuario")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> Register(@RequestBody RegistroRequest registroRequest) {
        return ResponseEntity.ok(authService.register(registroRequest));
    }
}
