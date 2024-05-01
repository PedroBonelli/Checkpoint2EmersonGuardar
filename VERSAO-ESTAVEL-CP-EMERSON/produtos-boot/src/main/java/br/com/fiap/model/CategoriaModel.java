package br.com.fiap.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_CATEGORIA")
public class CategoriaModel {

	private long idCategoria;
	private String nome_Categoria;
	private List<ProdutoModel> produtos;

	public CategoriaModel() {
	}

	public CategoriaModel(long idCategoria, String nome_Categoria, List<ProdutoModel> produtos) {
		super();
		this.produtos = produtos;
		this.idCategoria = idCategoria;
		this.nome_Categoria = nome_Categoria;
	}

	@Id
	@Column(name = "ID_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQ")
	@SequenceGenerator(name = "CATEGORIA_SEQ", sequenceName = "CATEGORIA_SEQ", allocationSize = 1)
	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 40 caracteres")
	public String getNome_Categoria() {
		return nome_Categoria;
	}

	public void setNome_Categoria(String nomeCategoria) {
		this.nome_Categoria = nomeCategoria;
	}

	@OneToMany(mappedBy = "categoria")
	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	

}
