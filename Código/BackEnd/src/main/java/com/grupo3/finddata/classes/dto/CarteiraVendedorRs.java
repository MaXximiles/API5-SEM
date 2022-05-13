package com.grupo3.finddata.classes.dto;

import java.util.List;

import javax.persistence.Column;

import com.grupo3.finddata.classes.CarteiraVendedor;
import com.grupo3.finddata.classes.Cidade;
import com.grupo3.finddata.classes.Cnae;
import com.grupo3.finddata.classes.Consumo;
import com.grupo3.finddata.classes.Empresa;
import com.grupo3.finddata.classes.Usuario;

public class CarteiraVendedorRs 
{
	private Long cartid;
	private String usuid;
	private String empid;
	private String cartstatus;
	private String cartdataini;
	  
    private List<EmpresaRs> empresa;
    private List<UsuarioRs> usuario;
	
 	
	public static CarteiraVendedorRs converter(CarteiraVendedor carteira, List<Empresa> lstEmpresa, List<Usuario> lstUsuario) 
	{
			var cart = new CarteiraVendedorRs();
			cart.setCartid(carteira.getCartid());
			cart.setEmpid(carteira.getEmpid());
			cart.setUsuid(carteira.getUsuid());
			cart.setCartdataini(carteira.getCartdataini());
			cart.setCartstatus(carteira.getCartstatus());
			
			cart.setEmpresa(EmpresaRs.converter(lstEmpresa));
			cart.setUsuario(UsuarioRs.converter(lstUsuario));
			return cart;
	}
	
	
	
	public List<EmpresaRs> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(List<EmpresaRs> empresa) {
		this.empresa = empresa;
	}




	public List<UsuarioRs> getUsuario() {
		return usuario;
	}




	public void setUsuario(List<UsuarioRs> usuario) {
		this.usuario = usuario;
	}




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
