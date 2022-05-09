package com.grupo3.finddata.controllers;

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

import com.grupo3.finddata.classes.Cidade;
import com.grupo3.finddata.classes.Cnae;
import com.grupo3.finddata.classes.dto.CidadeRq;
import com.grupo3.finddata.classes.dto.CidadeRs;
import com.grupo3.finddata.classes.dto.CnaeRq;
import com.grupo3.finddata.classes.dto.CnaeRs;
import com.grupo3.finddata.repositorys.CidadeRepository;
import com.grupo3.finddata.repositorys.CnaeRepository;

@RestController
@RequestMapping(value = "/cnae")
public class CnaeController 
{
	
	private CnaeRepository cnaeRepository = null;
	
	public CnaeController(CnaeRepository cnaeRepository) {this.cnaeRepository = cnaeRepository; }
	
	// SELECT de todos//
	@GetMapping("/all")
	public List<CnaeRs> selectAll()
	{
	   var cnae = cnaeRepository.findAll();
	   return cnae.stream().map((cid) -> CnaeRs.converter(cid)).collect(Collectors.toList());
	}
	
	// SELECT de todos//
	@GetMapping("/")
	public List<CnaeRs> selectCnae()
	{
	   var cnae = cnaeRepository.SelectCnae();
	   return cnae.stream().map((cid) -> CnaeRs.converter(cid)).collect(Collectors.toList());
	}
		  
	// SELECT por ID //
	@GetMapping("/{id}")
	public CnaeRs selectID(@PathVariable("id") Long id) 
	{
	  var cnae = cnaeRepository.getOne(id);
	  return CnaeRs.converter(cnae);
	}
	
	// SELECT por ID //
	@GetMapping("/cod")
	public CnaeRs selectCnpj(@RequestParam(value = "cod", required = false) String cod) 
	{
	  var cnae = cnaeRepository.SelectCnaeCnpj(cod);
	  return CnaeRs.converter(cnae);
	}
		  
	// SELECT por Nome
	/*@GetMapping("/filtrocnae")
	public List<CnaeRs> findCnaeByDesc(@RequestParam("cnae") String cnae)
	{
	    return this.cnaeRepository.findCnaeByDescContains(cnae).stream().map(CnaeRs::converter).collect(Collectors.toList());
	}*/
		
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertCnae(@RequestBody CnaeRq cnae) throws Exception
	{
	    var cnae2 = new Cnae();

	    cnae2.setCnae_codigo(cnae.getCnae_codigo());
	    cnae2.setCnae_descricao(cnae.getCnae_descricao());
	        
	    cnaeRepository.save(cnae2);

	 }
		
		
	// UPDATE
	@PutMapping("/{id}")
	public void updateCnae(@PathVariable Long id, @RequestBody CnaeRq cnae) throws Exception 
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

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteCnae(@PathVariable Long id) 
	{
	    cnaeRepository.deleteById(id);
	}

}
