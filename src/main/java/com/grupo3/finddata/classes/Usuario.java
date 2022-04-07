package com.grupo3.finddata.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long usu_id;
	
	@Column(name = "usu_nome")
	private String usu_nome;
	
	@Column(name = "usu_email")
	private String usu_email;
	
	@Column(name = "usu_senha")
	private String usu_senha;
	
	@Column(name = "usu_nivel")
	private String usu_nivel;
	

	public Long getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(Long usu_id) {
		this.usu_id = usu_id;
	}

	public String getUsu_nome() {
		return usu_nome;
	}

	public void setUsu_nome(String usu_nome) {
		this.usu_nome = usu_nome;
	}

	public String getUsu_email() {
		return usu_email;
	}

	public void setUsu_email(String usu_email) {
		this.usu_email = usu_email;
	}

	public String getUsu_senha() {
		return usu_senha;
	}

	public void setUsu_senha(String usu_senha) {
		this.usu_senha = usu_senha;
	}

	public String getUsu_nivel() {
		return usu_nivel;
	}

	public void setUsu_nivel(String usu_nivel) {
		this.usu_nivel = usu_nivel;
	}
	
	
	

}
