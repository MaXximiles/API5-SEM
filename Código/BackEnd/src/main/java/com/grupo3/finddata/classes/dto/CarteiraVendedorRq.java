package com.grupo3.finddata.classes.dto;

import javax.persistence.Column;

public class CarteiraVendedorRq 
{
	 private Long cartid;
	 private String usuid;
	 private String empid;
	 private String cartstatus;
	 private String cartdataini;
	 
	 
	 
	public String getCartstatus() {
		return cartstatus;
	}
	public void setCartstatus(String cartstatus) {
		this.cartstatus = cartstatus;
	}
	public String getCartdataini() {
		return cartdataini;
	}
	public void setCartdataini(String cartdataini) {
		this.cartdataini = cartdataini;
	}
	public Long getCartid() {
		return cartid;
	}
	public void setCartid(Long cartid) {
		this.cartid = cartid;
	}
	public String getUsuid() {
		return usuid;
	}
	public void setUsuid(String usuid) {
		this.usuid = usuid;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	 
	 
}
