package com.agence.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agence.rest.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>  {

}
