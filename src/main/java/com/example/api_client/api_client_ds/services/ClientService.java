package com.example.api_client.api_client_ds.services;

import com.example.api_client.api_client_ds.dto.ClientDTO;
import com.example.api_client.api_client_ds.entities.Client;
import com.example.api_client.api_client_ds.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).get();

        return new ClientDTO(client);
    }

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);

        return result.map(x -> new ClientDTO(x));
    }
}
