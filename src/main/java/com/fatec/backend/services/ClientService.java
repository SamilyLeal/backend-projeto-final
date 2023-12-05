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
        List<ClientModel> clients = this.repository.findByName(name);

        if(clients.size() == 0){
            throw new EntityNotFoundException("Não há clientes cadastrados!");
        }

        return clients;
    }

    public List<ClientModel> getClientByEmail(String email){
        List<ClientModel> clients = this.repository.findByEmail(email);

        if(clients.size() == 0){
            throw new EntityNotFoundException("Não há clientes cadastrados!");
        }

        return clients;
    }

    public void deleteClientById(int id){
        ClientModel clients = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não cadastrado"));

        this.repository.delete(clients);
    }
    
}
