package log.devdotlog.petclinic.services.springdatajpa;

import log.devdotlog.petclinic.model.Vet;
import log.devdotlog.petclinic.repositories.VetRepository;
import log.devdotlog.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSpringDataJPAService implements VetService {
    private final VetRepository vetRepository;
    public VetSpringDataJPAService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }
    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }
    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }
    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }
    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }
    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
