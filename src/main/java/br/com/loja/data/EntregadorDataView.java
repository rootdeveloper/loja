package br.com.loja.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.loja.controller.EntregadorController;

@Named
@SessionScoped
public class EntregadorDataView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<EntregadorController> entregadores;
	private List<String> cidades;
    
    private EntregadorController entregadorSelecionado;
    
    @Inject
    private EntregadorService service;
    
    @PostConstruct
    public void init() {
        setEntregadores(service.createEntregadores(50));
        setCidades(service.getCidades());
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

    public void setEntregadorSelecionado(EntregadorController selectedCar) {
        this.entregadorSelecionado = selectedCar;
    }

    public void clearMultiViewState() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        PrimeFaces.current().multiViewState().clearAll(viewId, true, (clientId) -> {
            showMessage(clientId);
        });
    }

    private void showMessage(String clientId) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
    }

}
