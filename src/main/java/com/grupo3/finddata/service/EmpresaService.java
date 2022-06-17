package com.grupo3.finddata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.finddata.classes.Empresa;
import com.grupo3.finddata.classes.dto.EmpresaRq;
import com.grupo3.finddata.classes.dto.EmpresaRs;
import com.grupo3.finddata.repositorys.CidadeRepository;
import com.grupo3.finddata.repositorys.CnaeRepository;
import com.grupo3.finddata.repositorys.ConsumoRepository;
import com.grupo3.finddata.repositorys.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private CnaeRepository cnaeRepository;
	@Autowired
	private ConsumoRepository consumoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
		
	public List<EmpresaRs> listaTodas()
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
	
	public List<EmpresaRs> listaTodasOrdem()
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
	
	public List<EmpresaRs> listaTodasCidades()
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
	
	public List<EmpresaRs> selectEmpresaNome(String nome)
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
	
	public List<EmpresaRs> selectEmpresaCnae(String cnae)
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
	
	public List<EmpresaRs> selectEmpresaRegiao(String regiao)
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
	
	public List<EmpresaRs> selectEmpresaFiltros(String cnae, String nome, String regiao)
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
	
	public void insertEmpresa(EmpresaRq empresa)
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
	
	public void updateEmpresa(Long id, EmpresaRq empresa) throws Exception
	{
		var emp = empresaRepository.findById(id);

	    if (emp.isPresent()) 
	    { 
	      var emp2 = emp.get();

	      //emp2.setCidid(empresa.getCidid());
	      //emp2.setCnaeid(empresa.getCnaeid());
	      //emp2.setEmpcnpj(empresa.getEmpcnpj());
	      //emp2.setEmpnome(empresa.getEmpnome());
	      emp2.setEmporigem(empresa.getEmporigem());
	      //emp2.setCartid(empresa.getCartid());
	      empresaRepository.save(emp2);

	    } else { throw new Exception("Empresa não encontrada"); }
	}
	
	
}
