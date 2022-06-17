package com.grupo3.finddata.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.finddata.classes.Cidade;
import com.grupo3.finddata.classes.Cnae;
import com.grupo3.finddata.classes.dto.CidadeRq;
import com.grupo3.finddata.classes.dto.CidadeRs;
import com.grupo3.finddata.classes.dto.CnaeRq;
import com.grupo3.finddata.classes.dto.CnaeRs;
import com.grupo3.finddata.repositorys.CidadeRepository;
import com.grupo3.finddata.repositorys.CnaeRepository;
import com.grupo3.finddata.service.CnaeService;

@RestController
@RequestMapping(value = "/cnae")
public class CnaeController 
{
	
	@Autowired
	private CnaeRepository cnaeRepository;
	@Autowired
	private CnaeService service;
	
	// SELECT de todos//
	@GetMapping("/all")
	public List<CnaeRs> selectAll()
	{
	   return service.selectAll();
	}
	
	// SELECT de todos//
	@GetMapping("/")
	public List<CnaeRs> selectCnae()
	{
	  return service.selectCnae();
	}
		  
	// SELECT por ID //
	@GetMapping("/{id}")
	public CnaeRs selectID(@PathVariable("id") Long id) 
	{
	  return service.selectID(id);
	}
	
	// SELECT por ID //
	@GetMapping("/cod")
	public CnaeRs selectCnpj(@RequestParam(value = "cod", required = false) String cod) 
	{
	  return service.selectCnpj(cod);
	}
		  
		
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertCnae(@RequestBody CnaeRq cnae) throws Exception
	{
	    service.insertCnae(cnae);
	 }
		
		
	// UPDATE
	@PutMapping("/{id}")
	public void updateCnae(@PathVariable Long id, @RequestBody CnaeRq cnae) throws Exception 
	{
	    service.updateCnae(id, cnae);		    
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteCnae(@PathVariable Long id) 
	{
	    service.deleteCnae(id);
	}

}
