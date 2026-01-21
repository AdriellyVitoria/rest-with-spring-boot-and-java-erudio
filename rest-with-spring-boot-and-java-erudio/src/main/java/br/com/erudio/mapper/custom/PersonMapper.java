package br.com.erudio.mapper.custom;

import br.com.erudio.data.dto.v1.PersonDTO;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTO convertEntityToDTO(Person person) {
        PersonDTO dto = new PersonDTO();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
//        dto.setBirthDate(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDTOtoEntity(PersonDTO person) {
        Person entity = new Person();

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        //  dto.setBirthDate(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}