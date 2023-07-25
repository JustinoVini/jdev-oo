package br.com.jdev.entity;

import java.util.Objects;

import br.com.jdev.interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {

	private String registro;
	private String nivelCargo;
	private String experiencia;
	
	private String login;
	private String senha;
	
	public Secretario() {
		
	}
	
	public Secretario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public String toString() {
		return "Secretario [registro=" + registro + ", nivelCargo=" + nivelCargo + ", experiencia=" + experiencia
				+ ", nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", registroGeral="
				+ registroGeral + ", numeroCpf=" + numeroCpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(experiencia, nivelCargo, registro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Secretario other = (Secretario) obj;
		return Objects.equals(experiencia, other.experiencia) && Objects.equals(nivelCargo, other.nivelCargo)
				&& Objects.equals(registro, other.registro);
	}

	@Override
	public double salario() {

		return 1800.80 * 0.9;
	}

	/*Método da interface com parametro*/
	@Override
	public boolean autenticar(String login, String senha) {
		this.login = login;
		this.senha = senha;
		return autenticar();
	}

	@Override
	public boolean autenticar() {
		return login.equals("admin") && senha.equals("admin");
	}

}
