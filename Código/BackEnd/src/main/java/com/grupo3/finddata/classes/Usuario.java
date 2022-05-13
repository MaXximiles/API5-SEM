package com.grupo3.finddata.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long usuid;
	
	@Column(name = "usu_nome")
	private String usunome;
	
	@Column(name = "usu_email")
	private String usuemail;
	
	@Column(name = "usu_senha")
	private String ususenha;
	
	@Column(name = "usu_nivel")
	private String usunivel;
	
	@Column(name = "usu_cidade")
	private String usucidade;
	
	
	
	public String getUsucidade() {
		return usucidade;
	}

	public void setUsucidade(String usucidade) {
		this.usucidade = usucidade;
	}

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
	
}
