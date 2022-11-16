package com.itq.cineService.repository;

import org.springframework.stereotype.Repository;

import com.itq.cineService.dto.Sala;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * SalaRepository es un intermediario
 * para hacer las operaciones de las 
 * salas en la base de datos
 */
@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer>{

}

