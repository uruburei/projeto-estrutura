package biblioteca.model;

import biblioteca.util.arvore.Arvore;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
	private String nome, endereco, cpf;
	public ArrayList livros2;
	
	public Cliente(String nome, String endereco, String cpf, String codigo) {
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		livros2 = new ArrayList();
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

	public void alugarLivro(ArrayList x) {
		livros2=x;
	}


}
