package com.hotel.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.rest.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
