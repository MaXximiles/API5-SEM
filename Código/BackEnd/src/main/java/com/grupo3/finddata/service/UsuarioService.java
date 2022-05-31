package com.grupo3.finddata.service;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.grupo3.finddata.classes.Usuario;
import com.grupo3.finddata.repositorys.UsuarioRepository;

@Service
public class UsuarioService 
{
	
	@Autowired
	private UsuarioRepository repo;
	@Autowired 
	private JavaMailSender mailSender;
	
	
	public Usuario procurarPorEmailSenha(String userEmail, String userSenha) 
	{
		
		Usuario usu = repo.SelectUsuarioEmail(userEmail, userSenha);
		
		return usu == null ? null:usu;
	}
	
	public String alterarSenhaUsuario(String email, String senha) throws Exception
	{
		Usuario user = repo.selectUsuarioEmailRecuperar(email);
		
		var resultado = "";

	    if (user == null) { throw new Exception("ERRO - Email não encontrado"); } 
	    else 
	    { 
			user.setUsusenha(senha);
			repo.save(user);
			resultado = "1";
		 }
		return resultado;
	}
	
	public String enviarEmail(String email)
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
            var resultado = alterarSenhaUsuario(email, Senha); 
            if(resultado == "1"){ mailSender.send(mail);}
                      
            return "OK";
           
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return "Erro ao enviar e-mail";
        }
	}
	
	
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
