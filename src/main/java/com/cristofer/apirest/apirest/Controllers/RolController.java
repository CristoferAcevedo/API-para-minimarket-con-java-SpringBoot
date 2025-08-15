package com.cristofer.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristofer.apirest.apirest.Entities.ROl;
import com.cristofer.apirest.apirest.service.RolService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/rol")
@Tag(name = "Rol", description = "Operaciones relacionadas con los roles de usuario")
public class RolController {

    @Autowired
    private RolService rolService;

    @Operation(summary = "Listar todos los roles")
    @GetMapping
    public ResponseEntity<List<ROl>> getRols() {
        List<ROl> rols = rolService.getRols();
        return ResponseEntity.ok(rols);
    }

    @Operation(summary = "crear un nuevo rol")
    @PostMapping
    public ResponseEntity<ROl> createRol(@RequestBody ROl rol) {
        ROl createdRol = rolService.createRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRol);
    }

}
