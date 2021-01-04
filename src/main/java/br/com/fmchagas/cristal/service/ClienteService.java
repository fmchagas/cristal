package br.com.fmchagas.cristal.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.fmchagas.cristal.domain.Cliente;
import br.com.fmchagas.cristal.exception.NegocioException;
import br.com.fmchagas.cristal.repository.ClienteRepository;
import br.com.fmchagas.cristal.requests.ClientePostRequestBody;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Transactional
	public Cliente salvar(ClientePostRequestBody clientePostRequestBody) {
		Cliente cliente = new Cliente(clientePostRequestBody.getNome(), 
				clientePostRequestBody.getEmail(),
				clientePostRequestBody.getCpf(),
				clientePostRequestBody.getDataDeNascimento());
		
		Cliente clieteExisteComCpf = clienteRepository.findByCpf(cliente.getCpf());
		
		if(clieteExisteComCpf != null && !clieteExisteComCpf.equals(cliente)) {
			throw new NegocioException("existe um cliente cadastrado com este CPF");
		}
		
		Cliente clieteExisteComEmail = clienteRepository.findByEmail(cliente.getEmail());
		
		if(clieteExisteComEmail != null && !clieteExisteComEmail.equals(cliente)) {
			throw new NegocioException("existe um cliente cadastrado com este E-mail");
		}
		
		return clienteRepository.save(cliente);
	}
}
