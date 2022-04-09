package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long>
{
	//List<Consumo> findConsumoByEmpresaId(Long emp_id);
}
