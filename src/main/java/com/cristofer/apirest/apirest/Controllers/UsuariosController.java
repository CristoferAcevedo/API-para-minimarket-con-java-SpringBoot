package com.cristofer.apirest.apirest.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristofer.apirest.apirest.Entities.Usuarios;
import com.cristofer.apirest.apirest.Repositories.UsuariosRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // tomar los usuarios
    @GetMapping("/login")
    public List<Usuarios> GetUsuarios() {
        return usuariosRepository.findAll();
    }

    // crear un usuario
    @PostMapping("/register")
    public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

}
