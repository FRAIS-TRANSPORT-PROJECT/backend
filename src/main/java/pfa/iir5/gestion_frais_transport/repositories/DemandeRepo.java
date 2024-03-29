package pfa.iir5.gestion_frais_transport.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import pfa.iir5.gestion_frais_transport.models.Demande;

@RepositoryRestResource
public interface DemandeRepo extends JpaRepository<Demande, Integer> {
    List<Demande> findByDemandeurId(int id);
}
