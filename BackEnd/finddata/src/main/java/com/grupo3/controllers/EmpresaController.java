package com.grupo3.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.repositorys.EmpresaRepository;
import com.grupo3.classes.dto.*;
import com.grupo3.classes.Empresa;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController 
{
	
	private EmpresaRepository empresaRepository = null;
	
	public EmpresaController(EmpresaController empresaController) {this.empresaRepository = empresaRepository; }
	
	 // SELECT de todos//
	 @GetMapping("/")
	 public List<EmpresaRs> selectAll()
	 {
	   var empresa = empresaRepository.findAll();
	   return empresa.stream().map((emp) -> EmpresaRs.converter(emp)).collect(Collectors.toList());
	 }
	  
	// SELECT por ID //
	@GetMapping("/{id}")
	public EmpresaRs selectID(@PathVariable("id") Long id) 
	{
	  var emp = empresaRepository.getOne(id);
	  return EmpresaRs.converter(emp);
	}
	  
    // SELECT por Nome
	@GetMapping("/filtrocnpj")
	public List<EmpresaRs> findEmpresaBycnpj(@RequestParam("cnpj") String cnpj)
	{
	    return this.empresaRepository.findEmpresaBycnpjContains(cnpj).stream().map(EmpresaRs::converter).collect(Collectors.toList());
	}
	
	// FIM DOS SELECT's **********************************************************************
	
	
	// INSERT //
	@PostMapping("/")
    public void insertEmpresa(@RequestBody EmpresaRq empresa) throws Exception
	{
	    var emp = new Empresa();

	    emp.setCnae_id(empresa.getCnae_id());
	    emp.setEmp_cnpj(empresa.getEmp_cnpj());
	    emp.setCid_id(empresa.getCid_id());
	    emp.setEmp_nome(empresa.getEmp_nome());
	    emp.setEmp_origem(empresa.getEmp_origem());

	    empresaRepository.save(emp);

	  }
	
	
	  // UPDATE
	  @PutMapping("/{id}")
	  public void updateEmpresa(@PathVariable Long id, @RequestBody EmpresaRq empresa) throws Exception 
	  {
	    var emp = empresaRepository.findById(id);

	    if (emp.isPresent()) {
	     
	      var emp2 = emp.get();

	      emp2.setCid_id(empresa.getCid_id());
	      emp2.setCnae_id(empresa.getCnae_id());
	      emp2.setEmp_cnpj(empresa.getEmp_cnpj());
	      emp2.setEmp_nome(empresa.getEmp_nome());
	      emp2.setEmp_origem(empresa.getEmp_origem());
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
