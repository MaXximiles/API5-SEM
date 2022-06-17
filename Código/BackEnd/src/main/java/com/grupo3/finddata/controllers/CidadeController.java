package com.grupo3.finddata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.grupo3.finddata.classes.dto.CidadeRq;
import com.grupo3.finddata.classes.dto.CidadeRs;
import com.grupo3.finddata.service.CidadeService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController
{
	@Autowired
	private CidadeService service;
	
	// SELECT de todos//
	@GetMapping("/all")
	public List<CidadeRs> selectAll()
	{
	   return service.selectAll();
	}
	
	// SELECT de todos//
	@GetMapping("/")
	public List<CidadeRs> selectAllOrderBy()
	{
	  return service.selectAllOrderBy();
	}
	  
	// SELECT por ID //
	@GetMapping("/{id}")
	public CidadeRs selectID(@PathVariable("id") Long id) 
	{
	  return service.selectID(id);
	}
		  	
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertCidade(@RequestBody CidadeRq cidade) throws Exception
	{
	    service.insertCidade(cidade);
	 }
		
		
	// UPDATE
	@PutMapping("/{id}")
	public void updateCidade(@PathVariable Long id, @RequestBody CidadeRq cidade) throws Exception 
	{
	   service.updateCidade(id, cidade);
		    
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteCidade(@PathVariable Long id) 
	{
	    service.deleteCidade(id);
	}

}