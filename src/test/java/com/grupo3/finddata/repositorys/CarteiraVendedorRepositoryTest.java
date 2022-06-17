package com.grupo3.finddata.repositorys;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.finddata.classes.CarteiraVendedor;

@SpringBootTest
@Transactional
class CarteiraVendedorRepositoryTest {
		
	@Autowired
	CarteiraVendedorRepository repo;
	
	@Test
	@Rollback
	void testSelectCarteira() 
	{	
		List<CarteiraVendedor> cart = repo.findAll();
		assertTrue(cart.get(0) != null);
	}

}
