package pfa.iir5.gestion_frais_transport.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demande {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String motif;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String moyenTransport;

    @Column(nullable = false)
    private BigDecimal frais;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateDebut;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateFin;

    @Column(nullable = false)
    private String villeDepart;

    @Column(nullable = false)
    private String villeArrive;

    @Column(nullable = false)
    private Etat etat;

    @Column(columnDefinition = "TEXT")
    private String justification;

    @OneToMany
    @JoinColumn(name = "demande_id")
    private List<Document> documents;

    @ManyToOne
    private Demandeur demandeur;

    @ManyToOne
    private Manager manager;

    public enum Etat {
        EN_COURS, VALIDE, REFUSE, EN_ATTENTE
    }
}
