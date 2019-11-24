package biblioteca.util.arvore;

public class Node<T> {
	private Node<T> left;
	private Node<T> right;
	private T nome;

	public Node(T nome) {
		this.nome = nome;
		this.setLeft(null);
		this.setRight(null);
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	public T getNome() {
		return nome;
	}

	public String toString() {
		return "Node [esquerda=" + left + ", direita=" + right + ", nome=" + nome + "]";
	}
	
	



}
