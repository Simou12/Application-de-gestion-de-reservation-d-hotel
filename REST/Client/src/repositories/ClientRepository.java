package com.client.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.client.rest.models.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {

}
