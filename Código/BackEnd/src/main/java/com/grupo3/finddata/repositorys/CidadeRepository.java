package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> 
{
	//List<Cidade> findEmpresaByNomeContains(String cidade);
	
	@Query(value = "SELECT  cid_id, cid_cidade, cid_estado, cid_regiaoibge "
			+ "FROM cidade ORDER BY cid_estado, cid_cidade ", nativeQuery = true)
	List<Cidade> SelectCidade();
	
	@Query(value = "SELECT cid_id, cid_cidade, cid_estado, cid_regiaoibge "
			+ " FROM cidade "
			+ " WHERE cid_id = ?1 "
			+ " ORDER BY cid_estado, cid_cidade ", nativeQuery = true)
	List<Cidade> SelectCidadeId(String id);
}
