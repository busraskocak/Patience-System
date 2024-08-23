package patiencenotificationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patiencenotificationsystem.entities.Patience;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatienceRepository extends JpaRepository <Patience,Long> {
    List<Patience>findByGender(String gender);
    List<Patience>findByFirstName(String firstName);
    List<Patience>findByLastName(String lastName);
    List<Patience> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

}
