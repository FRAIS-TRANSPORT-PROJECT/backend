package pfa.iir5.gestion_frais_transport.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Document {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String path;

    @Column(columnDefinition = "TEXT")
    private String descrption;
}
