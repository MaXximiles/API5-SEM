package com.grupo3.finddata.classes.dto;

import java.util.ArrayList;
import java.util.List;

import com.grupo3.finddata.classes.*;

public class EmpresaRs 
{
	  private Long empid;
	  private String empnome;
	  private String empcnpj;
	  private String cidid;
	  private String cnaeid;
	  private String emporigem;
	  private String cartid;
	  
	  private List<CnaeRs> cnae;
	  private List<ConsumoRs> consumo;
	  private List<CidadeRs> cidade;
	  
	  public static EmpresaRs converter(Empresa empresa, List<Cnae> lstCnae, List<Consumo> lstConsumo, List<Cidade> lstCidade) 
	  {
			var emp = new EmpresaRs();
			emp.setEmpid(empresa.getEmpid());
			emp.setCidid(empresa.getCidid());
			emp.setCnaeid(empresa.getCnaeid());
			emp.setEmpcnpj(empresa.getEmpcnpj());
			emp.setEmpnome(empresa.getEmpnome());
			emp.setEmporigem(empresa.getEmporigem());
			emp.setCartid(empresa.getCartid());
			
			emp.setCnae(CnaeRs.converter(lstCnae));
			emp.setConsumo(ConsumoRs.converter(lstConsumo));
			emp.setCidade(CidadeRs.converter(lstCidade));
			return emp;
	}
	  
  public static List<EmpresaRs> converter(List<Empresa> lstEmpresa) 
	{
		List<EmpresaRs> listEmpresa = new ArrayList<>();
		List<Cnae> lstCnae = new ArrayList<>();
		List<Consumo> lstConsumo = new ArrayList<>();
		List<Cidade> lstCidade = new ArrayList<>();
		
		for(Empresa td : lstEmpresa)
		{
			
			listEmpresa.add(EmpresaRs.converter(td, lstCnae, lstConsumo, lstCidade));
		}
		
		return listEmpresa;
	}
  	  
	  
	public String getCartid() {
		return cartid;
	}


	public void setCartid(String cartid) {
		this.cartid = cartid;
	}




	public List<CidadeRs> getCidade() {
		return cidade;
	}




	public void setCidade(List<CidadeRs> cidade) {
		this.cidade = cidade;
	}




	public List<ConsumoRs> getConsumo() {
		return consumo;
	}



	public void setConsumo(List<ConsumoRs> consumo) {
		this.consumo = consumo;
	}



	public List<CnaeRs> getCnae() {
		return cnae;
	}


	public void setCnae(List<CnaeRs> cnae) {
		this.cnae = cnae;
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
