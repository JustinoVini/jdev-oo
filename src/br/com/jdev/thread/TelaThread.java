package br.com.jdev.thread;

import java.awt.Dimension;

import javax.swing.JDialog;

public class TelaThread extends JDialog {

	private static final long serialVersionUID = 1L;

	public TelaThread() { /*Vai executar o que tiver dentro da abertura da execução*/
		setTitle("Tela timer com thread");
		setSize(new Dimension(240, 360));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);
	}
}
