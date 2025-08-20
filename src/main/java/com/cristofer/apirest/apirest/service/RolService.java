package com.cristofer.apirest.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristofer.apirest.apirest.Entities.ROl;
import com.cristofer.apirest.apirest.Repositories.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<ROl> getRols() {
        return rolRepository.findAll();
    }

}
