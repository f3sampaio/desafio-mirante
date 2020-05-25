package br.net.mirante.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.net.mirante.entities.Person;
import br.net.mirante.viewmodels.response.PersonViewModelResponse;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	public List<Person> findAll(); 
}
