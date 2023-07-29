package br.com.jdev.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.jdev.constantes.StatusAluno;

/* Objeto aluno */
public class Aluno extends Pessoa { /* Chamando a herança */

	/* Atributos do aluno */
	private String dataMatricula;
	private String nomeEscola;
	private String serieMatriculado;
	/* Chamando a lista de disciplinas */
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	// construtor vazio cria dados padrão do java
	public Aluno() {

	}

	/* Construtor do objeto */
	public Aluno(String nomePadrao) {
		this.nome = nomePadrao;
	}

	public Aluno(String nomePadrao, int idadePadrao) {
		super.nome = nomePadrao;
		this.idade = idadePadrao;
	}

	/*
	 * Criação dos get e set: set add ou recebe dados para os atributos get resgata
	 * ou obtem o valor do atributo
	 */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}

	public String getNumeroCpf() {
		return numeroCpf;
	}

	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}

	/* método que retorna a média do aluno */
	public double getMediaNota() {

		double somaNotas = 0.0;

		/* Percorrendo as disciplinas com foreach */
		for (Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getMediaNotas();
		}

		return somaNotas / disciplinas.size(); // retorna quantas disciplinas tem na lista
	}

	/* Método para ver se está aprovado ou não */
	public boolean getAlunoAprovado() {
		double media = this.getMediaNota();

		if (media >= 70) {
			return true;
		} else {
			return false;
		}
	}

	public String getAlunoAprovado2() {
		double media = this.getMediaNota();

		if (media >= 50) {
			if (media >= 70) {
				return StatusAluno.APROVADO;
			} else {
				return StatusAluno.RECUPERACAO;
			}
		} else {
			return StatusAluno.REPROVADO;
		}
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", registroGeral="
				+ registroGeral + ", numeroCpf=" + numeroCpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai
				+ ", dataMatricula=" + dataMatricula + ", nomeEscola=" + nomeEscola + ", serieMatriculado="
				+ serieMatriculado + "]";
	}

	@Override /*Sobreescrevendo o método da classe pai*/
	public boolean pessoaMaiorIdade() {
		
		return idade >= 21;
	}
	
	public String msgMaiorIdade() {
		return this.pessoaMaiorIdade() ? "Aluno maior de idade" : "Aluno não é maior de idade";
	}

	@Override
	public double salario() {
		
		return 1500.90;
	}

}
