package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long>
{
	//List<Consumo> findConsumoByEmpresaId(Long emp_id);
	
	@Query(value = "SELECT cons_id, cons_mes, cons_qtdconsumo, emp_id  "
			+ "	FROM consumo "
			+ " WHERE emp_id = ?1", nativeQuery = true)
	List<Consumo> selectConsumoCnpj(String cnpj);
	
	@Query(value = "SELECT cons_id, cons_mes, SUM(cons_qtdconsumo) AS cons_qtdconsumo, consumo.emp_id, cid_regiaoibge  "
			+ "	FROM consumo "
			+ " INNER JOIN empresas ON empresas.emp_cnpj = consumo.emp_id "
			+ " INNER JOIN cidade ON cidade.cid_id = empresas.cid_id "
			+ " GROUP BY cid_regiaoibge", nativeQuery = true)
	List<Consumo> selectConsumoRegiao();
}
