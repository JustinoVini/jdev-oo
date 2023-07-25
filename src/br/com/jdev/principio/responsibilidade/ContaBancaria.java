package br.com.jdev.principio.responsibilidade;

public class ContaBancaria {

	private String descricao;
	private double saldo = 8000;

	public void somaSaldo() {
		saldo += 100;
	}

	public void diminui100Reais() {
		saldo -= 100;
	}

	public void sacar(double saque) {
		saldo -= saque;
	}

	public void depositoDinheiro(double deposito) {
		saldo += deposito;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "ContaBancaria [descricao=" + descricao + ", saldo=" + saldo + "]";
	}

}
