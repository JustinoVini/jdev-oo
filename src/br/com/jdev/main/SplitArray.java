package br.com.jdev.main;

public class SplitArray {

	public static void main(String[] args) {
		
		String text = "Vinicius, curso java, 80, 70, 90, 89";
		
		String[] valoresArray = text.split(",");
		
		System.out.println("Nome: " + valoresArray[0]);
		System.out.println("Curso: " + valoresArray[1]);
		System.out.println("Nota 1: " + valoresArray[2]);
		System.out.println("Nota 2: " + valoresArray[3]);
		System.out.println("Nota 3: " + valoresArray[4]);
		System.out.println("Nota 4: " + valoresArray[5]);
				
	}

}