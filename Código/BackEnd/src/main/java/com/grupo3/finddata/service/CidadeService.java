package com.grupo3.finddata.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.finddata.classes.Cidade;
import com.grupo3.finddata.classes.dto.CidadeRq;
import com.grupo3.finddata.classes.dto.CidadeRs;
import com.grupo3.finddata.repositorys.CidadeRepository;

@Service
public class CidadeService 
{
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<CidadeRs> selectAll()
	{
	   var cidade = cidadeRepository.findAll();
	   return cidade.stream().map((cid) -> CidadeRs.converter(cid)).collect(Collectors.toList());
	}
	
	public List<CidadeRs> selectAllOrderBy()
	{
	   var cidade = cidadeRepository.SelectCidade();
	   return cidade.stream().map((cid) -> CidadeRs.converter(cid)).collect(Collectors.toList());
	}
	  
	public CidadeRs selectID(Long id) 
	{
	  var cid = cidadeRepository.getOne(id);
	  return CidadeRs.converter(cid);
	}

	public void insertCidade(CidadeRq cidade) throws Exception
	{
	    var cid = new Cidade();

	    cid.setCid_cidade(cidade.getCid_cidade());
	    cid.setCid_estado(cidade.getCid_estado());
	    cid.setCid_regiaoibge(cidade.getCid_regiaoibge());
	    
	    cidadeRepository.save(cid);

	 }
		
	public void updateCidade(Long id,CidadeRq cidade) throws Exception 
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

	public void deleteCidade(Long id) 
	{
	    cidadeRepository.deleteById(id);
	}
}
