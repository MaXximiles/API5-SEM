package com.grupo3.finddata.repositorys;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.finddata.classes.Cnae;

@SpringBootTest
@Transactional
class CnaeRepositoryTest {

	@Autowired
	CnaeRepository repo;
	
	@Test
	@Rollback
	void testSelectCnae() 
	{	
		Optional<Cnae> cnae = repo.findById(1L);
		assertTrue(cnae.get() != null);
	}
}
