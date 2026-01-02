package br.com.AdriellyVitoria.erudio.services;

import br.com.AdriellyVitoria.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll( ) {
        List<Person> persons = new ArrayList<Person>();
        logger.info("Finding all Person!");
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("John");
        person.setLastName("Smith");
        person.setAddress("Paris");
        person.setGender("Male");

        return person;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());

        person.setFirstName("FirstName" + i);
        person.setLastName("LastName" + i);
        person.setAddress("Address");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");
        return person;
    }

    public Person upadete(Person person) {
        logger.info("Updating one Person!");
        return person;
    }

    public void delete(String id) {
        logger.info("Delete one Person!");
    }
}
