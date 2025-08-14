package com.cristofer.apirest.apirest.Auth;

import com.cristofer.apirest.apirest.Entities.ROl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistroRequest {
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String numero;
    private ROl rolId;
}
