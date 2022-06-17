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
import com.grupo3.finddata.classes.Consumo;
import com.grupo3.finddata.classes.dto.CidadeRq;
import com.grupo3.finddata.classes.dto.CidadeRs;
import com.grupo3.finddata.classes.dto.ConsumoRq;
import com.grupo3.finddata.classes.dto.ConsumoRs;
import com.grupo3.finddata.repositorys.CidadeRepository;
import com.grupo3.finddata.repositorys.ConsumoRepository;
import com.grupo3.finddata.service.ConsumoService;

@RestController
@RequestMapping(value = "/consumo")
public class ConsumoController 
{
	@Autowired
	private ConsumoRepository consumoRepository;
	@Autowired
	private ConsumoService service;
	
	
	// SELECT de todos//
	@GetMapping("/")
	public List<ConsumoRs> selectAll()
	{
	   return service.selectAll();
	}
		  
	// SELECT por ID //
	@GetMapping("/{id}")
	public ConsumoRs selectID(@PathVariable("id") Long id) 
	{
	  return service.selectID(id);
	}
		  
	// SELECT por Nome
	@GetMapping("/cnpj")
	public List<ConsumoRs> findConsumoByEmpresaId(@RequestParam("cnpj") String cnpj)
	{
	    return service.findConsumoByEmpresaId(cnpj);
	}
		
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertConsumo(@RequestBody ConsumoRq consumo) throws Exception
	{
	    service.insertConsumo(consumo);

	 }
		
		
	// UPDATE
	@PutMapping("/{id}")
	public void updateConsumo(@PathVariable Long id, @RequestBody ConsumoRq consumo) throws Exception 
	{
	    service.updateConsumo(id, consumo);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteConsumo(@PathVariable Long id) 
	{
	    service.deleteConsumo(id);
	}
}
