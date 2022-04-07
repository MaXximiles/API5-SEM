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

import com.grupo3.finddata.classes.Cidade;
import com.grupo3.finddata.classes.Usuario;
import com.grupo3.finddata.classes.dto.CidadeRq;
import com.grupo3.finddata.classes.dto.CidadeRs;
import com.grupo3.finddata.classes.dto.UsuarioRq;
import com.grupo3.finddata.classes.dto.UsuarioRs;
import com.grupo3.finddata.repositorys.CidadeRepository;
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
		  
		
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertUsuario(@RequestBody UsuarioRq usuario) throws Exception
	{
	    var usu = new Usuario();

	    usu.setUsu_nome(usuario.getUsu_nome());
	    usu.setUsu_email(usuario.getUsu_email());
	    usu.setUsu_senha(usuario.getUsu_senha());
	    usu.setUsu_nivel(usuario.getUsu_nivel());
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

		      usu2.setUsu_nome(usuario.getUsu_nome());
			  usu2.setUsu_email(usuario.getUsu_email());
			  usu2.setUsu_senha(usuario.getUsu_senha());
			  usu2.setUsu_nivel(usuario.getUsu_nivel());
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
	public UsuarioRs Logar(@RequestBody Usuario usuario) throws Exception
	{
	    var user = usuarioRepository.SelectUsuarioEmail(usuario.getUsu_email(), usuario.getUsu_senha());

	    try 
	    {
	      Long UserId = user.get(0).getUsu_id();
	      String UserSenha = user.get(0).getUsu_senha();
	      String UserEmail = user.get(0).getUsu_email();
	      String UserNome = user.get(0).getUsu_nome();
	      String UserNivel = user.get(0).getUsu_nivel();
	      
	      if (user.isEmpty() == false) 
	      {
	        //String SenhaCripto = md5(senha);

	        //if (!senha.equals(SenhaCripto)) 
	        //{
	          System.out.println("Login realizado com sucesso");

	          /*
	           * String Json = "{\"UserID\":\'"+UserId+"\'," +
	           * "\"UserSenha\":\'"+UserSenha+"'," + "\"UserEmail\":\'"+UserEmail+"'," +
	           * "\"UserNome\":\'"+UserNome+"'," + "\"UserNivel\":\'"+UserNivel+"'," +
	           * "\"UserLogin\":\'"+UserLogin+"'"; JSONObject jsonObject = new
	           * JSONObject(Json);
	           */

	          //var user1 = usuarioRepository.getOne(UserId);
	          //return UsuarioRs.converter(user1);

	        } 
	        else 
	        {
	          System.out.println("Senha nÃ£o confere");
	          return null;
	        }
	      } 
	    catch (Exception e) { return null;}
		return null;
	    } 
	    
}
