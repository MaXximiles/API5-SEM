package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.Empresa;
import com.grupo3.finddata.classes.Usuario;
import com.grupo3.finddata.classes.dto.UsuarioRs;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  
{
	@Query(value = "SELECT  usu_id, usu_senha, usu_email, usu_nome, usu_nivel "
				+ "FROM usuarios WHERE usu_email = ?1 && usu_senha = ?2 ", nativeQuery = true)
	Usuario SelectUsuarioEmail(String UserEmail, String UserSenha);
	
	@Query(value = "SELECT  usu_id, usu_senha, usu_email, usu_nome, usu_nivel "
			+ "FROM usuarios WHERE usu_nome LIKE %?1% ORDER BY usu_nome ", nativeQuery = true)
	List<Usuario> SelectUsuarioNome(String nome);
	
	@Query(value = "SELECT  usu_id, usu_senha, usu_email, usu_nome, usu_nivel "
			+ "FROM usuarios WHERE usu_email = ?1 ", nativeQuery = true)
	Usuario selectUsuarioEmailRecuperar(String email);
	
	//Arrumar Select por email
	
}
