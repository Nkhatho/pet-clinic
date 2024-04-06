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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJPAServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSpringDataJPAService ownerSpringDataJPAService;

    public final String LAST_NAME = "Smith";
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
        Set<Owner> owners = new HashSet<>();
        owners.add(owner);
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> ownerSet = ownerSpringDataJPAService.findAll();

        assertNotNull(ownerSet);
        assertEquals(2, ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));
        Owner owner = ownerSpringDataJPAService.findById(1L);
        assertEquals(this.owner, owner);
    }
    @Test
    void save() {
        Owner localOwner = Owner.builder().id(2L).firstName("Tom").build();
        when(ownerRepository.save(any())).thenReturn(localOwner);
        Owner returnedOwner = ownerSpringDataJPAService.save(localOwner);

        assertNotNull(returnedOwner);
        assertEquals(localOwner, returnedOwner);
    }
    @Test
    void delete() {
        ownerSpringDataJPAService.delete(owner);
        verify(ownerRepository).delete(any());
    }
    @Test
    void deleteById() {
        ownerSpringDataJPAService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}