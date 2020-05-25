package br.net.mirante.services;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.mirante.entities.Person;
import br.net.mirante.entities.Phone;
import br.net.mirante.repository.PersonRepository;
import br.net.mirante.viewmodels.request.PersonViewModelRequest;
import br.net.mirante.viewmodels.request.PhoneRequest;
import br.net.mirante.viewmodels.response.PersonViewModelResponse;
import br.net.mirante.viewmodels.response.PhoneResponse;

@Component
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public PersonViewModelResponse detail(Long id) {
		Person person = personRepository.findById(id).get();
		
		return new PersonViewModelResponse(person);
	}

	public List<PersonViewModelResponse> list() {
		List<Person> persons = personRepository.findAll();
		List<PersonViewModelResponse> listPersonVm = new ArrayList<PersonViewModelResponse>();
		for (Person person : persons) {
			PersonViewModelResponse personVmRsp = new PersonViewModelResponse(person);
			listPersonVm.add(personVmRsp);
		}

		return listPersonVm;
	}

	public void create(PersonViewModelRequest personVmRq) {
		Person person = new Person(personVmRq.getName(), personVmRq.getDocNumber(), personVmRq.getBirthDate(),
				new GregorianCalendar(), personVmRq.getPhones(), personVmRq.getType(), personVmRq.getMotherName(), personVmRq.getFatherName());

		personRepository.save(person);
	}

	public PersonViewModelResponse update(PersonViewModelRequest personVmRq) {
		Optional<Person> person = personRepository.findById(personVmRq.getId());

		person.get().setName(personVmRq.getName());
		person.get().setDocNumber(personVmRq.getDocNumber());
		person.get().setBirthDate(personVmRq.getBirthDate());
		person.get().setMotherName(personVmRq.getMotherName());
		person.get().setFatherName(personVmRq.getFatherName());
		person.get().setType(personVmRq.getType());
		person.get().setPhones(createPersonPhones(personVmRq.getPhones()));

		personRepository.save(person.get());
		PersonViewModelResponse personVmRsp = new PersonViewModelResponse(person.get());
		
		
		return personVmRsp;
	}

	public void remove(Long id) {
		personRepository.deleteById(id);
	}
	
	private List<Phone> createPersonPhones(List<PhoneRequest> phonesVmRq) {
		List<Phone> phones = new ArrayList<Phone>();
		
		for(PhoneRequest phoneVm: phonesVmRq) {
			Phone phone = new Phone(phoneVm);	
			phone.setCreationDate(new GregorianCalendar());
			phones.add(phone);
		 }
		
		return phones;
	}

}
