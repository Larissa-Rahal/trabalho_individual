package br.org.serratec.trabalho_individual.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
	Long id;
	LocalDate dataPedido;
	List<Prato> pratos;
	Cliente cliente;
	BigDecimal valorTotal;
	public Pedido(Long id, LocalDate dataPedido, List<Prato> pratos, Cliente cliente, BigDecimal valorTotal) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.pratos = pratos;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public List<Prato> getPratos() {
		return pratos;
	}
	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public PedidoDTO toDTO() {
		return new PedidoDTO(this.)
	}
}
