package com.test.services;

import com.test.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Vet id);

    Vet save(Vet pet);

    Set<Vet> findAll();
}
