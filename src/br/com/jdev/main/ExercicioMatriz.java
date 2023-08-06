package br.com.jdev.main;

import javax.swing.JOptionPane;

public class ExercicioMatriz {
	
	public static void main(String[] args) {
		
		int linhas = 10;
        int colunas = 10;
        int valores[][] = new int[linhas][colunas];
        
        for (int i = 0; i < linhas; i++) {
        	for (int j = 0; j < colunas; j++) {
        		String input = JOptionPane.showInputDialog("Insira o valor para a célula [" + (i + 1) + "][" + (j + 1) + "]");
        		valores[i][j] = Integer.parseInt(input);
        	}
        }
        
        /*Imprimindo os valores*/
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(valores[i][j] + " ");
            }
            System.out.println();
        }
		
	}

}
