package com.example.api_client.api_client_ds.controllers;

import com.example.api_client.api_client_ds.dto.ClientDTO;
import com.example.api_client.api_client_ds.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping()
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<ClientDTO> clientDTO = clientService.findAll(pageable);
        return clientDTO;
    }

    @PostMapping
    public ClientDTO insert (@RequestBody ClientDTO clientDTO) {
        return clientService.insert(clientDTO);
    }
}
