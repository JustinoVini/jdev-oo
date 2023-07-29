package br.com.jdev.main;

import br.com.jdev.entity.Aluno;
import br.com.jdev.entity.Disciplina;

public class VetoresMain {
	
	public static void main(String[] args) {
		
		/*Passando as notas estaticamente*/
		double[] notas = {8.8,9.8,4.5,6.8};
		
		/*Chamando o aluno*/
		Aluno aluno = new Aluno();
		aluno.setNome("Vinicius");
		aluno.setNomeEscola("Teste");
		
		/*Chamando a disciplina*/
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Curso de Java");
		disciplina.setNota(notas);	
		
		aluno.getDisciplinas().add(disciplina);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Curso de Java");
		disciplina2.setNota(notas);	
		
		aluno.getDisciplinas().add(disciplina2);
	}
	
}
