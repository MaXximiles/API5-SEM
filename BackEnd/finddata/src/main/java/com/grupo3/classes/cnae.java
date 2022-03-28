package com.grupo3.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cnae")
public class cnae 
{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "cnae_id")
	 private Long cnae_id;
	 
	 @Column(name = "cnae_codigo")
	 private String cnae_codigo;
	 
	 @Column(name = "cnae_descricao")
	 private String cnae_descricao;

	public Long getCnae_id() {
		return cnae_id;
	}

	public void setCnae_id(Long cnae_id) {
		this.cnae_id = cnae_id;
	}

	public String getCnae_codigo() {
		return cnae_codigo;
	}

	public void setCnae_codigo(String cnae_codigo) {
		this.cnae_codigo = cnae_codigo;
	}

	public String getCnae_descricao() {
		return cnae_descricao;
	}

	public void setCnae_descricao(String cnae_descricao) {
		this.cnae_descricao = cnae_descricao;
	}

	public cnae(Long cnae_id, String cnae_codigo, String cnae_descricao) {
		super();
		this.cnae_id = cnae_id;
		this.cnae_codigo = cnae_codigo;
		this.cnae_descricao = cnae_descricao;
	}
	 
}
