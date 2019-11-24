package biblioteca.model;

import java.io.Serializable;

public class Livro implements Serializable {
	private String nome, codigo, genero;
	private int quantidadepaginas;
	
	public Livro(String nome, String codigo, String genero, int quantidadepaginas) {
		this.nome = nome;
		this.codigo = codigo;
		this.genero = genero;
		this.quantidadepaginas = quantidadepaginas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getQuantidadepaginas() {
		return quantidadepaginas;
	}

	public void setQuantidadepaginas(int quantidadepaginas) {
		this.quantidadepaginas = quantidadepaginas;
	}

	@Override
	public String toString() {
		return "Livro: \nnome=" + nome + "\ncodigo=" + codigo + "\ngenero=" + genero + "\nquantidadepaginas="
				+ quantidadepaginas + ".";
	}
	
	
	
	
}
