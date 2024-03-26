package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.CreatePatientDTO;
import med.voll.api.model.Patient;
import med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patients")
public class PatientController {
    @Autowired
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping
    public void insert(@RequestBody @Valid CreatePatientDTO patientDTO){
        patientRepository.save(new Patient(patientDTO));
    }
}
