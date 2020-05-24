package br.net.mirante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.net.mirante.entities.Person;
import br.net.mirante.services.PersonService;
import br.net.mirante.viewmodels.request.PersonViewModelRequest;

@RestController
@RequestMapping(value="persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
	@RequestMapping(value="create", method = RequestMethod.POST)
	public void create(@RequestBody PersonViewModelRequest personVmRq) {
		personService.create(personVmRq);
	}
	
	@RequestMapping(value="update", method=RequestMethod.PUT)
	public Person update(@RequestBody PersonViewModelRequest personVmRq) {
		return personService.update(personVmRq);
	}
	
	@RequestMapping(value="remove/{id}")
	public void remove(@PathVariable Long id) {
		personService.remove(id);
	}
}
