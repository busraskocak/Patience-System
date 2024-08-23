package patiencenotificationsystem.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patiencenotificationsystem.entities.Patience;
import patiencenotificationsystem.repository.PatienceRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatienceService {

    @Autowired
    private PatienceRepository patienceRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Patience save(Patience patience){
        Patience savedPatience = patienceRepository.save(patience);
        rabbitTemplate.convertAndSend("patienceQueue",savedPatience);
        return savedPatience;
    }

    public Patience findById(Long id) {
        return patienceRepository.findById(id).orElse(null);
    }

    public Patience update(Long id, Patience patience) {
        Patience existingPatient = findById(id);
        if (existingPatient != null) {
            patience.setId(id);
            return patienceRepository.save(patience);
        }
        return null;
    }
    @Transactional
    public void delete(Long id) {
        patienceRepository.deleteById(id);
    }

    public List<Patience> search(String gender, String firstName, String lastName, LocalDate ageFrom, LocalDate ageTo) {
        if (ageFrom != null && ageTo != null) {
            return patienceRepository.findByBirthDateBetween(ageFrom, ageTo);
        } else if (gender != null) {
            return patienceRepository.findByGender(gender);
        } else if (firstName != null) {
            return patienceRepository.findByFirstName(firstName);
        } else if (lastName != null) {
            return patienceRepository.findByLastName(lastName);
        }
        return patienceRepository.findAll();
    }


}
