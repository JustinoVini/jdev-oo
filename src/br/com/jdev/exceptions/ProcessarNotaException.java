package br.com.jdev.exceptions;

public class ProcessarNotaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/*Criando o constructor da nossa exception personalizada*/
	public ProcessarNotaException(String erro) {
		super("Erro ao processar" + erro);
	}

}
