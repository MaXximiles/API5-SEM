package com.grupo3.finddata.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo3.finddata.classes.Cnae;
import com.grupo3.finddata.classes.dto.CnaeRq;
import com.grupo3.finddata.classes.dto.CnaeRs;
import com.grupo3.finddata.repositorys.CnaeRepository;

@Service
public class CnaeService 
{
	@Autowired
	private CnaeRepository cnaeRepository;

	public List<CnaeRs> selectAll()
	{
	   var cnae = cnaeRepository.findAll();
	   return cnae.stream().map((cid) -> CnaeRs.converter(cid)).collect(Collectors.toList());
	}
	
	public List<CnaeRs> selectCnae()
	{
	   var cnae = cnaeRepository.SelectCnae();
	   return cnae.stream().map((cid) -> CnaeRs.converter(cid)).collect(Collectors.toList());
	}

	public CnaeRs selectID(Long id) 
	{
	  var cnae = cnaeRepository.getOne(id);
	  return CnaeRs.converter(cnae);
	}
	
	public CnaeRs selectCnpj(String cod) 
	{
	  var cnae = cnaeRepository.SelectCnaeCnpj(cod);
	  return CnaeRs.converter(cnae);
	}
		  
	public void insertCnae(CnaeRq cnae) throws Exception
	{
	    var cnae2 = new Cnae();

	    cnae2.setCnae_codigo(cnae.getCnae_codigo());
	    cnae2.setCnae_descricao(cnae.getCnae_descricao());
	        
	    cnaeRepository.save(cnae2);

	 }
		
	public void updateCnae(Long id,CnaeRq cnae) throws Exception 
	{
	    var cnae2 = cnaeRepository.findById(id);
	    
	    if (cnae2.isPresent()) 
	    {     
		      var cnae3 = cnae2.get();

		      cnae3.setCnae_codigo(cnae.getCnae_codigo());
		      cnae3.setCnae_descricao(cnae.getCnae_descricao());
		      cnaeRepository.save(cnae3);

		} else { throw new Exception("CNAE não encontrado"); }
		    
	}

	public void deleteCnae(Long id) 
	{
	    cnaeRepository.deleteById(id);
	}

}
