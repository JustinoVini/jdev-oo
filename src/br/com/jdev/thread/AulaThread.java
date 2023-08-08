package br.com.jdev.thread;

import javax.swing.JOptionPane;

public class AulaThread {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		/*Criando uma thread thread 1 - envio de email*/
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();
		/*===================================================================*/
		
		/*Criando uma thread thread 2 - envio de NFE*/
		Thread threadEletronica = new Thread(thread2);
		threadEletronica.start();
		
		System.out.println("Exibe fim thread");
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuario");
	}
	
	private static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
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
		}
	};
	
	private static Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			/*Aqui dentro escrevemos a rotina do thread*/
			/*Gerando uma rotina de thread para execução*/
			for (int pos = 0; pos < 10; pos++) {
				
				// Thread.sleep(1000); /*Passando um tempo para executar o print*/
				/*Executando essa linha abaixo com tempo de parada*/
				System.out.println("Executando alguma rotina 2");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			/*Fim da rotina*/
		}
	};
	
}
