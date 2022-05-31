package com.grupo3.finddata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.finddata.classes.Usuario;
import com.grupo3.finddata.repositorys.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	
	public Usuario procurarPorEmailSenha(String userEmail, String userSenha) {
		
		Usuario usu = repo.SelectUsuarioEmail(userEmail, userSenha);
		
		return usu == null ? null:usu;
	}
	

}
