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

import com.grupo3.finddata.repositorys.CidadeRepository;
import com.grupo3.finddata.repositorys.CnaeRepository;
import com.grupo3.finddata.repositorys.ConsumoRepository;
import com.grupo3.finddata.repositorys.EmpresaRepository;
import com.grupo3.finddata.classes.dto.*;
import com.grupo3.finddata.classes.Empresa;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController 
{
	
	private EmpresaRepository empresaRepository = null;
	private CnaeRepository cnaeRepository = null;
	private ConsumoRepository consumoRepository = null;
	private CidadeRepository cidadeRepository = null;
	
	public EmpresaController(EmpresaRepository empresaRepository, CnaeRepository cnaeRepository, 
							 ConsumoRepository consumoRepository, CidadeRepository cidadeRepository) 
	{
		this.empresaRepository = empresaRepository;
		this.cnaeRepository = cnaeRepository;
		this.consumoRepository = consumoRepository;
		this.cidadeRepository = cidadeRepository;
	}
	
	@GetMapping("/")
	public List<EmpresaRs> selectAll() 
	{
		List<EmpresaRs> lstEmpresa = new ArrayList<>();
			
		var empresa = empresaRepository.SelectOrdem();
		
		for(Empresa e : empresa)
		{
			EmpresaRs empresaRs = EmpresaRs.converter(e, cnaeRepository.SelectCnaeId(e.getCnaeid()),
					 consumoRepository.selectConsumoCnpj(e.getEmpcnpj()),
					 cidadeRepository.SelectCidadeId(e.getCidid()));
			lstEmpresa.add(empresaRs);
		}
				
		return lstEmpresa;	
	}
	
	//Selecionando cnaes da empresa
	@GetMapping("/ordem")
	public List<EmpresaRs> selectAllOrdem() 
	{
		List<EmpresaRs> lstEmpresa = new ArrayList<>();
			
		var empresa = empresaRepository.SelectOrdemAll();
		
		for(Empresa e : empresa)
		{
			EmpresaRs empresaRs = EmpresaRs.converter(e, cnaeRepository.SelectCnaeId(e.getCnaeid()),
					 consumoRepository.selectConsumoCnpj(e.getEmpcnpj()),
					 cidadeRepository.SelectCidadeId(e.getCidid()));
			lstEmpresa.add(empresaRs);
		}
				
		return lstEmpresa;	
	}
	
	//Selecionando cidades das empresas
	@GetMapping("/cidades")
	public List<EmpresaRs> selectAllCidades() 
	{
		List<EmpresaRs> lstEmpresa = new ArrayList<>();
			
		var empresa = empresaRepository.SelectEmpCidades();
		
		for(Empresa e : empresa)
		{
			EmpresaRs empresaRs = EmpresaRs.converter(e, cnaeRepository.SelectCnaeId(e.getCnaeid()),
														 consumoRepository.selectConsumoCnpj(e.getEmpcnpj()),
														 cidadeRepository.SelectCidadeId(e.getCidid()));
			lstEmpresa.add(empresaRs);
		}
				
		return lstEmpresa;	
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
				
		List<EmpresaRs> lstEmpresa = new ArrayList<>();
		
		var empresa = empresaRepository.SelectEmpNome(nome);
		
		for(Empresa e : empresa)
		{
			EmpresaRs empresaRs = EmpresaRs.converter(e, cnaeRepository.SelectCnaeId(e.getCnaeid()),
					 consumoRepository.selectConsumoCnpj(e.getEmpcnpj()),
					 cidadeRepository.SelectCidadeId(e.getCidid()));
			lstEmpresa.add(empresaRs);
		}
				
		return lstEmpresa;	
				
	}
	
	// SELECT por cnae
	@GetMapping("/cnae") 
	public List<EmpresaRs> findEmpresaByCnae(@RequestParam(value = "cnae", required = false) String cnae)
	{
				
		List<EmpresaRs> lstEmpresa = new ArrayList<>();
		
		var empresa = empresaRepository.SelectEmpCnae(cnae);
		
		for(Empresa e : empresa)
		{
			EmpresaRs empresaRs = EmpresaRs.converter(e, cnaeRepository.SelectCnaeId(e.getCnaeid()),
					 consumoRepository.selectConsumoCnpj(e.getEmpcnpj()),
					 cidadeRepository.SelectCidadeId(e.getCidid()));
			lstEmpresa.add(empresaRs);
		}
				
		return lstEmpresa;	
				
	}
	
	// SELECT por regiao
	@GetMapping("/regiao") 
	public List<EmpresaRs> findEmpresaByRegiao(@RequestParam(value = "regiao", required = false) String regiao)
	{
				
		List<EmpresaRs> lstEmpresa = new ArrayList<>();
		
		var empresa = empresaRepository.SelectEmpRegiao(regiao);
		
		for(Empresa e : empresa)
		{
			EmpresaRs empresaRs = EmpresaRs.converter(e, cnaeRepository.SelectCnaeId(e.getCnaeid()),
					 consumoRepository.selectConsumoCnpj(e.getEmpcnpj()),
					 cidadeRepository.SelectCidadeId(e.getCidid()));
			lstEmpresa.add(empresaRs);
		}
				
		return lstEmpresa;	
				
	}
	
	// SELECT todos os filtros
	@GetMapping("/filtros") 
	public List<EmpresaRs> findEmpresaFiltros(@RequestParam(value = "cnae", required = false) String cnae, 
											  @RequestParam(value = "nome", required = false) String nome,
											  @RequestParam(value = "regiao", required = false) String regiao)
	{
				
		List<EmpresaRs> lstEmpresa = new ArrayList<>();
		
		var empresa = empresaRepository.SelectEmpFiltros(regiao, nome, cnae );
		
		for(Empresa e : empresa)
		{
			EmpresaRs empresaRs = EmpresaRs.converter(e, cnaeRepository.SelectCnaeId(e.getCnaeid()),
					 consumoRepository.selectConsumoCnpj(e.getEmpcnpj()),
					 cidadeRepository.SelectCidadeId(e.getCidid()));
			lstEmpresa.add(empresaRs);
		}
				
		return lstEmpresa;	
				
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
	    emp.setCartid(empresa.getCartid());
	    empresaRepository.save(emp);

	}
	
	  // UPDATE
	  @PutMapping("/{id}")
	  public void updateEmpresa(@PathVariable Long id, @RequestBody EmpresaRq empresa) throws Exception 
	  {
	    var emp = empresaRepository.findById(id);

	    if (emp.isPresent()) 
	    { 
	      var emp2 = emp.get();

	      emp2.setCidid(empresa.getCidid());
	      emp2.setCnaeid(empresa.getCnaeid());
	      emp2.setEmpcnpj(empresa.getEmpcnpj());
	      emp2.setEmpnome(empresa.getEmpnome());
	      emp2.setEmporigem(empresa.getEmporigem());
	      emp2.setCartid(empresa.getCartid());
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
