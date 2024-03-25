package med.voll.api.dto;

import med.voll.api.enums.Specialization;

public record DoctorDTO(String name, String email, String crm, Specialization specialization, addressDTO address) {
}
