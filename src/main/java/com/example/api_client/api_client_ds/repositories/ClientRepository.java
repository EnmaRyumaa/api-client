package com.example.api_client.api_client_ds.repositories;

import com.example.api_client.api_client_ds.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
