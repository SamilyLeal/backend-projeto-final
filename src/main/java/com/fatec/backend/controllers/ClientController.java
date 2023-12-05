package com.fatec.backend.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.backend.models.ClientModel;
import com.fatec.backend.services.ClientService;


@RestController
@RequestMapping("clients")
@CrossOrigin
public class ClientController {
    
    @Autowired
    private ClientService service;

    @PostMapping()
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Validated ClientModel client){

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(client.getId())
            .toUri();

        return ResponseEntity.created(location).body(this.service.saveClient(client));
    }

    @GetMapping()
    public ResponseEntity<List<ClientModel>> getClients(){
        return ResponseEntity.ok(service.getClients());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<ClientModel>> getClientByName(@PathVariable String name){
        return ResponseEntity.ok(this.service.getClientByName(name));
    }
    
    @GetMapping("email/{email}")
    public ResponseEntity<List<ClientModel>> getClientByEmail(@PathVariable String email){
        return ResponseEntity.ok(this.service.getClientByEmail(email));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable int id){
        this.service.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }

}
