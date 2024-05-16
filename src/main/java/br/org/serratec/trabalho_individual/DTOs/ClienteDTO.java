package br.org.serratec.trabalho_individual.DTOs;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import br.org.serratec.trabalho_individual.entity.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDTO(
		Long id,
		@NotBlank 
		String nome,
		@NotBlank
		@CPF
		String cpf,
		@Email
		String email,
		@NotNull
		LocalDate dataNascimento
		) {
	
	public Cliente toEntity() {
		return new Cliente(this.id, this.nome, this.cpf, this.email, this.dataNascimento);
	}

}
