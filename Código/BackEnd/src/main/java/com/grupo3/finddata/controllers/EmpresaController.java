package com.grupo3.finddata.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.finddata.repositorys.CnaeRepository;
import com.grupo3.finddata.repositorys.EmpresaRepository;
import com.grupo3.finddata.classes.dto.*;
import com.grupo3.finddata.classes.Empresa;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController 
{
	
	private EmpresaRepository empresaRepository = null;
	private CnaeRepository cnaeRepository = null;
	
	public EmpresaController(EmpresaRepository empresaRepository, CnaeRepository cnaeRepository) 
	{
		this.empresaRepository = empresaRepository;
		this.cnaeRepository = cnaeRepository;
	}
	
	 // SELECT de todos//
	 /*@GetMapping("/")
	 public List<EmpresaRs> selectAll()
	 {
	   var empresa = empresaRepository.findAll();
	   return empresa.stream().map((emp) -> EmpresaRs.converter(emp)).collect(Collectors.toList());
	 }*/
	 
	// SELECT de todos//
	 /*@GetMapping("/")
	 public List<EmpresaRs> selectAll()
	 {
	   var empresa = empresaRepository.SelectOrdem();
	   return empresa.stream().map((emp) -> EmpresaRs.converter(emp)).collect(Collectors.toList());
	 }*/
	
	// SELECT Bloco por ID trazendo os traÃ§os com Tags //
	@GetMapping("/")
	public List<EmpresaRs> selectAll() 
	{
				
		 List<EmpresaRs> lstEmpresa = new ArrayList<>();
			
			var empresa = empresaRepository.SelectOrdem();
			
			for(Empresa e : empresa)
			{
				EmpresaRs empresaRs = EmpresaRs.converter(e, cnaeRepository.SelectCnaeId(e.getCnaeid()));
				lstEmpresa.add(empresaRs);
			}
					
			return lstEmpresa;	
	}
	  
	// SELECT por ID //
	@GetMapping("/{id}")
	public EmpresaRs selectID(@PathVariable("id") Long id) 
	{
	  var emp = empresaRepository.getOne(id);
	  return EmpresaRs.converter(emp, null);
	  
	}
	  
    // SELECT por nome
	@GetMapping("/filtronome") 
	public List<EmpresaRs> findEmpresaByempnome(@RequestParam(value = "nome", required = false) String nome)
	{
		var empresa = empresaRepository.SelectEmpNome(nome);
		//return empresa.stream().map(EmpresaRs::converter).collect(Collectors.toList());
		return empresa.stream().map((empList) -> EmpresaRs.converter(empList, Collections.EMPTY_LIST)).collect(Collectors.toList());
		
	}
		
	// FIM DOS SELECT's **********************************************************************
	
	
	// INSERT //
	@PostMapping("/")
    public void insertEmpresa(@RequestBody EmpresaRq empresa) throws Exception
	{ 
	    var emp = new Empresa();

	    emp.setCnaeid(empresa.getCnaeid());
	    emp.setEmpcnpj(empresa.getEmpcnpj());
	    emp.setCidid(empresa.getCidid());
	    emp.setEmpnome(empresa.getEmpnome());
	    emp.setEmporigem(empresa.getEmporigem());

	    empresaRepository.save(emp);

	  }
	
	
	  // UPDATE
	  @PutMapping("/{id}")
	  public void updateEmpresa(@PathVariable Long id, @RequestBody EmpresaRq empresa) throws Exception 
	  {
	    var emp = empresaRepository.findById(id);

	    if (emp.isPresent()) {
	     
	      var emp2 = emp.get();

	      emp2.setCidid(empresa.getCidid());
	      emp2.setCnaeid(empresa.getCnaeid());
	      emp2.setEmpcnpj(empresa.getEmpcnpj());
	      emp2.setEmpnome(empresa.getEmpnome());
	      emp2.setEmporigem(empresa.getEmporigem());
	      empresaRepository.save(emp2);

	    } else { throw new Exception("Empresa não encontrada"); }
	    
	  }

	  // DELETE
	  @DeleteMapping("/{id}")
	  public void deleteEmpresa(@PathVariable Long id) 
	  {
	    empresaRepository.deleteById(id);
	  }
	
}
