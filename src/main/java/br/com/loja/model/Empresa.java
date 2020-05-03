package br.com.loja.model;

import java.util.List;

public class Empresa {
	
	private Integer id;
	
	private String nomeFantasia;
	
	private String razaoSocial;
	
	private String cnpj;
	
	private Endereco endereco;
		
	private List<Pessoa> responsaveis;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pessoa> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Pessoa> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	
	

}
