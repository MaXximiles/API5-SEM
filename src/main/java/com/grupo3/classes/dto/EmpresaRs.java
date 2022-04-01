package com.grupo3.classes.dto;

import com.grupo3.classes.Empresa;

public class EmpresaRs 
{
	  private Long emp_id;
	  private String emp_nome;
	  private String emp_cnpj;
	  private Long cid_id;
	  private Long cnae_id;
	  private String emp_origem;
	  
	  
	  public static EmpresaRs converter(Empresa empresa) 
	  {
			var emp = new EmpresaRs();
			emp.setEmp_id(empresa.getEmp_id());
			emp.setCid_id(empresa.getCid_id());
			emp.setCnae_id(empresa.getCnae_id());
			emp.setEmp_cnpj(empresa.getEmp_cnpj());
			emp.setEmp_nome(empresa.getEmp_nome());
			emp.setEmp_origem(empresa.getEmp_origem());
			return emp;
	}
	  
	  
	  
	  
	  
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
	  
	  
}
