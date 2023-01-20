package com.hotel.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.rest.model.Agence;

public interface AgenceRepository extends JpaRepository<Agence, String> {

}
