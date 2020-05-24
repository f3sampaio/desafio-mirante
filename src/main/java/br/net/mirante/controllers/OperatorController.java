package br.net.mirante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.net.mirante.services.OperatorService;
import br.net.mirante.viewmodels.request.OperatorRequest;
import br.net.mirante.viewmodels.response.OperatorResponse;

@RestController
@RequestMapping(value="operators")
public class OperatorController {

	@Autowired
	private OperatorService operatorService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public List<OperatorResponse> list() {
		return operatorService.list();
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public void register(@RequestBody OperatorRequest operatorRequest) {
		operatorService.register(operatorRequest);
	}
	
	@RequestMapping(value="update", method=RequestMethod.PUT)
	public OperatorResponse update(@RequestBody OperatorRequest operatorRequest) {
		return operatorService.update(operatorRequest);
	}
	
	@RequestMapping(value="remove/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		operatorService.remove(id);
	}
	
}
