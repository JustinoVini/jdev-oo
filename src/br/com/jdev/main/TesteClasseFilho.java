package br.com.jdev.main;

import br.com.jdev.entity.Aluno;
import br.com.jdev.entity.Diretor;
import br.com.jdev.entity.Pessoa;
import br.com.jdev.entity.Secretario;

public class TesteClasseFilho {
	
	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Vinicius");
		aluno.setIdade(16);
		
		Diretor diretor = new Diretor();
		diretor.setNome("Diretor");
		diretor.setIdade(50);
		
		Secretario s = new Secretario();
		s.setNome("Secretario");
		s.setIdade(30);
		
		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(s);
		
		System.out.println(aluno.pessoaMaiorIdade() + " - " + aluno.msgMaiorIdade());
		System.out.println(diretor.pessoaMaiorIdade());
		System.out.println(s.pessoaMaiorIdade());
		
		System.out.println("Salário é igual = " + aluno.salario());
		System.out.println("Salário diretor é igual = " + diretor.salario());
		System.out.println("Salário secretario é igual = " + s.salario());
		
		/*Polimorfismo*/
		Pessoa pessoa = new Aluno();
		
		/*casting de pessoa para secretario*/
		pessoa = s;
		
		teste(aluno);
		teste(diretor);
		teste(s);
		
	}
	
	public static void teste(Pessoa pessoa) {
		System.out.println("Essa é a pessoa" + pessoa.getNome() 
		+ " e o salário é de: " + pessoa.salario());
	}

}
