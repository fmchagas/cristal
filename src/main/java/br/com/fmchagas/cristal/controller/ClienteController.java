package br.com.fmchagas.cristal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmchagas.cristal.domain.Cliente;
import br.com.fmchagas.cristal.requests.ClientePostRequestBody;
import br.com.fmchagas.cristal.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("cristal/v1/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	@Operation(summary = "Cria um cliente")
	public ResponseEntity<Cliente> adicionar(@RequestBody @Validated ClientePostRequestBody clientePostRequestBody){
		return new ResponseEntity<>(clienteService.salvar(clientePostRequestBody), HttpStatus.CREATED);
	}
}
