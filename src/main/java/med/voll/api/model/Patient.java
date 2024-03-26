package med.voll.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.CreateAddressDTO;
import med.voll.api.dto.CreatePatientDTO;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") // gerar hashcode encima apenas do "id"
@Table(name = "patient")
@Entity(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private Address address;

    public Patient(CreatePatientDTO patientDTO) {

        this.name = patientDTO.name();
        this.email = patientDTO.email();
        this.phone = patientDTO.phone();
        this.cpf = patientDTO.cpf();
        this.address = new Address(patientDTO.address());

    }
}
