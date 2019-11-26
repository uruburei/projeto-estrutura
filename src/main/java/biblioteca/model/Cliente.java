package biblioteca.model;

import biblioteca.util.lista.*;

import java.io.Serializable;

public class Cliente implements Serializable {
	private String nome, endereco, cpf;
	private Lista<Livro> livros;
	
	public Cliente(String nome, String endereco, String cpf, String codigo) {
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		livros = new Lista<Livro>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String toString() {
		return cpf;
	}

	public void alugarLivro(Livro livro) {
		livros.inserirNocomeco(livro);
	}
	
	public void verLivrosAlugados() {
		livros.imprimirLista();
	}

//	public void removerLivro(Livro livro) {
//		livros.removerPosicao(livros.pesquisarElemento(livro.toString()));
//	}

}
