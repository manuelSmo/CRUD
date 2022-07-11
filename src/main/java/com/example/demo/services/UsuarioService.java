package com.example.demo.services;

import com.example.demo.models.UsuarioModel;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<UsuarioModel> listAllUsers();
    public UsuarioModel findById(Long id);
    public UsuarioModel createUser(UsuarioModel usuario);
    public UsuarioModel updateUser(UsuarioModel usuario);
    public UsuarioModel deleteUser(Long id);

}
