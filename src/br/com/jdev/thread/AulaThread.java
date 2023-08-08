package br.com.jdev.thread;

public class AulaThread {
	
	public static void main(String[] args) throws InterruptedException {
		
		for (int pos = 0; pos < 10; pos++) {
			
			// Thread.sleep(1000); /*Passando um tempo para executar o print*/
			/*Executando essa linha abaixo com tempo de parada*/
			System.out.println("Executando alguma rotina");
			
			Thread.sleep(1000);
		}
		
	}
	
}
