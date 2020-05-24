package br.net.mirante.services;

import java.util.GregorianCalendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.mirante.entities.Person;
import br.net.mirante.repository.PersonRepository;
import br.net.mirante.viewmodels.request.PersonViewModelRequest;

@Component
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public void create(PersonViewModelRequest personVmRq) {
		Person person = new Person(personVmRq.getName(), 
				personVmRq.getDocNumber(), 
				personVmRq.getBirthDate(),
				new GregorianCalendar());
		
		personRepository.save(person);
	}
	
	public Person update(PersonViewModelRequest personVmRq) {
		Optional<Person> person = personRepository.findById(personVmRq.getId());
		
		person.get().setName(personVmRq.getName());
		person.get().setDocNumber(personVmRq.getDocNumber());
		person.get().setBirthDate(personVmRq.getBirthDate());
		
		Person personFlushed = personRepository.save(person.get());
		
		return personFlushed;
	}
	
	public void remove(Long id) {
		personRepository.deleteById(id);
	}
	
	
	
	
}
