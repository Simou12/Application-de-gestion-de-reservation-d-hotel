package com.agence.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agence.rest.models.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Long>{ 

}
