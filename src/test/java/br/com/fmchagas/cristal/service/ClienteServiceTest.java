package br.com.fmchagas.cristal.service;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fmchagas.cristal.domain.Cliente;
import br.com.fmchagas.cristal.repository.ClienteRepository;
import br.com.fmchagas.cristal.requests.ClientePostRequestBody;

@ExtendWith(SpringExtension.class)
class ClienteServiceTest {
	@InjectMocks
	private ClienteService clienteService;
	
	@Mock
	private ClienteRepository clienteRepositoryMock;
	
	@BeforeEach
	void setUp() {
		BDDMockito.when(clienteRepositoryMock.save(ArgumentMatchers.any(Cliente.class)))
		.thenReturn(CriaCliente());
	}
	
	@Test
	@DisplayName("Save criar cliente quando sucesso")
	void save_CriarClienteQuandoSucesso() {
		ClientePostRequestBody clientePostRequestBody = new ClientePostRequestBody();
		clientePostRequestBody.setNome(CriaCliente().getNome());
		clientePostRequestBody.setEmail(CriaCliente().getEmail());
		clientePostRequestBody.setCpf(CriaCliente().getCpf());
		clientePostRequestBody.setDataDeNascimento(CriaCliente().getDataDeNascimento());
		
		Cliente clienteSalvo = clienteService.salvar(clientePostRequestBody);
		
		Assertions.assertThat(clienteSalvo).isNotNull().isEqualTo(CriaCliente());
	}
	
	private Cliente CriaCliente() {
		return new Cliente("Dummy", "dummy@provedor.com", "06874315064", LocalDate.of(1900, 1, 31));
	}

}
