package br.com.erudio.controllers;

import br.com.erudio.services.PersonServices;
import br.com.erudio.data.dto.v1.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(value = "/{id}",
     produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
             MediaType.APPLICATION_YAML_VALUE}
    )
    public PersonDTO findById(@PathVariable("id") long id) {
       var person = service.findById(id);
       person.setBirthDay(new Date());
//       person.setPhoneNumber("+55 83 993680915");
        person.setFirstName("John");
        person.setPhoneNumber(null);
        person.setSensitiveData("John");
       return person;
    }

    @GetMapping(
            produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public PersonDTO create(@RequestBody() PersonDTO person) {
        return service.create(person);
    }

    @PutMapping(
            consumes ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public PersonDTO upadete(@RequestBody() PersonDTO person) {
        return service.upadete(person);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
