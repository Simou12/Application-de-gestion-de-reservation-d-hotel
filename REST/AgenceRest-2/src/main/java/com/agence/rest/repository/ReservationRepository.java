package com.agence.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agence.rest.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String>{

}
