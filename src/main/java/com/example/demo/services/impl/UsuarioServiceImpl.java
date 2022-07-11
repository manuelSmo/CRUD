package com.example.demo.services.impl;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioModel> listAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioModel createUser(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioModel updateUser(UsuarioModel usuario) {
        UsuarioModel usuarioDB = usuarioRepository.findById(usuario.getCedulaUsuario()).orElse(null);
        if (usuarioDB == null){
            return null;
        }

        usuarioDB = mapperUsuario(usuarioDB,usuario);
        return usuarioRepository.save(usuarioDB);
    }

    @Override
    public UsuarioModel deleteUser(Long id) {
        UsuarioModel usuarioDB = usuarioRepository.findById(id).orElse(null);
        if (usuarioDB == null){
            return null;
        }
        usuarioRepository.deleteById(usuarioDB.getCedulaUsuario());
        return usuarioDB;
    }

    public UsuarioModel mapperUsuario(UsuarioModel usuarioDB,UsuarioModel usuario){
        usuarioDB.setEdadUsuario(usuario.getEdadUsuario());
        usuarioDB.setApellidoUsuario(usuario.getApellidoUsuario());
        usuarioDB.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDB.setEmailUsuario(usuario.getEmailUsuario());
        usuarioDB.setNumeroTelefonoUsuario(usuario.getNumeroTelefonoUsuario());
        return usuarioDB;
    }
}
