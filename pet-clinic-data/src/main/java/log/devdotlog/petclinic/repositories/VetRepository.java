package log.devdotlog.petclinic.repositories;

import log.devdotlog.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
