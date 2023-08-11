package br.com.jdev.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void adiciona(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}

	@Override
	public void run() {

		System.out.println("Fila rodando");

		while (true) {

			synchronized (pilha_fila) { /* Bloquear o acesso a esta lista por outros processos */

				Iterator iteracao = pilha_fila.iterator();
				while (iteracao.hasNext()) { /* Enquanto conter dados na lista irá processar */

					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();
					
					System.out.println("--------------------------------");
					
					System.out.println(processar.getEmail());
					System.out.println(processar.getNome());

					/* Processar 10 mil NFE */
					iteracao.remove();

					try {
						Thread.sleep(100); /* Dar um tempo pra descarga de memoria */
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			try {
				Thread.sleep(1000); /* Ao processar toda a lista da um tempo para a limpeza de memoria */
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
