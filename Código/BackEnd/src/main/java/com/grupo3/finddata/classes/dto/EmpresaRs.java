package com.grupo3.finddata.classes.dto;

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
	  
	  private List<CnaeRs> cnae;
	  
	  public static EmpresaRs converter(Empresa empresa, List<Cnae> lstCnae) 
	  {
			var emp = new EmpresaRs();
			emp.setEmpid(empresa.getEmpid());
			emp.setCidid(empresa.getCidid());
			emp.setCnaeid(empresa.getCnaeid());
			emp.setEmpcnpj(empresa.getEmpcnpj());
			emp.setEmpnome(empresa.getEmpnome());
			emp.setEmporigem(empresa.getEmporigem());
			
			emp.setCnae(CnaeRs.converter(lstCnae));
			return emp;
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
