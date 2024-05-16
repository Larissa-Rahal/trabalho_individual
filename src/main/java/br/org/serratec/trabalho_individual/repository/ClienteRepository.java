package br.org.serratec.trabalho_individual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.trabalho_individual.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
