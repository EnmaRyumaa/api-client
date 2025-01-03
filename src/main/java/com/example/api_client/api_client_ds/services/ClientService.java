package com.example.api_client.api_client_ds.services;

import com.example.api_client.api_client_ds.dto.ClientDTO;
import com.example.api_client.api_client_ds.entities.Client;
import com.example.api_client.api_client_ds.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).get();

        return new ClientDTO(client);
    }
}
