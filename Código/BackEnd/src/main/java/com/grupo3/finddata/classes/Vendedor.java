package com.grupo3.finddata.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendedor")
public class Vendedor 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ven_id")
	private Long ven_id;
	
	@Column(name = "ven_nome")
	private String ven_nome;
	
	@Column(name = "ven_cpf")
	private String ven_cpf;
	
	@Column(name = "usu_id")
	private Long usu_id;

}
