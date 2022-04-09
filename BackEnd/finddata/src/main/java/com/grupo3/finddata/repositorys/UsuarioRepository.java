package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  
{
	@Query(value = "SELECT  usu_id, usu_senha, usu_email, usu_nome, usu_nivel "
				+ "FROM usuarios WHERE usu_email = ?1 && usu_senha = ?2 ", nativeQuery = true)
	List<Usuario> SelectUsuarioEmail(String UserEmail, String UserSenha);
}
