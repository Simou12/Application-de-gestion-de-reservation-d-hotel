package com.agence.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agence.rest.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
