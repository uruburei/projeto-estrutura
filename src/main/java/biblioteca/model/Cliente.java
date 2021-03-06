package biblioteca.model;

import biblioteca.util.lista.*;

public class Cliente {
	private String nome, endereco, cpf, codigo;
	private Lista<Livro> livros;
	
	public Cliente(String nome, String endereco, String cpf, String codigo) {
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String toString() {
		return "Cliente:\nnome= " + nome + "\nendereco= " + endereco + "\ncpf= " + cpf + "\ncodigo= " + codigo + ".";
	}
	
	public void alugarLivro(Node<Livro> livro) {
		livros.inserirNocomeco(livro);
	}
	
	public void verLivrosAlugados() {
		livros.imprimirLista();
	}
	
	public void removerLivro(Node<Livro> livro) {
		livros.removerPosicao(livros.pesquisarElemento(livro));
	}
	

}
