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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.finddata.classes.dto.CarteiraVendedorRq;
import com.grupo3.finddata.classes.dto.CarteiraVendedorRs;
import com.grupo3.finddata.service.CarteiraVendedorService;

@RestController
@RequestMapping(value = "/carteira")
public class CarteiraVendedorController 
{

	@Autowired
	private CarteiraVendedorService service;
		
	// SELECT de todos//
	@GetMapping("/all")
	public List<CarteiraVendedorRs> selectAll()
	{
	   return service.selectAll();
	}
	
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira")
	public List<CarteiraVendedorRs> selectCarteira(@RequestParam(value = "usuid", required = false) String usuid,
								 				   @RequestParam(value = "empid", required = false) String empid) 
	{
	   return service.selectCarteira(usuid, empid);
	}
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/nome")
	public List<CarteiraVendedorRs> selectCarteiraEmpUsuNome(@RequestParam(value = "usunome", required = false) String usunome,
								 				   			 @RequestParam(value = "empnome", required = false) String empnome) 
	{
	  return service.selectCarteiraConcluidaEmpUsuNome(usunome, empnome);
	}
		
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteirasPendentes") 
	public List<CarteiraVendedorRs> selectCarteirasPendentes() 
	{	
		return service.selectCarteirasPendentes();
	}
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/concluida/nome")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNome(@RequestParam(value = "usunome", required = false) String usunome,
								 				   			 		  @RequestParam(value = "empnome", required = false) String empnome) 
	{
	  return service.selectCarteiraConcluidaEmpUsuNome(usunome, empnome);
	}
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/vendedor")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNome(@RequestParam(value = "idvende", required = false) String idvende) 
	{
	  return service.selectCarteiraConcluidaEmpUsuNome(idvende);
	}
	 
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/vendedor/filtro")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaVendedor(@RequestParam(value = "idvende", required = false) String idvende,
									 								@RequestParam(value = "empresa", required = false) String empresa) 
	{
	  return service.selectCarteiraConcluidaVendedor(idvende, empresa);
	}
	
	
	// Verificando se existe carteira prospecção vendedor empresa//
	@GetMapping("/carteira/vendedor/prospec")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNomeProsp(@RequestParam(value = "idvende", required = false) String idvende) 
	{
	  return service.selectCarteiraConcluidaEmpUsuNomeProsp(idvende);
	}
		
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/vendedor/prospec/filtro")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaVendedorProsp(@RequestParam(value = "idvende", required = false) String idvende,
									 								@RequestParam(value = "empresa", required = false) String empresa) 
	{
	  return service.selectCarteiraConcluidaVendedorProsp(idvende, empresa);
	}
		
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/top/vendedor")
	public List<CarteiraVendedorRs> selectCarteiraTopVendedor() 
	{
	  return service.selectCarteiraTopVendedor();
	}
	
	// Lista de Top 8 Empresas //
	@GetMapping("/top/vendedores")
	public List<CarteiraVendedorRs> selectCarteiraTopVendedores() 
	{
	  return service.selectCarteiraTopVendedores();
	}
	
	// Lista de Top 8 Vendedores //
	@GetMapping("/top/regiao")
	public List<CarteiraVendedorRs> selectCarteiraTopRegiao() 
	{
	  return service.selectCarteiraTopRegiao();
	}
	
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertCarteira(@RequestBody CarteiraVendedorRq carteira) throws Exception
	{
		service.insertCarteira(carteira);
	 }
		
		
	// UPDATE
	@PutMapping("/{id}")
	public void updateCarteira(@PathVariable Long id, @RequestBody CarteiraVendedorRq carteira) throws Exception 
	{
	    service.updateCarteira(id, carteira);
	}
	

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteCarteira(@PathVariable Long id) 
	{
	    service.deleteCarteira(id);
	}
}
