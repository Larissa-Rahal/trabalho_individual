package br.org.serratec.trabalho_individual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho_individual.DTOs.PratoDTO;
import br.org.serratec.trabalho_individual.entity.Prato;
import br.org.serratec.trabalho_individual.repository.PratoRepository;

@Service
public class PratoService {

    @Autowired
    private PratoRepository repository;

    public List<PratoDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(p -> new PratoDTO(p.getId(), p.getNome(),
                        p.getDescricao(), p.getPreco(), p.getTipo()))
                .toList();
    }

    public Optional<PratoDTO> buscarPorId(Long id) {
        Optional<Prato> prato = repository.findById(id);

        if (prato.isPresent()) {
            return Optional.of(prato.get().toDTO());
        }
        return Optional.empty();
    }

    public PratoDTO cadastrar(PratoDTO prato) {
        Prato pratoEntity = prato.toEntity();
        repository.save(pratoEntity);
        return pratoEntity.toDTO();
    }

    public Optional<PratoDTO> alterar(Long id, PratoDTO prato) {
        Prato pratoEntity = prato.toEntity();

        if (repository.existsById(id)) {
            pratoEntity.setId(id);
            repository.save(pratoEntity);
            return Optional.of(pratoEntity.toDTO());
        }
        return Optional.empty();
    }

    public Optional<Boolean> deletar(Long id) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        repository.deleteById(id);
        return Optional.of(true);
    }
}