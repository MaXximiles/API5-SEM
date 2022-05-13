package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.CarteiraVendedor;

@Repository
public interface CarteiraVendedorRepository extends JpaRepository<CarteiraVendedor, Long> 
{
	
	@Query(value = "SELECT cart_id, usu_id, emp_id, cart_status, cart_data_ini  "
			+ " FROM carteira_vendedor "
			+ " WHERE usu_id = ?1 AND emp_id = ?2 ", nativeQuery = true)
	List<CarteiraVendedor> SelectCarteira(String usuid, String empid);
	
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
	

}
