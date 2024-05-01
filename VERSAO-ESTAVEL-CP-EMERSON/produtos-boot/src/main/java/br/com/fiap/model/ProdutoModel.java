package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel {

	private long id;
	private String nome;
	private String sku;
	private String descricao;
	private double preco;
	private String caracteristicas;
	private CategoriaModel categoria;

	public ProdutoModel() {
	}

	public ProdutoModel(long id, String nome, String sku, String descricao, double preco, String caracteristicas,
			CategoriaModel categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.sku = sku;
		this.descricao = descricao;
		this.preco = preco;
		this.caracteristicas = caracteristicas;
		this.categoria = categoria;
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
	@SequenceGenerator(name="PRODUTO_SEQ", sequenceName="PRODUTO_SEQ", allocationSize=1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Size(min = 2, max = 40, message = "Nome deve ter no mínimo 2 e no máximo 40 caracteres")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Size(min = 8, max = 8, message = "SKU deve conter 8 caracteres")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Size(min = 1, max = 200, message = "Descricao deve ter no mínimo 1 e no máximo 200 caracteres")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@DecimalMin(value = "0.1", message = "Preço deve ser acima de 0.0")
	@Column(name = "PRECO", columnDefinition = "NUMBER(10,2)")
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Size(min = 1, max = 200, message = "Caracteristicas deve ter no mínimo 1 e no máximo 200 caracteres")
	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIA", nullable = false)
	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public void setId(long id) {
		this.id = id;
	}

}
