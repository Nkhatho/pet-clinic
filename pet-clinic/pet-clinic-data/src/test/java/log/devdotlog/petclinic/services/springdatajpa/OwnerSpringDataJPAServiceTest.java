package log.devdotlog.petclinic.services.springdatajpa;

import log.devdotlog.petclinic.model.Owner;
import log.devdotlog.petclinic.repositories.OwnerRepository;
import log.devdotlog.petclinic.repositories.PetRepository;
import log.devdotlog.petclinic.repositories.PetTypeRepository;
import log.devdotlog.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJPAServiceTest {
    public final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSpringDataJPAService ownerSpringDataJPAService;
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        ownerSpringDataJPAService.save(owner);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName((any()))).thenReturn(owner);
        Owner smith = ownerSpringDataJPAService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));
        Owner owner = ownerSpringDataJPAService.findById(1L);
        assertEquals(this.owner, owner);
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}