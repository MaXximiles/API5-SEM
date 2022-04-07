package com.grupo3.finddata.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> 
{
	//List<Cidade> findEmpresaByNomeContains(String cidade);
}
