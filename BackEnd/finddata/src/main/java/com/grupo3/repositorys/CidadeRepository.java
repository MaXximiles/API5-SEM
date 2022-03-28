package com.grupo3.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo3.classes.Cidade;
import com.grupo3.classes.Empresa;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> 
{
	List<Cidade> findEmpresaByNomeContains(String cidade);
}
