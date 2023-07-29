package br.com.jdev.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.jdev.auxiliares.FuncaoAutenticacao;
import br.com.jdev.constantes.StatusAluno;
import br.com.jdev.entity.Aluno;
import br.com.jdev.entity.Diretor;
import br.com.jdev.entity.Disciplina;
import br.com.jdev.exceptions.ProcessarNotaException;
import br.com.jdev.interfaces.PermitirAcesso;

public class Main {

	public static void main(String[] args) throws FileNotFoundException { /* Tratando multiplas exceptions */

		try {

			lerArquivo();

			String login = JOptionPane.showInputDialog("Informe o login");
			String senha = JOptionPane.showInputDialog("Informe a senha");

			PermitirAcesso permitirAcesso = new Diretor(login, senha);
			// PermitirAcesso permitirAcesso = new Secretario(login, senha);

			// PermitirAcesso secretario = new Secretario(); /*Diretamente com o obj*/

			/* Fazendo a condição com o método autenticar */
			if (new FuncaoAutenticacao(permitirAcesso).autenticar()) { /* Se true acessa senao nao acessa */
				/*
				 * Travar o contrato para autorizar somente quem realmente tem o contrato 100%
				 * legitimo
				 */

				List<Aluno> alunos = new ArrayList<Aluno>();

				/* Utilizando collections */
				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

				/* Criando a lista de alunos */
				for (int qtd = 1; qtd <= 2; qtd++) {

					String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd + "?");
					String idade = JOptionPane.showInputDialog("Informe a idade do aluno");

					/*
					 * String dataNascimento =
					 * JOptionPane.showInputDialog("Informe a data de nascimento"); String rg =
					 * JOptionPane.showInputDialog("Informe o registro geral"); String cpf =
					 * JOptionPane.showInputDialog("Qual é o CPF"); String nomeMae =
					 * JOptionPane.showInputDialog("Informe o nome da mae"); String nomePai =
					 * JOptionPane.showInputDialog("Informe o nome do pai"); String matricula =
					 * JOptionPane.showInputDialog("Informe a data da matricula"); String escola =
					 * JOptionPane.showInputDialog("Informe a escola"); String serieMatriculado =
					 * JOptionPane.showInputDialog("Qual a serie");
					 */

					Aluno aluno1 = new Aluno();

					aluno1.setNome(nome);
					aluno1.setIdade(Integer.valueOf(idade));

					/*
					 * aluno1.setDataNascimento(dataNascimento); aluno1.setRegistroGeral(rg);
					 * aluno1.setNumeroCpf(cpf); aluno1.setNomePai(nomePai);
					 * aluno1.setNomeMae(nomeMae); aluno1.setDataMatricula(matricula);
					 * aluno1.setNomeEscola(escola); aluno1.setSerieMatriculado(serieMatriculado);
					 */

					/* fazendo a dinamica para pedir notas e disciplinas */
					for (int pos = 1; pos <= 1; pos++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ?");
						String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina: " + pos + " ?");

						Disciplina disciplina = new Disciplina();
						disciplina.setDisciplina(nomeDisciplina);
						//disciplina.setNota(Double.valueOf(notaDisciplina));

						aluno1.getDisciplinas().add(disciplina);
					}

					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

					if (escolha == 0) { /* sim == 0 */

						/* do while para remover quantas disciplinas o usuario quer remover */

						int continuarRemover = 0;
						int posicao = 1;

						while (continuarRemover == 0) {

							String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3, 4");
							aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
							posicao++; /* incrementa mais um item na lista após a remoção */
							continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
						}

					}

					alunos.add(aluno1);
				}

				/* Inicializando os valores padrões */
				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

				for (Aluno aluno : alunos) {

					/* Condições para separar alunos reprovados, aprovados e em recuperação */
					if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno); // add aluno aprovado na lista com maps
					} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
						maps.get(StatusAluno.RECUPERACAO).add(aluno);
					} else {
						maps.get(StatusAluno.REPROVADO).add(aluno);
					}

				}

				System.out.println("============== lista de aprovados ==============");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
					System.out
							.println("Resultado = " + aluno.getAlunoAprovado2() + "Media de = " + aluno.getMediaNota());
				}

				System.out.println("============== lista de Reprovados ==============");
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
					System.out
							.println("Resultado = " + aluno.getAlunoAprovado2() + "Media de = " + aluno.getMediaNota());
				}

				System.out.println("============== lista de Recuperação ==============");
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
					System.out
							.println("Resultado = " + aluno.getAlunoAprovado2() + "Media de = " + aluno.getMediaNota());
				}

			} else {
				JOptionPane.showMessageDialog(null, "Acesso não permitido");
			}

		} catch (NumberFormatException e) {

			StringBuilder saida = new StringBuilder();

			e.printStackTrace(); // imprime qual o erro (log)

			/* Mensagem do erro ou causa */
			System.out.println("Mensagem: " + e.getMessage()); // passando a mensagem

			for (int i = 0; i <= e.getStackTrace().length; i++) {

				/*
				 * As linhas abaixo pegam a linha, método e classe do array de getStackTrace que
				 * que no caso é um array.
				 */
				saida.append("\nClasse de erro: " + e.getStackTrace()[i].getClassName());
				saida.append("\nMétodo de erro: " + e.getStackTrace()[i].getMethodName());
				saida.append("\nLinha de erro: " + e.getStackTrace()[i].getLineNumber());
				saida.append("\nClass: " + e.getClass().getName());

			}

			JOptionPane.showMessageDialog(null, "Erro de conversão de numero" + saida.toString());
		} catch (NullPointerException ex) { /* Multiplos catch */
			JOptionPane.showMessageDialog(null, "Opaa null pointer exception" + ex.getClass());
		} catch (FileNotFoundException e) { /* Captura todas as excessões que não prevemos */
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro da exception customizada: " + e.getClass().getName());
		} finally { /* Sempre é executado ocorrendo erros ou não */
			/*
			 * Finally sempre é usado quando precisa executar um processo acontecendo ou não
			 */
			JOptionPane.showMessageDialog(null, "Obrigado por executar esse teste");
		}
	}

	/* Lançando exceptions para cima */
	public static void lerArquivo() throws FileNotFoundException {
		File file = new File("c://teste.txt");
		Scanner sc = new Scanner(file);
	}

}

