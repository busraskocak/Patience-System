package patiencenotificationsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patiencenotificationsystem.NotificationPreference;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table (name = "patience")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "name")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    // other fields...

    @Enumerated(EnumType.STRING)
    private NotificationPreference notificationPreference;

    private Integer version;

    @PrePersist
    public void setVersion() {
        this.version = 1;
    }

    @PreUpdate
    public void incrementVersion() {
        this.version += 1;
    }

    // Enum for gender
    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }
}
