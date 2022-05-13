package com.grupo3.finddata.controllers;

import java.util.ArrayList;
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

import com.grupo3.finddata.classes.CarteiraVendedor;
import com.grupo3.finddata.classes.Cidade;
import com.grupo3.finddata.classes.Empresa;
import com.grupo3.finddata.classes.dto.CarteiraVendedorRq;
import com.grupo3.finddata.classes.dto.CarteiraVendedorRs;
import com.grupo3.finddata.classes.dto.CidadeRq;
import com.grupo3.finddata.classes.dto.CidadeRs;
import com.grupo3.finddata.classes.dto.CnaeRs;
import com.grupo3.finddata.classes.dto.EmpresaRs;
import com.grupo3.finddata.classes.dto.UsuarioRs;
import com.grupo3.finddata.repositorys.CarteiraVendedorRepository;
import com.grupo3.finddata.repositorys.CidadeRepository;
import com.grupo3.finddata.repositorys.CnaeRepository;
import com.grupo3.finddata.repositorys.ConsumoRepository;
import com.grupo3.finddata.repositorys.EmpresaRepository;
import com.grupo3.finddata.repositorys.UsuarioRepository;

@RestController
@RequestMapping(value = "/carteira")
public class CarteiraVendedorController 
{
	private CarteiraVendedorRepository carteiraVendedorRepository = null;
	private EmpresaRepository empresaRepository = null;
	private UsuarioRepository usuarioRepository = null; 
	
	public CarteiraVendedorController(CarteiraVendedorRepository CarteiraVendedorRepository, EmpresaRepository EmpresaRepository, UsuarioRepository UsuarioRepository) 
	{
		this.empresaRepository = EmpresaRepository;
		this.carteiraVendedorRepository = CarteiraVendedorRepository; 
		this.usuarioRepository = UsuarioRepository;
	}
		
	// SELECT de todos//
	@GetMapping("/all")
	public List<CarteiraVendedorRs> selectAll()
	{

	   List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	   var cart = carteiraVendedorRepository.findAll();
			
		for(CarteiraVendedor e : cart)
		{
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
	
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira")
	public List<CarteiraVendedorRs> selectCarteira(@RequestParam(value = "usuid", required = false) String usuid,
								 				   @RequestParam(value = "empid", required = false) String empid) 
	{
	  
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteira(usuid, empid); 
		
		for(CarteiraVendedor e : cart)
		{
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	

	}
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/nome")
	public List<CarteiraVendedorRs> selectCarteiraEmpUsuNome(@RequestParam(value = "usunome", required = false) String usunome,
								 				   			 @RequestParam(value = "empnome", required = false) String empnome) 
	{
	  
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraNome(usunome, empnome); 
		
		for(CarteiraVendedor e : cart)
		{
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	

	}
		
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteirasPendentes") 
	public List<CarteiraVendedorRs> selectCarteirasPendentes() 
	{	
		List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
		var cart = carteiraVendedorRepository.SelectCarteirasPendentes();
		
		for(CarteiraVendedor e : cart)
		{
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	
	}
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/concluida/nome")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNome(@RequestParam(value = "usunome", required = false) String usunome,
								 				   			 		  @RequestParam(value = "empnome", required = false) String empnome) 
	{
	  
	  List<CarteiraVendedorRs> lstCarteiraVendedor = new ArrayList<>();
		
	  var cart = carteiraVendedorRepository.SelectCarteiraConcluidaNome(usunome, empnome); 
		
		for(CarteiraVendedor e : cart)
		{
			CarteiraVendedorRs carteiraVendedorRs = CarteiraVendedorRs.converter(e, empresaRepository.SelectEmpId(e.getEmpid()),
																					usuarioRepository.SelectUsuId(e.getUsuid()));
			lstCarteiraVendedor.add(carteiraVendedorRs);
		}
				
		return lstCarteiraVendedor;	

	}
	
		  	
	// FIM DOS SELECT's **********************************************************************
		
		
	// INSERT //
	@PostMapping("/")
	public void insertCarteira(@RequestBody CarteiraVendedorRq carteira) throws Exception
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
	public void updateCarteira(@PathVariable Long id, @RequestBody CarteiraVendedorRq carteira) throws Exception 
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

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteCarteira(@PathVariable Long id) 
	{
	    carteiraVendedorRepository.deleteById(id);
	}
}
