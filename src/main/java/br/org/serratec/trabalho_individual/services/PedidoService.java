package br.org.serratec.trabalho_individual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.org.serratec.trabalho_individual.DTOs.ClienteDTO;
import br.org.serratec.trabalho_individual.entity.Cliente;
import br.org.serratec.trabalho_individual.repository.ClienteRepository;

public class PedidoService {
	@Autowired
    private ClienteRepository repository;

    public List<ClienteDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(c -> new ClienteDTO(c.getId(), c.getNome(),
                        c.getCpf(), c.getEmail(), c.getDataNascimento()))
                .toList();
    }

    public Optional<ClienteDTO> buscarPorId(Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        if (cliente.isPresent()) {
            return Optional.of(cliente.get().toDTO());
        }
        return Optional.empty();
    }

    public ClienteDTO cadastrar(ClienteDTO cliente) {
        Cliente clienteEntity = cliente.toEntity();
        repository.save(clienteEntity);
        return clienteEntity.toDTO();
    }

    public Optional<ClienteDTO> alterar(Long id, ClienteDTO cliente) {
        Cliente clienteEntity = cliente.toEntity();

        if (repository.existsById(id)) {
            clienteEntity.setId(id);
            repository.save(clienteEntity);
            return Optional.of(clienteEntity.toDTO());
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
