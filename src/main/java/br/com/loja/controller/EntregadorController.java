package br.com.loja.controller;

import java.io.Serializable;

public class EntregadorController implements Serializable {

	private static final long serialVersionUID = 1L;

	public String cnpj;
	public String empresa;
	public String responsavel;
	public String email;
	public String cidade;
	public String telefone;
	public String logo;

	public EntregadorController() {
	}

	public EntregadorController(String cnpj, String empresa, String responsavel, String email, String cidade, String telefone,
			String logo) {
		
		super();
		this.cnpj = cnpj;
		this.empresa = empresa;
		this.cidade = cidade;
		this.email = email;
		this.responsavel = responsavel;
		this.telefone = telefone;
		this.logo = logo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String nomeFantasia) {
		this.empresa = nomeFantasia;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String reponsavel) {
		this.responsavel = reponsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidadeEstado) {
		this.cidade = cidadeEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}