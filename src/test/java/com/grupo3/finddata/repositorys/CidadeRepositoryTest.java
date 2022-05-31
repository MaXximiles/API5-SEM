package com.grupo3.finddata.repositorys;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.finddata.classes.Cidade;

@SpringBootTest
@Transactional
class CidadeRepositoryTest {
	
	@Autowired
	CidadeRepository repo;
	
	@Test
	@Rollback
	void testSelectCidadeCnpj() 
	{	
		Optional<Cidade> cid = repo.findById(1L);
		assertTrue(cid.get() != null);
	}
	
	/*
		@Test
		@Rollback
		void testSelectCidadeCnpj() 
		{	
			Optional<Cidade> cid = repo.findById(1L);
			assertTrue(cid.get() != null);
		}
	*/
	

}
