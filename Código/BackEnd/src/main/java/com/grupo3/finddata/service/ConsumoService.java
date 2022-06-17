package com.grupo3.finddata.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo3.finddata.classes.Consumo;
import com.grupo3.finddata.classes.dto.ConsumoRq;
import com.grupo3.finddata.classes.dto.ConsumoRs;
import com.grupo3.finddata.repositorys.ConsumoRepository;

@Service
public class ConsumoService 
{
	@Autowired
	private ConsumoRepository consumoRepository;
	
	
	public List<ConsumoRs> selectAll()
	{
	   var consumo = consumoRepository.findAll();
	   return consumo.stream().map((cid) -> ConsumoRs.converter(cid)).collect(Collectors.toList());
	}
		  
	public ConsumoRs selectID(Long id) 
	{
	  var cons = consumoRepository.getOne(id);
	  return ConsumoRs.converter(cons);
	}

	public List<ConsumoRs> findConsumoByEmpresaId(String cnpj)
	{
	    return this.consumoRepository.selectConsumoCnpj(cnpj).stream().map(ConsumoRs::converter).collect(Collectors.toList());
	}
				
	public void insertConsumo(@RequestBody ConsumoRq consumo) throws Exception
	{
	    var cons = new Consumo();

	    cons.setCons_mes(consumo.getCons_mes());
	    cons.setCons_qtdconsumo(consumo.getCons_qtdconsumo());
	    cons.setEmp_id(consumo.getEmp_id());
	    
	    consumoRepository.save(cons);

	 }

	public void updateConsumo(Long id,ConsumoRq consumo) throws Exception 
	{
	    var cons = consumoRepository.findById(id);
	    
	    if (cons.isPresent()) 
	    {     
		      var cons2 = cons.get();

		      cons2.setCons_mes(consumo.getCons_mes());
		      cons2.setCons_qtdconsumo(consumo.getCons_qtdconsumo());
		      cons2.setEmp_id(consumo.getEmp_id());
		      consumoRepository.save(cons2);

		} else { throw new Exception("Não foi possivel atualizar esse consumo"); }
		    
	}

	public void deleteConsumo(Long id) 
	{
	    consumoRepository.deleteById(id);
	}
}
