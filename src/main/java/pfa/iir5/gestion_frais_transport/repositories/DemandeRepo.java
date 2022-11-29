package pfa.iir5.gestion_frais_transport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pfa.iir5.gestion_frais_transport.models.Demande;

@RepositoryRestResource
public interface DemandeRepo extends JpaRepository<Demande, Integer> {

}
