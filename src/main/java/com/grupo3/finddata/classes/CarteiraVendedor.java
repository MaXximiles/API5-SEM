package com.grupo3.finddata.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carteira_vendedor")
public class CarteiraVendedor 
{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "cart_id ")
	 private Long cartid;
	 
	 @Column(name = "usu_id")
	 private String usuid;
	 
	 @Column(name = "emp_id")
	 private String empid;
	 
	 @Column(name = "cart_status")
	 private String cartstatus;
	 
	 @Column(name = "cart_data_ini")
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
