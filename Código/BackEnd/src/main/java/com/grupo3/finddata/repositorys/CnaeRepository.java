package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo3.finddata.classes.Cnae;

public interface CnaeRepository extends JpaRepository<Cnae, Long>
{
	//List<Cnae> findCnaeByDescContains(String cnae);
	
	@Query(value = "SELECT  cnae_id, cnae_codigo, cnae_descricao "
			+ "FROM cnae ORDER BY cnae_codigo ", nativeQuery = true)
	List<Cnae> SelectCnae();
	
	@Query(value = "SELECT cnae_id, cnae_codigo, cnae_descricao "
			+ "FROM cnae WHERE cnae_id = ?1 ORDER BY cnae_codigo ", nativeQuery = true)
	List<Cnae> SelectCnaeId(String CnaeId);
	
	@Query(value = "SELECT cnae_id, cnae_codigo, cnae_descricao "
			+ "FROM cnae WHERE cnae_codigo LIKE %?1% ", nativeQuery = true)
	Cnae SelectCnaeCnpj(String cod);
}
