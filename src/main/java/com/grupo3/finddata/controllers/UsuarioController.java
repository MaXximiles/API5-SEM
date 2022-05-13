package com.grupo3.finddata.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.internet.MimeMessage;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController 
{
	
	private UsuarioRepository usuarioRepository = null;
	
	public UsuarioController(UsuarioRepository UsuarioRepository) {this.usuarioRepository = UsuarioRepository; }
		
	// SELECT de todos//
	/*@GetMapping("/")
	public List<UsuarioRs> selectAll()
	{
	   var usuario = usuarioRepository.findAll();
	   return usuario.stream().map((cid) -> UsuarioRs.converter(cid)).collect(Collectors.toList());
	}*/
	
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
			
	    Usuario user = usuarioRepository.SelectUsuarioEmail(email, senha);
			    
	    if(user == null) {return null;}
	    else{return user;}
	} 
	
	// UPDATE
	public String updateSenhaUsuario(String email, String senha) throws Exception 
	{
	    Usuario user = usuarioRepository.selectUsuarioEmailRecuperar(email);
	    var resultado = "";

	    if (user == null) 
	    { 
	    	throw new Exception("ERRO - Email não encontrado");
	    } 
	    else 
	    { 
			user.setUsusenha(senha);
			usuarioRepository.save(user);
			resultado = "1";
		 }
		return resultado;
		
		
		    
	}
	
	
	/////////////////////////////
	
	@Autowired private JavaMailSender mailSender;

	@PostMapping("/recuperar/{email}")
    public String sendMail(@PathVariable("email") String email)
    {
		var Senha = gerarSenha();
		
        try 
        {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            
            helper.setTo( email );
            helper.setSubject( "Recuperação de senha ao sistema Find Data " );
            helper.setText("<h2>Find Data</h2>"
            				+ "<br><br>"
            				+ "Olá sua nova senha é: "+Senha
            				+ "<br><br>"
            				+ "para alterar esta senha acesse o menu Meus Dados no canto superior direito da sua aplicação."
            				+ "<br><br>"
            				+ "Atenciosamente, equipe Find Data.",
            				true);
            var resultado = updateSenhaUsuario(email, Senha); 
            if(resultado == "1"){ mailSender.send(mail);}
                      
            return "OK";
           
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return "Erro ao enviar e-mail";
        }
    }
	
	///////////////////////////////////////////////////////////////
	public String gerarSenha()
	{
		//int qtdeMaximaCaracteres = 8;
		int qtdeMaximaCaracteres = 8;
	    String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8",
	                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
	                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
	                "x", "y", "z","!","@","$","%","&"};
	    
		StringBuilder senha = new StringBuilder();

	    for (int i = 0; i < qtdeMaximaCaracteres; i++) 
	    {
	        int posicao = (int) (Math.random() * caracteres.length);
	        senha.append(caracteres[posicao]);
	    }
	    return senha.toString();
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
}
