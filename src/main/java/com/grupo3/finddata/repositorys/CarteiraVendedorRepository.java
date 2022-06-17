package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.CarteiraVendedor;

@Repository
public interface CarteiraVendedorRepository extends JpaRepository<CarteiraVendedor, Long> {

	List<CarteiraVendedor> findByUsuidAndEmpid(String usuid, String empid);
	
	List<CarteiraVendedor> findAll();

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini "
			+ " FROM carteira_vendedor " 
			+ " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " WHERE carteira_vendedor.cart_status = 'Aguardando' ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteirasPendentes();

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini "
			+ " FROM carteira_vendedor " 
			+ " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " WHERE carteira_vendedor.cart_status = 'Aguardando' " 
			+ " AND usu_nome LIKE %?1% "
			+ " AND emp_nome LIKE %?2% ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteiraNome(String usunome, String empnome);

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini "
			+ " FROM carteira_vendedor " 
			+ " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " WHERE carteira_vendedor.cart_status = 'Concluido' " 
			+ " AND usu_nome LIKE %?1% "
			+ " AND emp_nome LIKE %?2% ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteiraConcluidaNome(String usunome, String empnome);

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini "
			+ " FROM carteira_vendedor " + " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " WHERE carteira_vendedor.cart_status = 'Concluido' "
			+ " AND carteira_vendedor.usu_id = ?1 ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteiraVendedor(String idvende);

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini "
			+ " FROM carteira_vendedor " 
			+ " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " WHERE carteira_vendedor.cart_status = 'Concluido' " 
			+ " AND emp_nome LIKE %?2% "
			+ " AND carteira_vendedor.usu_id = ?1 ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteiraVendedorFiltro(String idvende, String empresa);

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini "
			+ " FROM carteira_vendedor " 
			+ " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " WHERE carteira_vendedor.cart_status = 'Aguardando' "
			+ " AND carteira_vendedor.usu_id = ?1 ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteiraVendedorProspec(String idvende);

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini "
			+ " FROM carteira_vendedor " 
			+ " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " WHERE carteira_vendedor.cart_status = 'Aguardando' " + " AND emp_nome LIKE %?2% "
			+ " AND carteira_vendedor.usu_id = ?1 ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteiraVendedorFiltroProspec(String idvende, String empresa);

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini, "
			+ " cons_mes, (SELECT SUM(cons_qtdconsumo) FROM consumo WHERE emp_id = empresas.emp_cnpj) AS Consumo_Vendedor, emp_nome "
			+ " FROM carteira_vendedor " 
			+ " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " INNER JOIN consumo ON consumo.emp_id = empresas.emp_cnpj "
			+ " WHERE cart_status = 'Concluido' GROUP BY usu_id " 
			+ " ORDER BY Consumo_Vendedor DESC "
			+ " LIMIT 3 ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteiraVendedorTopConsumo();

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini, "
			+ " cons_mes, (SELECT SUM(cons_qtdconsumo) FROM consumo WHERE emp_id = empresas.emp_cnpj) AS Consumo_Vendedor, emp_nome "
			+ " FROM carteira_vendedor " 
			+ " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " INNER JOIN consumo ON consumo.emp_id = empresas.emp_cnpj "
			+ " WHERE cart_status = 'Concluido' GROUP BY usu_id " 
			+ " ORDER BY Consumo_Vendedor DESC "
			+ " LIMIT 8 ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteiraVendedoresTopConsumo();

	@Query(value = "SELECT carteira_vendedor.cart_id, carteira_vendedor.usu_id, carteira_vendedor.emp_id, cart_status, cart_data_ini, "
			+ " cons_mes, (SELECT SUM(cons_qtdconsumo) FROM consumo WHERE emp_id = empresas.emp_cnpj) AS Consumo_Regiao, emp_nome, cid_regiaoibge"
			+ " FROM carteira_vendedor " 
			+ " INNER JOIN empresas ON empresas.emp_id = carteira_vendedor.emp_id "
			+ " INNER JOIN cidade ON cidade.cid_id = empresas.cid_id "
			+ " INNER JOIN usuarios ON usuarios.usu_id = carteira_vendedor.usu_id "
			+ " LEFT JOIN consumo ON consumo.emp_id = empresas.emp_cnpj "
			+ " WHERE cart_status = 'Concluido' GROUP BY cid_regiaoibge "
			+ " ORDER BY Consumo_Regiao DESC ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteiraRegiaoTopConsumo();
}
