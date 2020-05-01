package br.com.loja.model;

import br.com.loja.enums.TipoDocumentoEnum;

public class Documento {
	
	private Long id;
	
	private TipoDocumentoEnum tipoDocumento;
	
	private String descricao;
	
	private String numero;
	
	private String dataDeEmissao;
	
	private String orgaoEmissor;

}
