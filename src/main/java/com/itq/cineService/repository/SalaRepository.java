package com.itq.cineService.repository;

import org.springframework.stereotype.Repository;

import com.itq.cineService.dto.Sala;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer>{

}

