package br.com.loja.enums;

public enum ModalidadeFrete {
	
	// 0 - Por conta do emitente
	EMITENTE("0"),

	// 1 - Por conta do destintário/remetente
	DESTINATARIO_REMETENTE("1"),

	// 2 - Por conta de terceiros
	TERCEIROS("2"),

	// 9 - Sem frete
	SEM_FRETE("9");
	
	private String valor;
	
	ModalidadeFrete(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}