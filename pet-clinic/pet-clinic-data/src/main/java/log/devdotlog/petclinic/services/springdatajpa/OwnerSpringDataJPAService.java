package log.devdotlog.petclinic.services.springdatajpa;

import log.devdotlog.petclinic.model.Owner;
import log.devdotlog.petclinic.repositories.OwnerRepository;
import log.devdotlog.petclinic.repositories.PetRepository;
import log.devdotlog.petclinic.repositories.PetTypeRepository;
import log.devdotlog.petclinic.services.OwnerService;
import log.devdotlog.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSpringDataJPAService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSpringDataJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
                                     PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }
    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }
    @Override
    public Owner findById(Long id) {
        // findById returns Optional<Owner> thus .orElse(null)
        return ownerRepository.findById(id).orElse(null);
    }
    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }
    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }
    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

}
