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

import com.grupo3.classes.Cidade;
import com.grupo3.classes.Consumo;
import com.grupo3.classes.dto.CidadeRq;
import com.grupo3.classes.dto.CidadeRs;
import com.grupo3.classes.dto.ConsumoRq;
import com.grupo3.classes.dto.ConsumoRs;
import com.grupo3.repositorys.CidadeRepository;
import com.grupo3.repositorys.ConsumoRepository;

@RestController
@RequestMapping(value = "/consumo")
public class ConsumoController 
{
	private ConsumoRepository consumoRepository = null;
	
	public ConsumoController(ConsumoController consumoController) {this.consumoRepository = consumoRepository; }
	
	
	// SELECT de todos//
	@GetMapping("/")
	public List<ConsumoRs> selectAll()
	{
	   var consumo = consumoRepository.findAll();
	   return consumo.stream().map((cid) -> ConsumoRs.converter(cid)).collect(Collectors.toList());
	}
		  
	// SELECT por ID //
	@GetMapping("/{id}")
	public ConsumoRs selectID(@PathVariable("id") Long id) 
	{
	  var cons = consumoRepository.getOne(id);
	  return ConsumoRs.converter(cons);
	}
		  
	// SELECT por Nome
	@GetMapping("/filtroempresa")
	public List<ConsumoRs> findConsumoByEmpresaId(@RequestParam("idempresa") Long idEmpresa)
	{
	    return this.consumoRepository.findConsumoByEmpresaId(idEmpresa).stream().map(ConsumoRs::converter).collect(Collectors.toList());
	}
		
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertConsumo(@RequestBody ConsumoRq consumo) throws Exception
	{
	    var cons = new Consumo();

	    cons.setCons_mes(consumo.getCons_mes());
	    cons.setCons_qtdconsumo(consumo.getCons_qtdconsumo());
	    cons.setEmp_id(consumo.getEmp_id());
	    
	    consumoRepository.save(cons);

	 }
		
		
	// UPDATE
	@PutMapping("/{id}")
	public void updateConsumo(@PathVariable Long id, @RequestBody ConsumoRq consumo) throws Exception 
	{
	    var cons = consumoRepository.findById(id);
	    
	    if (cons.isPresent()) 
	    {     
		      var cons2 = cons.get();

		      cons2.setCons_mes(consumo.getCons_mes());
		      cons2.setCons_qtdconsumo(consumo.getCons_qtdconsumo());
		      cons2.setEmp_id(consumo.getEmp_id());
		      consumoRepository.save(cons2);

		} else { throw new Exception("Não foi possivel atualizar esse consumo"); }
		    
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteConsumo(@PathVariable Long id) 
	{
	    consumoRepository.deleteById(id);
	}
}
