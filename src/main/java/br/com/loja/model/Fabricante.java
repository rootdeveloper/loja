package br.com.loja.model;

import java.util.List;


public class Fabricante extends Empresa {

	
	private Integer id;

	private Integer codfabricante;

	
	private List<Produto> produtos;
	

	public Integer getCodfabricante() {
		return codfabricante;
	}

	public void setCodfabricante(Integer codfabricante) {
		this.codfabricante = codfabricante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codfabricante == null) ? 0 : codfabricante.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
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
		Fabricante other = (Fabricante) obj;
		if (codfabricante == null) {
			if (other.codfabricante != null)
				return false;
		} else if (!codfabricante.equals(other.codfabricante))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		return true;
	}
	
	

}
