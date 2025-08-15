package com.cristofer.apirest.apirest.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristofer.apirest.apirest.Entities.Usuarios;
import com.cristofer.apirest.apirest.Repositories.UsuariosRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // tomar los usuarios
    @GetMapping()
    public List<Usuarios> GetUsuarios() {
        return usuariosRepository.findAll();
    }

}
