package med.voll.api.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.CreateAddressDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private String complement;
    private String number;

    public Address(CreateAddressDTO addressDTO) {

        this.street = addressDTO.street();
        this.neighborhood = addressDTO.neighborhood();
        this.zipCode = addressDTO.zipCode();
        this.city = addressDTO.city();
        this.state = addressDTO.state();
        this.complement = addressDTO.complement();
        this.number = addressDTO.number();

    }
}
