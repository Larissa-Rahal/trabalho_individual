package br.org.serratec.trabalho_individual.entity;

import java.math.BigDecimal;

import br.org.serratec.trabalho_individual.DTOs.PratoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Prato {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_produto")
	    private Long id;
	    private String nome;
	    private String descricao;
	    @Column(name = "preco_REAIS")
	    private BigDecimal preco;
	    @Enumerated(EnumType.STRING)
	    private Tipo tipo;	    
	    
		public Prato(Long id, String nome, String descricao, BigDecimal preco, Tipo tipo) {
			super();
			this.id = id;
			this.nome = nome;
			this.descricao = descricao;
			this.preco = preco;
			this.tipo = tipo;
		}
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getDescricao() {
			return descricao;
		}
		
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		public BigDecimal getPreco() {
			return preco;
		}
		
		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}
		
		public Tipo getTipo() {
			return tipo;
		}
		
		public void setTipo(Tipo tipo) {
			this.tipo = tipo;
		}

		public PratoDTO toDTO() {
			return new PratoDTO(this.id, this.nome, this.descricao, this.preco, this.tipo);
		}
	    
	    
}
