package com.grupo3.finddata.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.grupo3.finddata.classes.Cnae;

public interface CnaeRepository extends JpaRepository<Cnae, Long>
{
	//List<Cnae> findCnaeByDescContains(String cnae);
}
