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
import com.grupo3.finddata.classes.dto.EmpresaRq;
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
	private CnaeRepository cnaeRepository = null;
	private ConsumoRepository consumoRepository = null;
	private CidadeRepository cidadeRepository = null;
	
	public CarteiraVendedorController(CarteiraVendedorRepository CarteiraVendedorRepository, EmpresaRepository EmpresaRepository, 
									  UsuarioRepository UsuarioRepository, CnaeRepository CnaeRepository, ConsumoRepository ConsumoRepository,
									  CidadeRepository CidadeRepository) 
	{
		this.empresaRepository = EmpresaRepository;
		this.carteiraVendedorRepository = CarteiraVendedorRepository; 
		this.usuarioRepository = UsuarioRepository;
		this.cnaeRepository = CnaeRepository;
		this.consumoRepository = ConsumoRepository;
		this.cidadeRepository = CidadeRepository;
	}
		
	// SELECT de todos//
	@GetMapping("/all")
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
	
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira")
	public List<CarteiraVendedorRs> selectCarteira(@RequestParam(value = "usuid", required = false) String usuid,
								 				   @RequestParam(value = "empid", required = false) String empid) 
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
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/nome")
	public List<CarteiraVendedorRs> selectCarteiraEmpUsuNome(@RequestParam(value = "usunome", required = false) String usunome,
								 				   			 @RequestParam(value = "empnome", required = false) String empnome) 
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
		
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteirasPendentes") 
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
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/concluida/nome")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNome(@RequestParam(value = "usunome", required = false) String usunome,
								 				   			 		  @RequestParam(value = "empnome", required = false) String empnome) 
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
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/vendedor")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNome(@RequestParam(value = "idvende", required = false) String idvende) 
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
	 
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/vendedor/filtro")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaVendedor(@RequestParam(value = "idvende", required = false) String idvende,
									 								@RequestParam(value = "empresa", required = false) String empresa) 
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
	
	
	// Verificando se existe carteira prospecção vendedor empresa//
	@GetMapping("/carteira/vendedor/prospec")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaEmpUsuNomeProsp(@RequestParam(value = "idvende", required = false) String idvende) 
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
		
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/carteira/vendedor/prospec/filtro")
	public List<CarteiraVendedorRs> selectCarteiraConcluidaVendedorProsp(@RequestParam(value = "idvende", required = false) String idvende,
									 								@RequestParam(value = "empresa", required = false) String empresa) 
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
		
	
	// Verificando se existe carteira vendedor empresa//
	@GetMapping("/top/vendedor")
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
	
	// Lista de Top 8 Empresas //
	@GetMapping("/top/vendedores")
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
	
	// Lista de Top 8 Vendedores //
	@GetMapping("/top/regiao")
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
