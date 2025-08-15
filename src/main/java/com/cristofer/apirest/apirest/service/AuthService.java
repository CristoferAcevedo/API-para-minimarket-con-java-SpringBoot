package com.cristofer.apirest.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cristofer.apirest.apirest.Auth.AuthResponse;
import com.cristofer.apirest.apirest.Auth.LoginRequest;
import com.cristofer.apirest.apirest.Auth.RegistroRequest;
import com.cristofer.apirest.apirest.Entities.ROl;
import com.cristofer.apirest.apirest.Entities.Usuarios;
import com.cristofer.apirest.apirest.Jwt.JwtService;
import com.cristofer.apirest.apirest.Repositories.RolRepository;
import com.cristofer.apirest.apirest.Repositories.UsuariosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UsuariosRepository usuariosRepository;

    @Autowired
    private final RolRepository rolRepository;

    @Autowired
    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getCorreo(), loginRequest.getPassword()));
        UserDetails user = usuariosRepository.findByCorreo(loginRequest.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegistroRequest registroRequest) {

        // Obtener la categoría desde el ID
        ROl rol_id = rolRepository.findById(registroRequest.getRolId())
                .orElseThrow(() -> new RuntimeException("rol no encontrado"));

        Usuarios user = Usuarios.builder()
                .nombre(registroRequest.getNombre())
                .apellido(registroRequest.getApellido())
                .correo(registroRequest.getCorreo())
                .password(passwordEncoder.encode(registroRequest.getPassword()))
                .numero(registroRequest.getNumero())
                .rol_id(rol_id)
                .build();
        usuariosRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
