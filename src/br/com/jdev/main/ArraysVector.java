package br.com.jdev.main;

import javax.swing.JOptionPane;

public class ArraysVector {

	public static void main(String[] args) {

		String posicoes = JOptionPane.showInputDialog("Quantas posições o array deve ter?");

		/* Array pode ser de todos os tipos... */
		/* sempre deve ter uma quantidade de posições definidas */
		double notas[] = new double[Integer.parseInt(posicoes)]; 
		/* passando o valor de posições do array na entrada de
		dados*/

		/*Para cada posicao solicitar um for*/
		for (int pos = 0; pos < notas.length; pos++) {
			String valor = JOptionPane.showInputDialog("Qual o valor da posição?" + (pos + 1));
			notas[pos] = Double.valueOf(valor);
		}
		
		/* Percorrendo os arrays */
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Nota " + (i + 1) + " é = " + notas[i]);
		}

	}

}
