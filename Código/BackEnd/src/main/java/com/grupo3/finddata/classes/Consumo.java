package com.grupo3.finddata.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consumo")
public class Consumo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cons_id")
	private Long cons_id;
	
	@Column(name = "cons_mes")
	private String cons_mes;
	
	@Column(name = "cons_qtdconsumo")
	private String cons_qtdconsumo;
	
	@Column(name = "emp_id")
	private String emp_id;

	public Long getCons_id() {
		return cons_id;
	}

	public void setCons_id(Long cons_id) {
		this.cons_id = cons_id;
	}

	public String getCons_mes() {
		return cons_mes;
	}

	public void setCons_mes(String cons_mes) {
		this.cons_mes = cons_mes;
	}

	public String getCons_qtdconsumo() {
		return cons_qtdconsumo;
	}

	public void setCons_qtdconsumo(String cons_qtdconsumo) {
		this.cons_qtdconsumo = cons_qtdconsumo;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}




}
