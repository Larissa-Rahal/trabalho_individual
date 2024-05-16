package br.org.serratec.trabalho_individual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.trabalho_individual.entity.Prato;

public interface PratoRepository extends JpaRepository<Prato,Long>{
	
}