package com.grupo3.finddata.classes.dto;

import java.util.ArrayList;
import java.util.List;

import com.grupo3.finddata.classes.Cnae;

public class CnaeRs 
{
	
	private Long cnae_id;
	private String cnae_codigo;
	private String cnae_descricao;
	
	public Long getCnae_id() {
		return cnae_id;
	}
	public void setCnae_id(Long cnae_id) {
		this.cnae_id = cnae_id;
	}
	public String getCnae_codigo() {
		return cnae_codigo;
	}
	public void setCnae_codigo(String cnae_codigo) {
		this.cnae_codigo = cnae_codigo;
	}
	public String getCnae_descricao() {
		return cnae_descricao;
	}
	public void setCnae_descricao(String cnae_descricao) {
		this.cnae_descricao = cnae_descricao;
	}
	
	
	public static CnaeRs converter(Cnae cnae) 
	{
			var cnae2 = new CnaeRs();
			cnae2.setCnae_codigo(cnae.getCnae_codigo());
			cnae2.setCnae_descricao(cnae.getCnae_descricao());
			cnae2.setCnae_id(cnae.getCnae_id());
			return cnae2;
	}
	
	public static List<CnaeRs> converter(List<Cnae> lstCnae) 
	{
		List<CnaeRs> listCnae = new ArrayList<>();
		
		for(Cnae td : lstCnae)
		{
			
			listCnae.add(CnaeRs.converter(td));
		}
		
		return listCnae;
	}
}
