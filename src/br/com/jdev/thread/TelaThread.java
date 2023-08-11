package br.com.jdev.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaThread extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jPanel = new JPanel(new GridBagLayout()); /* Painel de componentes */

	private JLabel descricaoHora = new JLabel("Nome"); /* Time thread 1 */
	private JTextField mostraTempo = new JTextField();

	private JLabel descricaoHora2 = new JLabel("email"); /* Time thread 1 */
	private JTextField mostraTempo2 = new JTextField();

	private JButton jButton = new JButton("Add lista");
	private JButton jButton2 = new JButton("Stop");

	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	public TelaThread() { /* Vai executar o que tiver dentro da abertura da execução */
		setTitle("Tela timer com thread");
		setSize(new Dimension(240, 360));
		setLocationRelativeTo(null);
		setResizable(false);

		/* Inicializando o grid */
		GridBagConstraints gridBagConstraints = new GridBagConstraints(); /* Layout control */
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);

		mostraTempo.setPreferredSize(new Dimension(200, 25));
		// mostraTempo.setEditable(false);
		gridBagConstraints.gridy++; /* Pulando o tamanho na lista */
		jPanel.add(mostraTempo, gridBagConstraints);

		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);

		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		// mostraTempo2.setEditable(false);
		gridBagConstraints.gridy++; /* Pulando o tamanho na lista */
		jPanel.add(mostraTempo2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;

		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++; /* Pulando o tamanho na lista */
		jPanel.add(jButton, gridBagConstraints);

		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++; /* Pulando o tamanho na lista */
		jPanel.add(jButton2, gridBagConstraints);

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { /* Executa o click do botao */

				if (fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}

				for (int qtd = 0; qtd < 100; qtd++) { /* Simulando 100 envios em massa */

					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(mostraTempo.getText());
					filaThread.setEmail(mostraTempo2.getText() + " - " + qtd);

					fila.adiciona(filaThread);
				}
			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { /* Executa o click do botao */

				fila.stop();
				fila = null;

			}
		});

		fila.start();

		add(jPanel, BorderLayout.WEST);

		setVisible(true);
	}
}
