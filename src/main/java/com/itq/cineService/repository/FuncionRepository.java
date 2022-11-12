package com.itq.cineService.repository;

import org.springframework.stereotype.Repository;

import com.itq.cineService.dto.Funcion;
import com.itq.cineService.dto.estadoFuncion;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer>{
	
	@Modifying
	@Transactional
	@Query("update Funcion u set u.estado = :estado where u.idFuncion = :idFuncion")
	void setEstadoFuncionById(@Param(value = "estado") estadoFuncion estado, @Param(value = "idFuncion") Integer idFuncion);

}