package com.test.bootstrap;

import com.test.model.Owner;
import com.test.model.Vet;
import com.test.services.OwnerService;
import com.test.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=========> Load Data");
        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("Sayed");
        o1.setLastName("Omar");
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setId(2L);
        o2.setFirstName("Ahmed");
        o2.setLastName("Mustafa");
        ownerService.save(o2);

        System.out.println("=========> Owners Loaded");
        Vet v1 = new Vet();
        v1.setId(1L);
        v1.setFirstName("Aly");
        v1.setLastName("Vet1");
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setId(2L);
        v2.setFirstName("Jack");
        v2.setLastName("Vet");
        vetService.save(v2);
        System.out.println("=========> Vet Loaded");

    }
}
