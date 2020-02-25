package com.test.services.springdatajpa;

import com.test.model.Owner;
import com.test.repository.OwnerRepository;
import com.test.repository.PetRepository;
import com.test.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner generalOwner;

    @BeforeEach
    void setUp() {
        generalOwner = new Owner();
        generalOwner.setId(10L);
        generalOwner.setLastName("Aly");
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(generalOwner);
        Owner aly = ownerSDJpaService.findByLastName("Aly");
        assertEquals("Aly", aly.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(generalOwner));
        Owner resultOwner = ownerSDJpaService.findById(1L);
        assertNotNull(resultOwner);
        assertEquals(generalOwner.getId(), resultOwner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner resultOwner = ownerSDJpaService.findById(1L);
        assertNull(resultOwner);
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);
        ownerToSave.setLastName("Nour");
        when(ownerRepository.save(any())).thenReturn(generalOwner);
        Owner savedOwner = ownerSDJpaService.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void findAll() {
        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setLastName("Ahmed");
        Owner o2 = new Owner();
        o2.setId(1L);
        o2.setLastName("Ahmed");

        Set<Owner> ownersSet = new HashSet<>();
        //ownerRepository.findAll();
        ownersSet.add(o1);
        ownersSet.add(o2);
        when(ownerRepository.findAll()).thenReturn(ownersSet);
        Set<Owner> ownerResult = ownerSDJpaService.findAll();
        assertNotNull(ownerResult);
        assertEquals(2, ownerResult.size());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(generalOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}