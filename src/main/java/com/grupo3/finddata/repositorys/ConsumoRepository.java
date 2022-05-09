package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.Consumo;
import com.grupo3.finddata.classes.Empresa;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long>
{
	//List<Consumo> findConsumoByEmpresaId(Long emp_id);
	
	@Query(value = "SELECT cons_id, cons_mes, cons_qtdconsumo, emp_id  "
			+ "	FROM consumo "
			+ " WHERE emp_id = ?1", nativeQuery = true)
	List<Consumo> selectConsumoCnpj(String cnpj);
}
