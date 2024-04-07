package log.devdotlog.petclinic.services;

import log.devdotlog.petclinic.model.Owner;

public interface OwnerService extends  CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
