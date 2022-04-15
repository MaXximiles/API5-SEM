package com.grupo3.finddata.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.finddata.classes.Usuario;
import com.grupo3.finddata.classes.dto.UsuarioRq;
import com.grupo3.finddata.classes.dto.UsuarioRs;
import com.grupo3.finddata.repositorys.UsuarioRepository;



@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController 
{
	
	private UsuarioRepository usuarioRepository = null;
	
	public UsuarioController(UsuarioRepository UsuarioRepository) {this.usuarioRepository = UsuarioRepository; }
		
	// SELECT de todos//
	@GetMapping("/")
	public List<UsuarioRs> selectAll()
	{
	   var usuario = usuarioRepository.findAll();
	   return usuario.stream().map((cid) -> UsuarioRs.converter(cid)).collect(Collectors.toList());
	}
		  
	// SELECT por ID //
	@GetMapping("/{id}")
	public UsuarioRs selectID(@PathVariable("id") Long id) 
	{
	  var usu = usuarioRepository.getOne(id);
	  return UsuarioRs.converter(usu);
	}
	
	// SELECT por nome
	@GetMapping("/filtronome") 
	public List<UsuarioRs> findUsuarioByusunome(@RequestParam(value = "nome", required = false) String nome)
	{
		var usuario = usuarioRepository.SelectUsuarioNome(nome);
		return usuario.stream().map(UsuarioRs::converter).collect(Collectors.toList());
	    
	}
		  
		
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertUsuario(@RequestBody UsuarioRq usuario) throws Exception
	{
	    var usu = new Usuario();

	    usu.setUsunome(usuario.getUsunome());
	    usu.setUsuemail(usuario.getUsuemail());
	    usu.setUsusenha(usuario.getUsusenha());
	    usu.setUsunivel(usuario.getUsunivel());
	    usuarioRepository.save(usu);

	 }
		
		
	// UPDATE
	@PutMapping("/{id}")
	public void updateUsuario(@PathVariable Long id, @RequestBody UsuarioRq usuario) throws Exception 
	{
	    var usu = usuarioRepository.findById(id);
	    
	    if (usu.isPresent()) 
	    {     
		      var usu2 = usu.get();

		      usu2.setUsunome(usuario.getUsunome());
			  usu2.setUsuemail(usuario.getUsuemail());
			  usu2.setUsusenha(usuario.getUsusenha());
			  usu2.setUsunivel(usuario.getUsunivel());
			  usuarioRepository.save(usu2);

		} else { throw new Exception("Cidade não encontrada"); }
		    
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void usuarioCidade(@PathVariable Long id) 
	{
	    usuarioRepository.deleteById(id);
	}
	
	public static String md5(String valor) throws Exception 
	{
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    BigInteger hash = new BigInteger(1, md.digest(valor.getBytes()));
	    String s = hash.toString(16);
	    if (s.length() % 2 != 0) {
	      s = "0" + s;
	    }
	    return s;
	}
	
	

	
	
	@PostMapping("/login")
	public Usuario Logar(@RequestBody Usuario usuario) throws Exception
	{
		String email = usuario.getUsuemail();
		String senha = usuario.getUsusenha();
			
	    Usuario user = usuarioRepository.SelectUsuarioEmail(email, senha);
			    
	    if(user == null) {return null;}
	    else{return user;}
	} 
	    
}
