package pfa.iir5.gestion_frais_transport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import pfa.iir5.gestion_frais_transport.models.Demandeur;

@RepositoryRestResource
public interface DemandeurRepo extends JpaRepository<Demandeur, Integer> {

}
