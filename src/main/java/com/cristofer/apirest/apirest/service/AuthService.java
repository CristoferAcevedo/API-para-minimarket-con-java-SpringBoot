package com.cristofer.apirest.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristofer.apirest.apirest.Auth.AuthResponse;
import com.cristofer.apirest.apirest.Auth.LoginRequest;
import com.cristofer.apirest.apirest.Auth.RegistroRequest;
import com.cristofer.apirest.apirest.Entities.Usuarios;
import com.cristofer.apirest.apirest.Jwt.JwtService;
import com.cristofer.apirest.apirest.Repositories.UsuariosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UsuariosRepository usuariosRepository;

    @Autowired
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest loginRequest) {
        // Implement login logic here
        return new AuthResponse("dummyToken");
    }

    public AuthResponse register(RegistroRequest registroRequest) {
        Usuarios user = Usuarios.builder()
                .nombre(registroRequest.getNombre())
                .apellido(registroRequest.getApellido())
                .correo(registroRequest.getCorreo())
                .password(registroRequest.getPassword())
                .numero(registroRequest.getNumero())
                .rol_id(registroRequest.getRolId())
                .build();
        usuariosRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
