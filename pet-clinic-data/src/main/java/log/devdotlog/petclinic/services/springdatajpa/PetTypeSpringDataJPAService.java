package log.devdotlog.petclinic.services.springdatajpa;

import log.devdotlog.petclinic.model.PetType;
import log.devdotlog.petclinic.repositories.PetTypeRepository;
import log.devdotlog.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSpringDataJPAService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;
    public PetTypeSpringDataJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }
    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }
    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }
    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }
    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }
    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
