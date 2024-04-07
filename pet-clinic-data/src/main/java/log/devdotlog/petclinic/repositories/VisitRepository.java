package log.devdotlog.petclinic.repositories;

import log.devdotlog.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
