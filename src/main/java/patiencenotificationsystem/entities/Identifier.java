package patiencenotificationsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Identifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identifier_type")
    private String type; // Örneğin: TC, Passport

    @Column(name = "identifier_value")
    private String identifierValue; // Kimlik numarası, pasaport numarası vb.
}
