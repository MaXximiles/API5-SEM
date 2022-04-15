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
import com.grupo3.finddata.classes.dto.CidadeRq;
import com.grupo3.finddata.classes.dto.CidadeRs;
import com.grupo3.finddata.repositorys.CidadeRepository;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController
{
	private CidadeRepository cidadeRepository = null;
	
	public CidadeController(CidadeRepository CidadeRepository) {this.cidadeRepository = CidadeRepository; }
	
	// SELECT de todos//
	@GetMapping("/all")
	public List<CidadeRs> selectAll()
	{
	   var cidade = cidadeRepository.findAll();
	   return cidade.stream().map((cid) -> CidadeRs.converter(cid)).collect(Collectors.toList());
	}
	
	// SELECT de todos//
	@GetMapping("/")
	public List<CidadeRs> selectAllOrderBy()
	{
	   var cidade = cidadeRepository.SelectCidade();
	   return cidade.stream().map((cid) -> CidadeRs.converter(cid)).collect(Collectors.toList());
	}
	  
	// SELECT por ID //
	@GetMapping("/{id}")
	public CidadeRs selectID(@PathVariable("id") Long id) 
	{
	  var cid = cidadeRepository.getOne(id);
	  return CidadeRs.converter(cid);
	}
		  	
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertCidade(@RequestBody CidadeRq cidade) throws Exception
	{
	    var cid = new Cidade();

	    cid.setCid_cidade(cidade.getCid_cidade());
	    cid.setCid_estado(cidade.getCid_estado());
	    cid.setCid_regiaoibge(cidade.getCid_regiaoibge());
	    
	    cidadeRepository.save(cid);

	 }
		
		
	// UPDATE
	@PutMapping("/{id}")
	public void updateCidade(@PathVariable Long id, @RequestBody CidadeRq cidade) throws Exception 
	{
	    var cid = cidadeRepository.findById(id);
	    
	    if (cid.isPresent()) 
	    {     
		      var cid2 = cid.get();

		      cid2.setCid_cidade(cidade.getCid_cidade());
		      cid2.setCid_estado(cidade.getCid_estado());
		      cid2.setCid_regiaoibge(cidade.getCid_regiaoibge());
		      cidadeRepository.save(cid2);

		} else { throw new Exception("Cidade não encontrada"); }
		    
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteCidade(@PathVariable Long id) 
	{
	    cidadeRepository.deleteById(id);
	}

}