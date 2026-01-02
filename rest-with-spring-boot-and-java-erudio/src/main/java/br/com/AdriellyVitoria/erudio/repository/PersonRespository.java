package br.com.AdriellyVitoria.erudio.repository;

import br.com.AdriellyVitoria.erudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRespository extends JpaRepository<Person, Long> {
}
