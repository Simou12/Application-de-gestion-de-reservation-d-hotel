package com.client.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.client.rest.models.Reservation;


public interface ReservationRepository  extends JpaRepository<Reservation, String>  {

}
