package biblioteca.util.lista;

import java.io.Serializable;

public class Node<T> implements Serializable {
	private Node<T> proximo;
	private T atual;

	public Node(T atual) {
		this.atual = atual;
	}

	public T getAtual() {
		return atual;
	}

	public void setAtual(T atual) {
		this.atual = atual;
	}

	public void setProximo(Node<T> proximo) {
		this.proximo = proximo;
	}

	public Node getProximo() {
		return proximo;
	}

	public String toString() {
		return "[proximo=" + atual + "]\n";
	}

}
