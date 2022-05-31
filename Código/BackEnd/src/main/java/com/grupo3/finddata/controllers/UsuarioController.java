package com.grupo3.finddata.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import com.grupo3.finddata.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController 
{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioService service;
	@Autowired 
	private JavaMailSender mailSender;
		
	// SELECT de todos//
	@GetMapping("/")
	public List<UsuarioRs> selectAll()
	{
	   var usuario = usuarioRepository.selectUsuarioOrdem();
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
	
	//SELECT todos os vendedores 
	@GetMapping("/vendedores") 
	public List<UsuarioRs> selectVendedores(@RequestParam(value = "regiao", required = false) String regiao,
											@RequestParam(value = "nome", required = false) String nome)
	{
		var usuario = usuarioRepository.SelectVendedoresRegiao(regiao, nome);
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
	    usu.setUsucidade(usuario.getUsucidade());
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
			  usu2.setUsucidade(usuario.getUsucidade());
			  usuarioRepository.save(usu2);

		} else { throw new Exception("Cidade não encontrada"); }
		    
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void usuarioCidade(@PathVariable Long id) 
	{
	    usuarioRepository.deleteById(id);
	}
	
	@PostMapping("/login")
	public Usuario Logar(@RequestBody Usuario usuario) throws Exception
	{
		String email = usuario.getUsuemail();
		String senha = usuario.getUsusenha();
	    
	    return service.procurarPorEmailSenha(email, senha);
	}
	
	// UPDATE
	public String updateSenhaUsuario(String email, String senha) throws Exception 
	{   
		return service.alterarSenhaUsuario(email, senha);
	}
		
	@PostMapping("/recuperar/{email}")
    public String sendMail(@PathVariable("email") String email)
    {
		return service.enviarEmail(email);
	}
	
	
}
