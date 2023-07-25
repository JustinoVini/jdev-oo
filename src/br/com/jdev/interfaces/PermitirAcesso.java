package br.com.jdev.interfaces;

/*Essa interface vai ser nosso contrato de autenticacao*/
public interface PermitirAcesso {
	 /*Apenas declaração do método*/
	public boolean autenticar(String login, String senha);
	
	public boolean autenticar();
}
