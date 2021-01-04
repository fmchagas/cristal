package br.com.fmchagas.cristal.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 128, nullable = false)
	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;
	
	@Column(length = 128, nullable = false)
	@NotBlank(message = "O e-mail não pode ser vazio")
	@Email(message = "Deve ser um e-mail valido")
	private String email;
	
	@Column(length = 11, nullable = false)
	@CPF(message = "Deve ser um CPF valido")
	private String cpf;
	
	@Column(name = "data_nascimento", nullable = false)
	@NotNull(message = "A data de nascimento não pode ser vazia")
	private LocalDate dataDeNascimento;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String email, String cpf, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}
	//Getters hashCode e equals
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
