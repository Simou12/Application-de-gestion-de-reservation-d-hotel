package com.hotel.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.rest.model.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

}
