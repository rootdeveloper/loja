package br.com.loja.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class EntregadorForm implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<String> cidades;
    
    private String cidadeSelecionada;
    
    private String ddd;
    
    @Inject
    private EntregadorService service;

    
    @PostConstruct
    public void init() {
        setCidades(service.getCidades());
    }
    
	public List<String> getCidades() {
		return cidades;
	}
	
	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}

    public String getCidadeSelecionada() {
		return cidadeSelecionada;
	}

	public void setCidadeSelecionada (String cidade) {
		
    	if (cidade != null && cidade != "") {
    		this.cidadeSelecionada = cidade;
    		atualizaDdd(cidade);
    	} else {
    		setDdd(null);
    	}
    	
    }
	
	public String getDdd() {
		return ddd;
	}
	
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	public void atualizaDdd (String cidadeSelecionada) {
		String ddd = new String();
		
		switch (cidadeSelecionada) {
		case "São Paulo - SP":
			ddd = "(11)";
			break;
		case "Rio de Janeiro - RJ":
			ddd = "(21)";
			break;
		case "Porto Alegre - RS":
			ddd = "(51)";
			break;
		case "Florianópolis - SC":
			ddd = "(48)";
			break;
		case "Campo Grande - MS":
			ddd = "(84)";
			break;
		case "Belo Horizonte - MG":
			ddd = "(31)";
			break;
		case "Curitiba - PR":
			ddd = "(41)";
			break;
		case "Cuiabá - MT":
			ddd = "(65)";
			break;
		case "Vitória - ES":
			ddd = "(27)";
			break;
		default:
			ddd = "(98)";
			break;
		}
		
		setDdd(ddd);
	}
}