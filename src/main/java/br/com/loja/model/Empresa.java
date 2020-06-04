package br.com.loja.model;

import java.util.List;

import javax.persistence.Inheritance;

@Inheritance
public class Empresa {
	
	private Integer id;
	
	private String nomeFantasia;
	
	private String razaoSocial;
	
	private String cnpj;
	
	private Endereco endereco;
		
	private List<Pessoa> responsaveis;

}