/*
 * 
 * Percorrendo a lista por posições for (int pos = 0; pos < alunos.size();
 * pos++) {
 * 
 * Aluno aluno = alunos.get(pos);
 * 
 * // substituindo um aluno na lista if
 * (aluno.getNome().equalsIgnoreCase("alex")) { Aluno trocar = new Aluno();
 * trocar.setNome("Aluno foi trocado");
 * 
 * Disciplina disciplina = new Disciplina();
 * disciplina.setDisciplina("Matematica"); disciplina.setNota(96);
 * 
 * trocar.getDisciplinas().add(disciplina);
 * 
 * alunos.set(pos, trocar); aluno = alunos.get(pos); }
 * 
 * System.out.println("aluno =" + aluno.getNome()); System.out.println("media ="
 * + aluno.getMediaNota()); System.out.println("Resultado =" +
 * aluno.getAlunoAprovado2());
 * System.out.println("==========================================");
 * 
 * for (int posd = 0; posd < aluno.getDisciplinas().size(); posd++) { Disciplina
 * disciplina = aluno.getDisciplinas().get(posd);
 * System.out.println("Materia = " + disciplina.getDisciplina() + " Nota = " +
 * disciplina.getNota()); } }
 * 
 * percorrendo a lista de alunos for (Aluno aluno : alunos) { // Procurando o
 * aluno na lista e imprimindo somente a media só desse encontrado
 * 
 * if (aluno.getNome().equalsIgnoreCase("Alex")) { // Procurando e removendo um
 * aluno da lista alunos.remove(aluno); break; //Parando o laço } else {
 * System.out.println(aluno); System.out.println("media do aluno = " +
 * aluno.getMediaNota()); // System.out.println("Resultado = " +
 * (aluno1.getAlunoAprovado() ? "Aprovado" : // "Reprovado"));
 * System.out.println("Resultado = " + aluno.getAlunoAprovado2());
 * System.out.println("==================================================="); }
 * 
 * }
 */
