package com.grupo3.finddata.repositorys;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.finddata.classes.Empresa;

@SpringBootTest
@Transactional
class EmpresaRepositoryTest {

	@Autowired
	EmpresaRepository repo;
	
	@Test
	@Rollback
	void testSelectCidadeCnpj() 
	{	
		Optional<Empresa> cid = repo.findById(1L);
		assertTrue(cid.get() != null);
	}

}
