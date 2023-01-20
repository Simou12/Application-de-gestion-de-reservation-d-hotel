package com.hotel.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.rest.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
