package com.fatec.backend.repositories;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.backend.models.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
    Optional<List<ClientModel>> findByName(String name);
    Optional<List<ClientModel>> findByEmail(String email);
} 
