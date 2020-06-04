package br.com.loja.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.loja.controller.EntregadorController;

@Named
@ApplicationScoped
public class EntregadorService {
	
	private List<String> empresas = Arrays.asList(
			"Entregas Rápidas LTDA",
			"Flash Entregas",
			"Transportes Rapidex",
			"SDT Serviço de Transportes",
			"\"Deixa Comigo\" Delivery Services",
			"Humbierto Transport Foundation",
			"\"Está Na Mão\" Entregas",
			"100Blante e Cia Delivery",
			"Teletransporte LTDA",
			"\"Nem Me Viu\" Serviços de Transportes");	

	private List<String> cidades = Arrays.asList(
			"Belo Horizonte - MG",
			"Campo Grande - MS",
			"Cuiabá - MT",
			"Curitiba - PR",
			"Florianópolis - SC",
			"Porto Alegre - RS",
			"Rio de Janeiro - RJ",
			"São Luís - MA",
			"São Paulo - SP",
			"Vitória - ES");

	private List<String> emails = Arrays.asList(
			"trasportes@gmail.com",
			"entregas@hotmail.com",
			"transporte-rapido@outlook.com",
			"entrega-rapida@yahoo.com",
			"entrega-eficiente@icloud.com",
			"transporte-eficiente@zoho.com",
			"sys@transportes.com",
			"ltda@entregas.com",
			"delivery@mail.com",
			"brucewayne@batman.com");

	private List<String> responsaveis = Arrays.asList(
			"Isaac Newton",
			"Leonhard Euler",
			"James Clerk Maxwell",
			"Albert Einstein",
			"Nikola Tesla",
			"Ernest Rutherford",
			"Carl Friedrich Gauss",
			"Galileo Galilei",
			"Hans Christian Oersted",
			"Michael Faraday");

	public List<EntregadorController> createEntregadores(int size) {
		List<EntregadorController> entregadores = new ArrayList<EntregadorController>();
		for (int i = 0; i < size; i++) {
			String city = cidades.get(getRandomIndex());
			entregadores.add(new EntregadorController(getRandomCnpj(), empresas.get(getRandomIndex()), responsaveis.get(getRandomIndex()),
					emails.get(getRandomIndex()), city, getRandomTelefone(city), getRandomLogo()));
		}

		return entregadores;
	}
	
	public List<String> getCidades() {
		return cidades;
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