package br.com.loja.model;

public class Produto {
	
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private Categoria categoria;
	
//	private Fabricante fabricante;
//	
//	private Fornecedor fornecedor;
	
	private Double custo;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

//	public Fabricante getFabricante() {
//		return fabricante;
//	}
//
//	public void setFabricante(Fabricante fabricante) {
//		this.fabricante = fabricante;
//	}
//
//	public Fornecedor getFornecedor() {
//		return fornecedor;
//	}
//
//	public void setFornecedor(Fornecedor fornecedor) {
//		this.fornecedor = fornecedor;
//	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}
	
	

}
