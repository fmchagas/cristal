package br.com.fmchagas.cristal.requests;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;

public class ClientePostRequestBody {
	@NotBlank(message = "O nome não pode ser vazio")
	@Schema(description = "Esse é o nome completo do cliente", example = "Fulano", required = true)
	private String nome;
	
	@NotBlank(message = "O e-mail não pode ser vazio")
	@Email(message = "Deve ser um e-mail valido")
	@Schema(description = "Esse é o e-mail do cliente", example = "fulano@provedor.com", required = true)
	private String email;
	
	@CPF(message = "Deve ser um CPF valido")
	@Schema(description = "Esse é o CPF do cliente", example = "11133366699", required = true)
	private String cpf;
	
	@NotNull(message = "A data de nascimento não pode ser vazia")
	@Schema(description = "Essa é data de nascimento do cliente", example = "1987-01-31", required = true)
	private LocalDate dataDeNascimento;
	
	//Getters e Setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}
