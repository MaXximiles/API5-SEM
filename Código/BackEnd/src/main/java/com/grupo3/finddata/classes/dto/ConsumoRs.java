package com.grupo3.finddata.classes.dto;

import java.util.ArrayList;
import java.util.List;

import com.grupo3.finddata.classes.Cnae;
import com.grupo3.finddata.classes.Consumo;

public class ConsumoRs 
{
	private Long cons_id;
	private String cons_mes;
	private String cons_qtdconsumo;
	private String emp_id;
	
	public Long getCons_id() {
		return cons_id;
	}

	public void setCons_id(Long cons_id) {
		this.cons_id = cons_id;
	}

	public String getCons_mes() {
		return cons_mes;
	}

	public void setCons_mes(String cons_mes) {
		this.cons_mes = cons_mes;
	}

	public String getCons_qtdconsumo() {
		return cons_qtdconsumo;
	}

	public void setCons_qtdconsumo(String cons_qtdconsumo) {
		this.cons_qtdconsumo = cons_qtdconsumo;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	
	public static List<ConsumoRs> converter(List<Consumo> lstConsumo) 
	{
		List<ConsumoRs> listConsumo = new ArrayList<>();
		
		for(Consumo td : lstConsumo)
		{
			
			listConsumo.add(ConsumoRs.converter(td));
		}
		
		return listConsumo;
	}
	
	
	public static ConsumoRs converter(Consumo consumo) 
	{
			var cons = new ConsumoRs();
			cons.setCons_id(consumo.getCons_id());
			cons.setCons_mes(consumo.getCons_mes());
			cons.setCons_qtdconsumo(consumo.getCons_qtdconsumo());
			cons.setEmp_id(consumo.getEmp_id());
			return cons;
	}

}
