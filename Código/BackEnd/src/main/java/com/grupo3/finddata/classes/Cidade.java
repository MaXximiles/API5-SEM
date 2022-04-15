package com.grupo3.finddata.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid_id")
	private Long cid_id;
	
	@Column(name = "cid_cidade")
	private String cid_cidade;
	
	@Column(name = "cid_estado")
	private String cid_estado;
	
	@Column(name = "cid_regiaoibge")
	private String cid_regiaoibge;

	public Long getCid_id() {
		return cid_id;
	}

	public void setCid_id(Long cid_id) {
		this.cid_id = cid_id;
	}

	public String getCid_cidade() {
		return cid_cidade;
	}

	public void setCid_cidade(String cid_cidade) {
		this.cid_cidade = cid_cidade;
	}

	public String getCid_estado() {
		return cid_estado;
	}

	public void setCid_estado(String cid_estado) {
		this.cid_estado = cid_estado;
	}

	public String getCid_regiaoibge() {
		return cid_regiaoibge;
	}

	public void setCid_regiaoibge(String cid_regiaoibge) {
		this.cid_regiaoibge = cid_regiaoibge;
	}



	
	
}
