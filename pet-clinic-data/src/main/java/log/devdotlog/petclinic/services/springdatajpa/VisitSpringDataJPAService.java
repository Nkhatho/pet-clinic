package log.devdotlog.petclinic.services.springdatajpa;

import log.devdotlog.petclinic.model.Visit;
import log.devdotlog.petclinic.repositories.VisitRepository;
import log.devdotlog.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSpringDataJPAService implements VisitService {
    private final VisitRepository visitRepository;
    public VisitSpringDataJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }
    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }
    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }
    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }
    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }
    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
