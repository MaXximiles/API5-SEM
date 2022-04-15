package com.grupo3.finddata.classes.dto;

import com.grupo3.finddata.classes.*;

public class EmpresaRs 
{
	  private Long empid;
	  private String empnome;
	  private String empcnpj;
	  private String cidid;
	  private String cnaeid;
	  private String emporigem;
	  
	  
	  public static EmpresaRs converter(Empresa empresa) 
	  {
			var emp = new EmpresaRs();
			emp.setEmpid(empresa.getEmpid());
			emp.setCidid(empresa.getCidid());
			emp.setCnaeid(empresa.getCnaeid());
			emp.setEmpcnpj(empresa.getEmpcnpj());
			emp.setEmpnome(empresa.getEmpnome());
			emp.setEmporigem(empresa.getEmporigem());
			return emp;
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
