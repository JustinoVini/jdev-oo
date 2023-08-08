package br.com.jdev.thread;

import javax.swing.JOptionPane;

public class AulaThread {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		/*Criando uma thread*/
		new Thread() { 
			
			public void run() { /*Executa a rotina*/
				/*Aqui dentro escrevemos a rotina do thread*/
				/*Gerando uma rotina de thread para execução*/
				for (int pos = 0; pos < 10; pos++) {
					
					// Thread.sleep(1000); /*Passando um tempo para executar o print*/
					/*Executando essa linha abaixo com tempo de parada*/
					System.out.println("Executando alguma rotina");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				/*Fim da rotina*/
			};
			
		}.start(); /*liga a thread*/
		
		
		System.out.println("Exibe fim thread");
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuario");
	}
	
}
