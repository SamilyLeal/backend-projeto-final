package com.fatec.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.backend.models.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
    List<ClientModel> findByName(String name);
    List<ClientModel> findByEmail(String email);
} 
