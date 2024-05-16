package br.org.serratec.trabalho_individual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.trabalho_individual.DTOs.ClienteDTO;
import br.org.serratec.trabalho_individual.DTOs.PratoDTO;
import br.org.serratec.trabalho_individual.services.ClienteService;
import br.org.serratec.trabalho_individual.services.PratoService;
import jakarta.validation.Valid;





@RestController
@RequestMapping("/restauranteOriental")
public class RestauranteController {

	@Autowired
	private PratoService pratoService;
	private ClienteService clienteService;
	
	@GetMapping("/pratos")
	public ResponseEntity<List<PratoDTO>> buscarTodosPratos(){
		return ResponseEntity.ok(pratoService.buscarTodos());
	}
	
	@GetMapping("/pratos/{id}")
	public ResponseEntity<PratoDTO> buscarPorId(@PathVariable Long id){
		return ResponseEntity.of(pratoService.buscarPorId(id));
	}
	
	@PostMapping("/pratos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PratoDTO> cadastrarPrato(@Valid @RequestBody PratoDTO prato) {
		return ResponseEntity.ok(pratoService.cadastrar(prato));
	}
	
	@PutMapping("/pratos/{id}")
	public ResponseEntity<PratoDTO> alterarPrato(@Valid @PathVariable Long id, @RequestBody PratoDTO pratoAlterado) {	
		return ResponseEntity.of(pratoService.alterar(id, pratoAlterado));
	}
	
	@DeleteMapping("/pratos/{id}")
	public ResponseEntity<Boolean> deletarPrato(@PathVariable Long id){
		return ResponseEntity.of(pratoService.deletar(id));
	}
	
	
	//Clientes
	
	
	@GetMapping("/cliente")
	public ResponseEntity<List<ClienteDTO>> buscarTodosClientes(){
		return ResponseEntity.ok(clienteService.buscarTodos());
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<ClienteDTO> buscarClientesPorId(@PathVariable Long id){
		return ResponseEntity.of(clienteService.buscarPorId(id));
	}
	
	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteDTO> cadastrarCliente(@Valid @RequestBody ClienteDTO prato) {
		return ResponseEntity.ok(clienteService.cadastrar(prato));
	}
	
	@PutMapping("/cliente/{id}")
	public ResponseEntity<ClienteDTO> alterarPrato(@Valid @PathVariable Long id, @RequestBody ClienteDTO clienteAlterado) {	
		return ResponseEntity.of(clienteService.alterar(id, clienteAlterado));
	}
	
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Boolean> deletarCliente(@PathVariable Long id){
		return ResponseEntity.of(clienteService.deletar(id));
	}
}
