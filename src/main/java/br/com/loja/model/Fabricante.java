package br.com.loja.model;

import java.util.Collection;
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

}
