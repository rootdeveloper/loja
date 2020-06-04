package br.com.loja.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.controller.EntregadorController;

@Named
@RequestScoped
public class EntregadorList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<EntregadorController> entregadores;
	private List<String> cidades;
    
    private EntregadorController entregadorSelecionado;
    
    @Inject
    private EntregadorService service;

    
    @PostConstruct
    public void init() {
        setEntregadores(service.createEntregadores(50));
    }
    
	public List<EntregadorController> getEntregadores() {
		return entregadores;
	}
	
	public void setEntregadores(List<EntregadorController> entregadores) {
		this.entregadores = entregadores;
	}
	
	public List<String> getCidades() {
		return cidades;
	}
	
	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}

    public EntregadorController getEntregadorSelecionado() {
        return entregadorSelecionado;
    }

    public void setEntregadorSelecionado(EntregadorController entregadorSelecionado) {
        this.entregadorSelecionado = entregadorSelecionado;
    }
}