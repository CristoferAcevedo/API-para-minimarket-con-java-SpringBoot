package com.cristofer.apirest.apirest.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristofer.apirest.apirest.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // tomar los usuarios
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> Login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    // crear un usuario
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> Register(@RequestBody RegistroRequest registroRequest) {
        return ResponseEntity.ok(authService.register(registroRequest));
    }
}
