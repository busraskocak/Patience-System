package patiencenotificationsystem.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patiencenotificationsystem.entities.Patience;
import patiencenotificationsystem.service.PatienceService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatienceService patienceService;

    @PostMapping
    public Patience createPatient(@RequestBody Patience patience){
        return patienceService.save(patience);
    }

    @GetMapping("/{id}")
    public Patience getPatience(@PathVariable Long id){
        return  patienceService.findById(id);
    }

    @PutMapping("/{id}")
    public Patience updatePatience(@PathVariable Long id, @RequestBody Patience patience){
        return patienceService.update(id, patience);
    }

    @DeleteMapping("/{id}")
    public void deletePatience(@PathVariable Long id){
        patienceService.delete(id);
    }

    @GetMapping("/search")
    public List<Patience>  searchPatients(@RequestParam(required = false) String gender,
                                          @RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String lastName,
                                          @RequestParam(required = false) LocalDate ageFrom,
                                          @RequestParam(required = false) LocalDate ageTo) {
        return patienceService.search(gender, firstName, lastName, ageFrom, ageTo);
    }

}
