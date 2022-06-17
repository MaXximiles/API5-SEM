package com.grupo3.finddata.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

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

import com.grupo3.finddata.repositorys.CidadeRepository;
import com.grupo3.finddata.repositorys.CnaeRepository;
import com.grupo3.finddata.repositorys.ConsumoRepository;
import com.grupo3.finddata.repositorys.EmpresaRepository;
import com.grupo3.finddata.service.EmpresaService;
import com.grupo3.finddata.classes.dto.*;
import com.grupo3.finddata.classes.Empresa;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController 
{
	
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private CnaeRepository cnaeRepository;
	@Autowired
	private ConsumoRepository consumoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EmpresaService service;
	
	@GetMapping("/")
	public List<EmpresaRs> selectAll() 
	{
		return service.listaTodas();
	}
	
	//Selecionando cnaes da empresa
	@GetMapping("/ordem")
	public List<EmpresaRs> selectAllOrdem() 
	{
		return service.listaTodasOrdem();
	}
	
	//Selecionando cidades das empresas
	@GetMapping("/cidades")
	public List<EmpresaRs> selectAllCidades() 
	{
		return service.listaTodasCidades();
	}
	  
	// SELECT por ID //
	@GetMapping("/{id}")
	public EmpresaRs selectID(@PathVariable("id") Long id) 
	{
	  var emp = empresaRepository.getOne(id);
	  return EmpresaRs.converter(emp, null, null, null);
	  
	}
	
	
	  
    // SELECT por nome
	@GetMapping("/filtronome") 
	public List<EmpresaRs> findEmpresaByempnome(@RequestParam(value = "nome", required = false) String nome)
	{
		return service.selectEmpresaNome(nome);
	}
	
	// SELECT por cnae
	@GetMapping("/cnae") 
	public List<EmpresaRs> findEmpresaByCnae(@RequestParam(value = "cnae", required = false) String cnae)
	{
		return service.selectEmpresaCnae(cnae);
	}
	
	// SELECT por regiao
	@GetMapping("/regiao") 
	public List<EmpresaRs> findEmpresaByRegiao(@RequestParam(value = "regiao", required = false) String regiao)
	{
		return service.selectEmpresaRegiao(regiao);
	}
	
	// SELECT todos os filtros
	@GetMapping("/filtros") 
	public List<EmpresaRs> findEmpresaFiltros(@RequestParam(value = "cnae", required = false) String cnae, 
											  @RequestParam(value = "nome", required = false) String nome,
											  @RequestParam(value = "regiao", required = false) String regiao)
	{
				
		return service.selectEmpresaFiltros(cnae, nome, regiao);
				
	}
		
	// FIM DOS SELECT's **********************************************************************
	
	
	// INSERT //
	@PostMapping("/")
    public void insertEmpresa(@RequestBody EmpresaRq empresa) throws Exception
	{ 
	    service.insertEmpresa(empresa);
	}
	
	  // UPDATE
	  @PutMapping("/{id}")
	  public void updateEmpresa(@PathVariable Long id, @RequestBody EmpresaRq empresa) throws Exception 
	  {
	    service.updateEmpresa(id, empresa);
	  }

	  // DELETE
	  @DeleteMapping("/{id}")
	  public void deleteEmpresa(@PathVariable Long id) 
	  {
	    empresaRepository.deleteById(id);
	  }
	
}
