package br.com.jdev.principio.responsibilidade;

public class TesteConta {

	public static void main(String[] args) {

		ContaBancaria contaBancaria = new ContaBancaria();
		contaBancaria.setDescricao("Conta do Vinicius");

		System.out.println(contaBancaria);

		contaBancaria.diminui100Reais();
		contaBancaria.diminui100Reais();

		System.out.println(contaBancaria);

		contaBancaria.sacar(400);

		System.out.println(contaBancaria);

		contaBancaria.depositoDinheiro(1000);

		System.out.println(contaBancaria);

		contaBancaria.sacar(400);

		System.out.println(contaBancaria);
	}

}
