package br.com.erudio.services;

import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.data.dto.v1.PersonDTO;
import static br.com.erudio.mapper.ObjectMapper.parseListObjects;
import static br.com.erudio.mapper.ObjectMapper.parseObject;

import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired // Para fazer a injenção de dependencia
    PersonRespository respository;
    @Autowired // Para fazer a injenção de dependencia
    PersonMapper converter;

    public List<PersonDTO> findAll( ) {;
        logger.info("Finding all Person!");

        return parseListObjects(respository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(long id) {
        logger.info("Finding one Person!");

        var entity = respository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));


        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one Person!");

        var entity = parseObject(person, Person.class);
        return parseObject(respository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Creating one Person!");

        var entity = converter.convertDTOtoEntity(person);
        return   converter.convertEntityToDTO(respository.save(entity));
    }

    public PersonDTO upadete(PersonDTO person) {
        logger.info("Updating one Person!");
       Person entity = respository.findById(person.getId())
               .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(respository.save(entity), PersonDTO.class);
    }

    public void delete(long id) {
        logger.info("Delete one Person!");
        Person entity = respository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));

        respository.delete(entity);
    }
}
