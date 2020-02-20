package com.test.services.map;

import com.test.model.Pet;
import com.test.services.CrudeService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudeService<Pet, Long> {
    @Override
    public Pet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }
}
