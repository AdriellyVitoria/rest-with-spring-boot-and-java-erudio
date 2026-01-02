package br.com.AdriellyVitoria.erudio.services;

import br.com.AdriellyVitoria.erudio.exception.ResourceNotFoundException;
import br.com.AdriellyVitoria.erudio.model.Person;
import br.com.AdriellyVitoria.erudio.repository.PersonRespository;
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

    public List<Person> findAll( ) {;
        logger.info("Finding all Person!");

        return respository.findAll();
    }

    public Person findById(long id) {
        logger.info("Finding one Person!");

        return respository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");
        return respository.save(person);
    }

    public Person upadete(Person person) {
        logger.info("Updating one Person!");
       Person entity = respository.findById(person.getId())
               .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return respository.save(entity);
    }

    public void delete(long id) {
        logger.info("Delete one Person!");
        Person entity = respository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));

        respository.delete(entity);
    }
}
