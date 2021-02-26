package br.com.mouawad.estudos.spring.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 *	Entidade Produto
 */

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id														 //Indica que o campo é chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	 //Indica a estrategia de geração de id
	private Integer id;
	private String nome;
	private Double preco;
	
	/*
	 * Mapeando um relacionamento
	 */
	@JsonIgnore										 //Proteção para referência cíclica na serialização Json
	@ManyToMany												 //Tipo de relacionamento
	@JoinTable(name="PRODUTO_CATEGORIA",					 //Nome da tabela criada para * to *
	joinColumns = @JoinColumn(name = "produto_id"),			 //Nome da chave esrangeira da tabela produto
	inverseJoinColumns = @JoinColumn(name = "categoria_id")) //Nome da chave estrangeira da tabela categoria
	private List<Categoria> categorias = new ArrayList<>();	 //Lista de categorias
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> items = new HashSet<>();
	
	@JsonIgnore
	public List<Pedido> getPedidos() {
		List<Pedido> l = new ArrayList<>();
		for (ItemPedido i : items) {
			l.add(i.getPedido());
		}
		return l;
	}
	
	
	public Set<ItemPedido> getItems() {
		return items;
	}

	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Produto() {
		
	}

	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
