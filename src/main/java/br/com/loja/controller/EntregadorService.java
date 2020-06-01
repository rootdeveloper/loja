package br.com.loja.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class EntregadorService {

	private final static String[] empresas;

	private final static String[] cidades;

	private final static String[] emails;

	private final static String[] responsaveis;

	static {
		empresas = getListaEmpresas();
		cidades = getArrayCidades();
		emails = getListaEmails();
		responsaveis = getListaResponsaveis();
	}

	public List<EntregadorBean> createEntregadores(int size) {
		List<EntregadorBean> entregadores = new ArrayList<EntregadorBean>();
		for (int i = 0; i < size; i++) {
			String city = cidades[getRandomIndex()];
			entregadores.add(new EntregadorBean(getRandomCnpj(), empresas[getRandomIndex()], responsaveis[getRandomIndex()],
					emails[getRandomIndex()], city, getRandomTelefone(city), getRandomLogo()));
		}

		return entregadores;
	}
	
	public List<String> getListaCidades() {	
		List<String> cidades = new ArrayList<>();
		cidades.add("Belo Horizonte - MG");
		cidades.add("Campo Grande - MS");
		cidades.add("Cuiabá - MT");
		cidades.add("Curitiba - PR");
		cidades.add("Florianópolis - SC");
		cidades.add("Porto Alegre - RS");
		cidades.add("Rio de Janeiro - RJ");
		cidades.add("São Luís - MA");
		cidades.add("São Paulo - SP");
		cidades.add("Vitória - ES");
		return cidades;
	}

	private static String[] getListaEmpresas() {
		String[] empresas = new String[10];
		empresas[0] = "Entregas Rápidas LTDA";
		empresas[1] = "Flash Entregas";
		empresas[2] = "Transportes Rapidex";
		empresas[3] = "SDT Serviço de Transportes";
		empresas[4] = "\"Deixa Comigo\" Delivery Services";
		empresas[5] = "Humbierto Transport Foundation";
		empresas[6] = "\"Está Na Mão\" Entregas";
		empresas[7] = "100Blante e Cia Delivery";
		empresas[8] = "Teletransporte LTDA";
		empresas[9] = "\"Nem Me Viu\" Serviços de Transportes";	
		
		return empresas;
	}
	
	private static String[] getArrayCidades() {
		String[] cidades = new String[10];
		cidades[0] = "São Paulo - SP";
		cidades[1] = "Rio de Janeiro - RJ";
		cidades[2] = "Porto Alegre - RS";
		cidades[3] = "Florianópolis - SC";
		cidades[4] = "Campo Grande - MS";
		cidades[5] = "Belo Horizonte - MG";
		cidades[6] = "Curitiba - PR";
		cidades[7] = "Cuiabá - MT";
		cidades[8] = "Vitória - ES";
		cidades[9] = "São Luís - MA";
		
		return cidades;
	}

	private static String[] getListaEmails() {
		String[] emails = new String[10];
		emails[0] = "trasportes@gmail.com";
		emails[1] = "entregas@hotmail.com";
		emails[2] = "transporte-rapido@outlook.com";
		emails[3] = "entrega-rapida@yahoo.com";
		emails[4] = "entrega-eficiente@icloud.com";
		emails[5] = "transporte-eficiente@zoho.com";
		emails[6] = "sys@transportes.com";
		emails[7] = "ltda@entregas.com";
		emails[8] = "delivery@baidoo.com";
		emails[9] = "brucewayne@batman.com";
		
		return emails;
	}

	private static String[] getListaResponsaveis() {
		String[] responsaveis = new String[10];
		responsaveis[0] = "Isaac Newton";
		responsaveis[1] = "Leonhard Euler";
		responsaveis[2] = "James Clerk Maxwell";
		responsaveis[3] = "Albert Einstein";
		responsaveis[4] = "Nikola Tesla";
		responsaveis[5] = "Ernest Rutherford";
		responsaveis[6] = "Carl Friedrich Gauss";
		responsaveis[7] = "Galileo Galilei";
		responsaveis[8] = "Hans Christian Oersted";
		responsaveis[9] = "Michael Faraday";
		return responsaveis;
	}
	
	private int getRandomIndex() {
		return (int) Math.floor(Math.random() * 10);
	}

	private Integer getRandomEightDigit() {
		Random rd = new Random();
		return ((int) Math.floor(Math.random() * 10000000)) + (rd.nextInt(9) + 1) * 10000000;
	}

	private Integer getRandomSixDigit() {
		Random rd = new Random();
		return ((int) Math.floor(Math.random() * 100000)) + (rd.nextInt(9) + 1) * 100000;
	}

	private String getRandomCnpj() {
		// Este método não verifica se o CNPJ é válido. Apenas gera um número com 14
		// dígitos e formata na saída de um CNPJ
		StringBuilder cnpj = new StringBuilder(getRandomEightDigit().toString().concat(getRandomSixDigit().toString()));
		cnpj.insert(2, '.').insert(6, '.').insert(10, '/').insert(15, '-');
		return cnpj.toString();
	}

	private String getRandomTelefone(String cidade) {
		StringBuilder telefone = new StringBuilder(getDdd(getEstado(cidade)));
		return telefone.append(getRandomEightDigit().toString()).insert(10, '-').toString();
	}

	private String getEstado(String cidade) {
		return cidade.substring(cidade.length() - 2, cidade.length());
	}

	private String getDdd(String estado) {
		String ddd;

		switch (estado) {
		case "SP":
			ddd = "(11) 9";
			break;
		case "RJ":
			ddd = "(21) 9";
			break;
		case "RS":
			ddd = "(51) 9";
			break;
		case "SC":
			ddd = "(48) 9";
			break;
		case "MS":
			ddd = "(84) 9";
			break;
		case "MG":
			ddd = "(31) 9";
			break;
		case "PR":
			ddd = "(41) 9";
			break;
		case "MT":
			ddd = "(65) 9";
			break;
		case "ES":
			ddd = "(27) 9";
			break;
		default:
			ddd = "(98) 9";
			break;
		}

		return ddd;
	}

	private String getRandomLogo() {
		Random rd = new Random();
		Integer indice = rd.nextInt(5) + 1;
		String logo = "delivery";
		return logo.concat(indice.toString());
	}
}