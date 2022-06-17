package com.grupo3.finddata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo3.finddata.classes.CarteiraVendedor;
import com.grupo3.finddata.classes.dto.CarteiraVendedorRq;
import com.grupo3.finddata.classes.dto.CarteiraVendedorRs;
import com.grupo3.finddata.repositorys.CarteiraVendedorRepository;
import com.grupo3.finddata.repositorys.CidadeRepository;
import com.grupo3.finddata.repositorys.CnaeRepository;
import com.grupo3.finddata.repositorys.ConsumoRepository;
import com.grupo3.finddata.repositorys.EmpresaRepository;
import com.grupo3.finddata.repositorys.UsuarioRepository;

@Service
public class CarteiraVendedorService 
{
	@Autowired
	private CarteiraVendedorRepository carteiraVendedorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CnaeRepository cnaeRepository;
	@Autowired
	private ConsumoRepository consumoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public List<CarteiraVendedorRs> selectAll()
	{

	   List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	   var cart = carteiraVendedorRepository.findAll();
			
		for(CarteiraVendedor e : cart)
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}

	public List<CarteiraVendedorRs> selectCarteira(String usuid, String empid) 
	{
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.findByUsuidAndEmpid(usuid, empid); 
		
		for(CarteiraVendedor e : cart)
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	

	}

	public List<CarteiraVendedorRs> selectCarteiraEmpUsuNome(String usunome, String empnome) 
	{
	  
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraNome(usunome, empnome); 
		
		for(CarteiraVendedor e : cart)
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	

	}
		
	public List<CarteiraVendedorRs> selectCarteirasPendentes() 
	{	
		List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
		var cart = carteiraVendedorRepository.SelectCarteirasPendentes();
		
		for(CarteiraVendedor e : cart)
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
	
	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNome(String usunome, String empnome) 
	{
	  
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraConcluidaNome(usunome, empnome); 
		
		for(CarteiraVendedor e : cart)
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	

	}

	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNome(String idvende) 
	{
	  
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraVendedor(idvende); 
		
		for(CarteiraVendedor e : cart)
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
	 
	public List<CarteiraVendedorRs> selectCarteiraConcluidaVendedor(String idvende, String empresa) 
	{
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraVendedorFiltro(idvende, empresa);
		
		for(CarteiraVendedor e : cart)
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
	
	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNomeProsp(String idvende) 
	{
	  
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraVendedorProspec(idvende); 
		
		for(CarteiraVendedor e : cart)
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
		
	public List<CarteiraVendedorRs> selectCarteiraConcluidaVendedorProsp(String idvende, String empresa) 
	{
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraVendedorFiltroProspec(idvende, empresa);
		
		for(CarteiraVendedor e : cart)
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
		
	public List<CarteiraVendedorRs> selectCarteiraTopVendedor() 
	{
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraVendedorTopConsumo();
		
		for(CarteiraVendedor e : cart) 
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
	
	public List<CarteiraVendedorRs> selectCarteiraTopVendedores() 
	{
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraVendedoresTopConsumo();
		
		for(CarteiraVendedor e : cart) 
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoCnpj(emp.get(0).getEmpcnpj()),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
	
	public List<CarteiraVendedorRs> selectCarteiraTopRegiao() 
	{
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraRegiaoTopConsumo();
		
		for(CarteiraVendedor e : cart) 
		{
			var emp = empresaRepository.SelectEmpId(e.getEmpid());
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()),
																					cnaeRepository.SelectCnaeId(emp.get(0).getCnaeid()),
																					consumoRepository.selectConsumoRegiao(),
																					cidadeRepository.SelectCidadeId(emp.get(0).getCidid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
			

	public void insertCarteira(CarteiraVendedorRq carteira) throws Exception
	{
	    var cart = new CarteiraVendedor();

	    cart.setEmpid(carteira.getEmpid());
	    cart.setUsuid(carteira.getUsuid());
	    cart.setCartdataini(carteira.getCartdataini());
	    cart.setCartstatus(carteira.getCartstatus());
	    carteiraVendedorRepository.save(cart);

	 }
		
		
	// UPDATE
	@PutMapping("/{id}")
	public void updateCarteira(Long id, CarteiraVendedorRq carteira) throws Exception 
	{
	    var cart = carteiraVendedorRepository.findById(id);
	    
	    if (cart.isPresent()) 
	    {     
		      var cart2 = cart.get();

		      cart2.setEmpid(carteira.getEmpid());
		      cart2.setUsuid(carteira.getUsuid());
		      cart2.setCartdataini(carteira.getCartdataini());
		      cart2.setCartstatus(carteira.getCartstatus());
		      carteiraVendedorRepository.save(cart2);

		} else { throw new Exception("Carteira não encontrada"); }    
	}
	

	public void deleteCarteira(Long id) 
	{
	    carteiraVendedorRepository.deleteById(id);
	}

}
