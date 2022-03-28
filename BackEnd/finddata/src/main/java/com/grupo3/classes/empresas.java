package com.grupo3.classes;

import javax.persistence.*;

@Entity
@Table(name="empresas")
public class empresas 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long emp_id;

    @Column(name = "emp_nome")
    private String emp_nome;

    @Column(name = "emp_cnpj")
    private String emp_cnpj;
    
    @Column(name = "cid_id")
    private Long cid_id;
    
    @Column(name = "cnae_id")
    private Long cnae_id;
    
    @Column(name = "emp_origem")
    private String emp_origem;

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_nome() {
		return emp_nome;
	}

	public void setEmp_nome(String emp_nome) {
		this.emp_nome = emp_nome;
	}

	public String getEmp_cnpj() {
		return emp_cnpj;
	}

	public void setEmp_cnpj(String emp_cnpj) {
		this.emp_cnpj = emp_cnpj;
	}

	public Long getCid_id() {
		return cid_id;
	}

	public void setCid_id(Long cid_id) {
		this.cid_id = cid_id;
	}

	public Long getCnae_id() {
		return cnae_id;
	}

	public void setCnae_id(Long cnae_id) {
		this.cnae_id = cnae_id;
	}

	public String getEmp_origem() {
		return emp_origem;
	}

	public void setEmp_origem(String emp_origem) {
		this.emp_origem = emp_origem;
	}

	public empresas(Long emp_id, String emp_nome, String emp_cnpj, Long cid_id, Long cnae_id, String emp_origem) {
		super();
		this.emp_id = emp_id;
		this.emp_nome = emp_nome;
		this.emp_cnpj = emp_cnpj;
		this.cid_id = cid_id;
		this.cnae_id = cnae_id;
		this.emp_origem = emp_origem;
	}  
        
}
