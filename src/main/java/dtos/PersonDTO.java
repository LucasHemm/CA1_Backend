package dtos;

import entities.Person;

import java.util.Set;

public class PersonDTO {
    private int id;
    private String fullName;
    private String email;
    private Set<PhoneDTO> phoneDTOS;
    private AddressDTO addressDTO;
    private Set<HobbyDTO> hobbyDTOS;

    public PersonDTO() {
    }

    public PersonDTO(Person person){
        this.id = person.getId();
        this.fullName = person.getFirstName() + " " + person.getLastName();
        this.email = person.getEmail();
        this.phoneDTOS = PhoneDTO.getDtos(person.getPhones());
        this.addressDTO = new AddressDTO(person.getAddress());
        this.hobbyDTOS = HobbyDTO.getDtos(person.getHobbies());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<PhoneDTO> getPhoneDTOS() {
        return phoneDTOS;
    }

    public void setPhoneDTOS(Set<PhoneDTO> phoneDTOS) {
        this.phoneDTOS = phoneDTOS;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public Set<HobbyDTO> getHobbyDTOS() {
        return hobbyDTOS;
    }

    public void setHobbyDTOS(Set<HobbyDTO> hobbyDTOS) {
        this.hobbyDTOS = hobbyDTOS;
    }
}
