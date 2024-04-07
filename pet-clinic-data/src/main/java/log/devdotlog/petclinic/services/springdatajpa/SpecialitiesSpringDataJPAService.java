package log.devdotlog.petclinic.services.springdatajpa;

import log.devdotlog.petclinic.model.Speciality;
import log.devdotlog.petclinic.repositories.SpecialityRepository;
import log.devdotlog.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitiesSpringDataJPAService implements SpecialityService {
    private final SpecialityRepository specialityRepository;
    public SpecialitiesSpringDataJPAService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }
    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }
    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }
    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }
    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }
    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
