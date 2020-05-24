package br.net.mirante.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.net.mirante.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
