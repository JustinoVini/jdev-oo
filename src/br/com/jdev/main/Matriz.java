package br.com.jdev.main;

public class Matriz {
	
	public static void main(String[] args) {
		
		int notas[][] = new int[2][3]; /*linhas e colunas*/
		
		notas[0][0] = 80;
		notas[0][1] = 90;
		notas[0][2] = 70;
		
		notas[1][0] = 60;
		notas[1][1] = 50;
		notas[1][2] = 20;
				
		/*Percorrendo as linhas*/
		for (int posLinha = 0; posLinha < notas.length; posLinha++) {			
			/*Percorrendo as colunas*/
			for (int posColuna = 0; posColuna < notas[posLinha].length; posColuna++) {
				System.out.println("Valor da matriz: " + notas[posLinha][posColuna]);
			}
		}
		
	}
	
}
