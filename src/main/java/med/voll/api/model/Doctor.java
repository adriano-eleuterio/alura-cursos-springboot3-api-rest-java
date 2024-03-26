package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.CreateDoctorDTO;
import med.voll.api.enums.Specialization;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") // gerar hashcode encima apenas do "id"
@Table(name = "doctor")
@Entity(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    @Embedded
    private Address address; // Para que o Endereco fique em uma classe separada, mas faça parte da mesma tabela de Medicos junto ao banco de dados.

    public Doctor(CreateDoctorDTO doctorDTO) {
        this.name = doctorDTO.name();
        this.email = doctorDTO.email();
        this.phone = doctorDTO.phone();
        this.crm = doctorDTO.crm();
        this.specialization = doctorDTO.specialization();
        this.address = new Address(doctorDTO.address());
    }

}
