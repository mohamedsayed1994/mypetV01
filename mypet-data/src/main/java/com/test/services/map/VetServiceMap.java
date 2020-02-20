package com.test.services.map;

import com.test.model.Vet;
import com.test.services.CrudeService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudeService<Vet, Long> {
    @Override
    public Vet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }
}