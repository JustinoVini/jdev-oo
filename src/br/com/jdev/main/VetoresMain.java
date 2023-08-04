package br.com.jdev.main;

import br.com.jdev.entity.Aluno;
import br.com.jdev.entity.Disciplina;

public class VetoresMain {
	
	public static void main(String[] args) {
		
		/*Passando as notas estaticamente*/
		double[] notas = {8.8,9.8,4.5,6.8};
		double[] notasLogica = {10.0,9.7,4.5,6.8};
		
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
		disciplina2.setDisciplina("Engenharia de software");
		disciplina2.setNota(notasLogica);	
		
		aluno.getDisciplinas().add(disciplina2);
		
		//----------------------------------------------------
		Aluno[] arrayAlunos = new Aluno[1];
		
		arrayAlunos[0] = aluno;
		
		for (int pos = 0; pos < arrayAlunos.length; pos++) {
			
			System.out.println("Nome do aluno é: " + arrayAlunos[pos].getNome());
			
			for (Disciplina disc : arrayAlunos[pos].getDisciplinas()) {
				
				System.out.println("Nome da disciplina é: " + disc.getDisciplina());
				
				for (int posNota = 0; posNota < disc.getNota().length; posNota++) {
					
					System.out.println("A nota número : " + posNota + "é igual = " + disc.getNota()[posNota]);
					
				}
				
			}
			
		}
		
	}
	
}

/*
 * System.out.println("Nome do Aluno = " + aluno.getNome() + "inscrito no curso: " 
		+ aluno.getNomeEscola());
		System.out.println("============= Disciplinas do aluno =============");
		for (Disciplina disc : aluno.getDisciplinas()) {
			
			System.out.println("Disciplinas : " + disc.getDisciplina());
			System.out.println("As notas da disciplina são: ");
			
			double notaMaxima = 0.0;
			double notaMinima = 0.0;
			
			for (int pos = 0; pos < disc.getNota().length; pos++) {
				System.out.println("nota " + (pos + 1) + " é igual = " + disc.getNota()[pos]);
				
				/*Descobrindo a maior nota
				if (pos == 0) {
					notaMaxima = disc.getNota()[pos];
					notaMinima = disc.getNota()[pos];
				} else {
					if (disc.getNota()[pos] > notaMaxima) {
						notaMaxima = disc.getNota()[pos];
					} else if (disc.getNota()[pos] < notaMaxima) {
						notaMinima = disc.getNota()[pos];
					}
				}
			}
			
			System.out.println("A maior nota da disciplina = " + disc.getDisciplina() + " é de valor : " + notaMaxima);
			System.out.println("A menor nota da disciplina = " + disc.getDisciplina() + " é de valor : " + notaMinima);
		}
 * */
