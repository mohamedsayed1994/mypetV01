package com.test.bootstrap;

import com.test.model.Owner;
import com.test.model.Pet;
import com.test.model.PetType;
import com.test.model.Vet;
import com.test.services.OwnerService;
import com.test.services.PetTypeService;
import com.test.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=========> Load Data");

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedPetType2 = petTypeService.save(cat);

        Owner o1 = new Owner();
        o1.setFirstName("Sayed");
        o1.setLastName("Omar");
        o1.setAddress("Masr");
        o1.setCity("Alex");
        o1.setTelephone("123");

        Pet pet1 = new Pet();
        pet1.setName("pet1");
        pet1.setPetType(savedPetType);
        pet1.setOwner(o1);
        pet1.setBirthDate(LocalDate.now());
        o1.getPets().add(pet1);
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Ahmed");
        o2.setLastName("Mustafa");
        o2.setAddress("Cairo");
        o2.setCity("EGY");
        o2.setTelephone("12313123");

        Pet pet2 = new Pet();
        pet2.setName("pet2");
        pet2.setPetType(savedPetType2);
        pet2.setOwner(o2);
        pet2.setBirthDate(LocalDate.now());
        o2.getPets().add(pet2);
        ownerService.save(o2);

        System.out.println("=========> Owners Loaded");
        Vet v1 = new Vet();
        v1.setFirstName("Aly");
        v1.setLastName("Vet1");
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Jack");
        v2.setLastName("Vet");
        vetService.save(v2);
        System.out.println("=========> Vet Loaded");

    }
}
