package br.com.jdev.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelaThread extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jPanel = new JPanel(new GridBagLayout()); /*Painel de componentes*/
	
	private JLabel descricaoHora = new JLabel("Time Thread 1"); /*Time thread 1*/
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel("Time Thread 2"); /*Time thread 1*/
	private JTextField mostraTempo2 = new JTextField();
	
	public TelaThread() { /*Vai executar o que tiver dentro da abertura da execução*/
		setTitle("Tela timer com thread");
		setSize(new Dimension(240, 360));
		setLocationRelativeTo(null);
		setResizable(false);
		
		/*Inicializando o grid*/
		GridBagConstraints gridBagConstraints = new GridBagConstraints(); /*Layout control*/
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);
		
		mostraTempo.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++; /*Pulando o tamanho na lista*/
		jPanel.add(mostraTempo, gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++; /*Pulando o tamanho na lista*/
		jPanel.add(mostraTempo2, gridBagConstraints);
		
		add(jPanel, BorderLayout.WEST);
		
		setVisible(true);
	}
}
