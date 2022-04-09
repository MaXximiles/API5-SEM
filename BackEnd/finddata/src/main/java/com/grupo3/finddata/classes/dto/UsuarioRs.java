package com.grupo3.finddata.classes.dto;

import com.grupo3.finddata.classes.Cidade;
import com.grupo3.finddata.classes.Usuario;

public class UsuarioRs {
	
	private Long usuid;
	private String usunome;
	private String usuemail;
	private String ususenha;
	private String usunivel;
	
	
	public Long getUsuid() {
		return usuid;
	}


	public void setUsuid(Long usuid) {
		this.usuid = usuid;
	}


	public String getUsunome() {
		return usunome;
	}


	public void setUsunome(String usunome) {
		this.usunome = usunome;
	}


	public String getUsuemail() {
		return usuemail;
	}


	public void setUsuemail(String usuemail) {
		this.usuemail = usuemail;
	}


	public String getUsusenha() {
		return ususenha;
	}


	public void setUsusenha(String ususenha) {
		this.ususenha = ususenha;
	}


	public String getUsunivel() {
		return usunivel;
	}


	public void setUsunivel(String usunivel) {
		this.usunivel = usunivel;
	}


	public static UsuarioRs converter(Usuario usuario) 
	{
			var usu = new UsuarioRs();
			usu.setUsuid(usuario.getUsuid());
			usu.setUsunome(usuario.getUsunome());
			usu.setUsuemail(usuario.getUsuemail());
			usu.setUsusenha(usuario.getUsusenha());
			usu.setUsunivel(usuario.getUsunivel());
			return usu;
	}
	

}
