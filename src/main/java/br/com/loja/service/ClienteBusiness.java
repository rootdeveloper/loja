package br.com.loja.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class ClienteBusiness {
	
	@Inject
	private EntityManager em;
	
	@Inject
	private Logger logger;
	
	public void criarCliente() {
		
	}
	
	public void excluirCliente() {
		
	}
	
	public void obterClientes() {
		
	
	}
	
	public void atualizarCliente() {
		
	}

}
