package biblioteca.util.arvore;

public class Node2<T> {
	private Node2<T> left;
	private Node2<T> right;
	private T nome;

	public Node2(T nome) {
		this.nome = nome;
		this.setLeft(null);
		this.setRight(null);
	}

	public Node2 getLeft() {
		return left;
	}

	public void setLeft(Node2 left) {
		this.left = left;
	}

	Node2 getRight() {
		return right;
	}

	public void setRight(Node2 right) {
		this.right = right;
	}
	public T getNome() {
		return nome;
	}

	public String toString() {
		return "Node [esquerda=" + left + ", direita=" + right + ", nome=" + nome + "]";
	}
	
	



}
