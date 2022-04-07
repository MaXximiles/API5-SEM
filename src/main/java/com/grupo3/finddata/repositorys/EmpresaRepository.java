package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo3.finddata.classes.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>
{
	List<Empresa> findEmpresaByempcnpjContains(String cnpj);
}
