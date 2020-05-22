package br.net.mirante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.net.mirante.services.OperatorService;
import br.net.mirante.viewmodels.request.OperatorRequest;

@Controller
@RequestMapping(value="operator")
public class OperatorController {

	@Autowired
	private OperatorService operatorService;
	
	@RequestMapping(value="register")
	public void register(@RequestBody OperatorRequest operatorRequest) {
		operatorService.register(operatorRequest);
	}
	
}
