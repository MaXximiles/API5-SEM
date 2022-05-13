package com.grupo3.finddata.classes;

import javax.persistence.*;

@Entity
@Table(name="empresas")
public class Empresa 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empid;

    @Column(name = "emp_nome")
    private String empnome;

    @Column(name = "emp_cnpj")
    private String empcnpj;
    
    @Column(name = "cid_id")
    private String cidid;
    
    @Column(name = "cnae_id")
    private String cnaeid;
    
    @Column(name = "emp_origem")
    private String emporigem;
    
    @Column(name = "cart_id")
    private String cartid;
    
    
    
	
	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getEmpnome() {
		return empnome;
	}

	public void setEmpnome(String empnome) {
		this.empnome = empnome;
	}

	public String getEmpcnpj() {
		return empcnpj;
	}

	public void setEmpcnpj(String empcnpj) {
		this.empcnpj = empcnpj;
	}

	public String getCidid() {
		return cidid;
	}

	public void setCidid(String cidid) {
		this.cidid = cidid;
	}

	public String getCnaeid() {
		return cnaeid;
	}

	public void setCnaeid(String cnaeid) {
		this.cnaeid = cnaeid;
	}

	public String getEmporigem() {
		return emporigem;
	}

	public void setEmporigem(String emporigem) {
		this.emporigem = emporigem;
	}
		
	

        
}
