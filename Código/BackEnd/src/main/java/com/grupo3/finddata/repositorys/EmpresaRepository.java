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
	
	@Query(value = "SELECT emp_id, emp_nome, cid_id, empresas.cnae_id, cnae_codigo, cnae_descricao, emp_origem, emp_cnpj, cart_id  "
			+ "	FROM empresas "
			+ " INNER JOIN cnae ON cnae.cnae_id = empresas.cnae_id "
			+ " WHERE emp_nome LIKE %?1% ORDER BY emp_nome;", nativeQuery = true)
	List<Empresa> SelectEmpNome(String nome);
	
	@Query(value = "SELECT emp_id, emp_nome, cid_id, cnae_id, emp_origem, emp_cnpj, cart_id  "
			+ "	FROM empresas "
			+ " WHERE emp_id = ?1 ", nativeQuery = true)
	List<Empresa> SelectEmpId(String empid);
	
	//Listando Cnaes das empresas
	@Query(value = "SELECT emp_id, emp_nome, cid_id, empresas.cnae_id, cnae_codigo, cnae_descricao, emp_origem, emp_cnpj, cart_id  "
			+ "	FROM empresas"
			+ " INNER JOIN cnae ON cnae.cnae_id = empresas.cnae_id "
			+ " ORDER BY emp_nome;", nativeQuery = true)
	List<Empresa> SelectOrdem();
	
	//Listando Cidades das empresas
	@Query(value = "SELECT empresas.emp_id, emp_nome, empresas.cid_id,  empresas.cnae_id, emp_origem, emp_cnpj, cart_id, cid_estado, cid_cidade, cid_regiaoibge "
			+ "	FROM empresas "
			+ " INNER JOIN cidade ON cidade.cid_id = empresas.cid_id "
			+ " GROUP BY cid_regiaoibge "
			+ " ORDER BY cid_regiaoibge;", nativeQuery = true)
	List<Empresa> SelectEmpCidades();
	
	@Query(value = "SELECT empresas.emp_id, emp_nome, cid_id, empresas.cnae_id, cnae_codigo, cart_id, cnae_descricao, emp_origem, emp_cnpj, cons_mes, cons_qtdconsumo "
			+ "	FROM empresas "
			+ " INNER JOIN cnae ON cnae.cnae_id = empresas.cnae_id "
			+ " INNER JOIN consumo ON consumo.emp_id = empresas.emp_cnpj "
			+ " WHERE cnae_codigo LIKE %?1% ;", nativeQuery = true)
	List<Empresa> SelectEmpCnae(String cnae);
	
	@Query(value = "SELECT empresas.emp_id, emp_nome, empresas.cid_id, empresas.cnae_id, cart_id, emp_origem, emp_cnpj,"
			+ " cons_mes, cons_qtdconsumo, cid_regiaoibge, cid_cidade, cid_estado"
			+ "	FROM empresas "
			+ " INNER JOIN cidade ON cidade.cid_id = empresas.cid_id "
			+ " INNER JOIN consumo ON consumo.emp_id = empresas.emp_cnpj "
			+ " WHERE cid_regiaoibge LIKE %?1%  ", nativeQuery = true)
	List<Empresa> SelectEmpRegiao(String regiao);
			
	@Query(value = "SELECT empresas.emp_id, emp_nome, cid_id, empresas.cnae_id, cnae_codigo, cart_id, cnae_descricao, emp_origem, emp_cnpj, cons_mes, cons_qtdconsumo "
			+ "	FROM empresas "
			+ " INNER JOIN cnae ON cnae.cnae_id = empresas.cnae_id "
			+ " INNER JOIN consumo ON consumo.emp_id = empresas.emp_cnpj "
			+ " GROUP BY cnae.cnae_codigo "
			+ " ORDER BY cnae.cnae_codigo, cnae.cnae_descricao ", nativeQuery = true)
	List<Empresa> SelectOrdemAll();
	
	@Query(value = "SELECT empresas.emp_id, emp_nome, empresas.cid_id, empresas.cnae_id, cart_id, emp_origem, emp_cnpj, "
			+ "	cnae_codigo, cnae_descricao, cons_mes, cons_qtdconsumo, cid_regiaoibge, cid_cidade, cid_estado "
			+ "	FROM empresas "
			+ " INNER JOIN cnae ON cnae.cnae_id = empresas.cnae_id"
			+ " LEFT JOIN consumo ON consumo.emp_id = empresas.emp_cnpj "
			+ " INNER JOIN cidade ON cidade.cid_id = empresas.cid_id "
			+ " WHERE cid_regiaoibge LIKE %?1% "
			+ " AND emp_nome LIKE %?2% "
			+ " AND cnae_codigo LIKE %?3% "
			+ " GROUP BY empresas.emp_id "
			+ " ORDER BY emp_nome ", nativeQuery = true)
	List<Empresa> SelectEmpFiltros(String regiao, String nome, String cnae);
	
}
