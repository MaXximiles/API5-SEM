package com.grupo3.finddata.classes.dto;

import java.util.ArrayList;
import java.util.List;

import com.grupo3.finddata.classes.Cidade;

public class CidadeRs 
{
	private Long cid_id;
	private String cid_cidade;
	private String cid_estado;
	private String cid_regiaoibge;
	
	public Long getCid_id() {
		return cid_id;
	}
	public void setCid_id(Long cid_id) {
		this.cid_id = cid_id;
	}
	public String getCid_cidade() {
		return cid_cidade;
	}
	public void setCid_cidade(String cid_cidade) {
		this.cid_cidade = cid_cidade;
	}
	public String getCid_estado() {
		return cid_estado;
	}
	public void setCid_estado(String cid_estado) {
		this.cid_estado = cid_estado;
	}
	public String getCid_regiaoibge() {
		return cid_regiaoibge;
	}
	public void setCid_regiaoibge(String cid_regiaoibge) {
		this.cid_regiaoibge = cid_regiaoibge;
	}
	
	public static CidadeRs converter(Cidade cidade) 
	{
			var cid = new CidadeRs();
			cid.setCid_id(cidade.getCid_id());
			cid.setCid_cidade(cidade.getCid_cidade());
			cid.setCid_estado(cidade.getCid_estado());
			cid.setCid_regiaoibge(cidade.getCid_regiaoibge());
			return cid;
	}
	
	public static List<CidadeRs> converter(List<Cidade> lstCidade) 
	{
		List<CidadeRs> listCidade = new ArrayList<>();
		
		for(Cidade td : lstCidade)
		{
			
			listCidade.add(CidadeRs.converter(td));
		}
		
		return listCidade;
	}

	
}
