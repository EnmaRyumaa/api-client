package com.example.api_client.api_client_ds.services;

import com.example.api_client.api_client_ds.dto.ClientDTO;
import com.example.api_client.api_client_ds.entities.Client;
import com.example.api_client.api_client_ds.repositories.ClientRepository;
import com.example.api_client.api_client_ds.services.exceptions.DatabaseException;
import com.example.api_client.api_client_ds.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Erro ao recuperar o cliente")
        );

        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);

        return result.map(x -> new ClientDTO(x));
    }

    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        copyDtoForEntity(clientDTO, client);
        client = clientRepository.save(client);

        return new ClientDTO(client);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long id) {

        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Erro ao excluir o cliente");
        }
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }

    }

    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try {
            Client client = clientRepository.findById(id).get();
            copyDtoForEntity(clientDTO, client);
            client = clientRepository.save(client);
            return new ClientDTO(client);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    private void copyDtoForEntity(ClientDTO dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setBirthDate(dto.getBirthDate());
        client.setIncome(dto.getIncome());
        client.setChildren(dto.getChildren());
    }
}
