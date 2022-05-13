package com.grupo3.finddata.classes.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EmpresaRq
{
	
	private Long empid;
	private String empnome;
	private String empcnpj;
	private String cidid;
	private String cnaeid;
	private String emporigem;
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
