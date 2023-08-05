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
		
		System.out.println(notas);
	}
	
}
