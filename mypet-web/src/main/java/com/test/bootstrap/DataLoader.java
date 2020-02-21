package com.test.bootstrap;

import com.test.model.*;
import com.test.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
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

        Visit catVisit = new Visit();
        catVisit.setPet(pet1);
        catVisit.setDescription("visit for cat");
        catVisit.setDate(LocalDate.now());
        visitService.save(catVisit);

        System.out.println("=========> Owners Loaded");
        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet v1 = new Vet();
        v1.setFirstName("Aly");
        v1.setLastName("Vet1");
        v1.getSpecialities().add(savedRadiology);
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Jack");
        v2.setLastName("Vet");
        v2.getSpecialities().add(savedSurgery);
        vetService.save(v2);
        System.out.println("=========> Vet Loaded");
    }
}
