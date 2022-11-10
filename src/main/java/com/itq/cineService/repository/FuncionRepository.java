package com.itq.cineService.repository;

import org.springframework.stereotype.Repository;

import com.itq.cineService.dto.Funcion;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer>{

}
 