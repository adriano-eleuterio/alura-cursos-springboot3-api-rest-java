package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.CreateDoctorDTO;
import med.voll.api.model.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    private final DoctorRepository repository; // Injeção de dependência da Inteface DoctorRepository

    public DoctorController(DoctorRepository repository) { //Injeção de dependência pelo construtor
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void insert(@RequestBody @Valid CreateDoctorDTO doctorDTO){
        repository.save(new Doctor(doctorDTO));
    }
}
