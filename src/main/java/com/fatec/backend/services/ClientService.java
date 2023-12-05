package com.fatec.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.backend.models.ClientModel;
import com.fatec.backend.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientModel saveClient(ClientModel client){
        return this.repository.save(client);
    }

    public List<ClientModel> getClients(){
        return repository.findAll();
    }
    
    public List<ClientModel> getClientByName(String name){
        return this.repository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Cliente não cadastrado!"));
    }

    public List<ClientModel> getClientByEmail(String email){
        return this.repository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Cliente não cadastrado"));
    }

    public void deleteClientById(int id){
        ClientModel clients = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não cadastrado"));

        this.repository.delete(clients);
    }
    
}
