package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>
{
	//List<Empresa> findEmpresaByempnomeContains(String nome);
	
	@Query(value = "SELECT emp_id, emp_nome, cid_id, cnae_id, emp_origem, emp_cnpj "
			+ "	FROM empresas WHERE emp_nome LIKE %?1% ORDER BY emp_nome;", nativeQuery = true)
	List<Empresa> SelectEmpNome(String nome);
	
	@Query(value = "SELECT emp_id, emp_nome, cid_id, empresas.cnae_id, cnae_codigo, cnae_descricao, emp_origem, emp_cnpj  "
			+ "	FROM empresas"
			+ " INNER JOIN cnae ON cnae.cnae_id = empresas.cnae_id "
			+ " ORDER BY emp_nome;", nativeQuery = true)
	List<Empresa> SelectOrdem();
}
