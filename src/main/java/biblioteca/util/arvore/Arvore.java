package biblioteca.util.arvore;

public class Arvore<T> {
	Node<T> root;
	int qntNode = 0;

	public Arvore() {
		
	}

	public void add(T nome) {
		// Metodo dispon�vel em teste
		add(root, nome);
	}

	public void view() {
		// Metodo dispon�vel em teste
		if (root == null) {
			System.out.println("Empty tree, no groot");
		} else {
			view(this.root);
		}
	}

	private void add(Node<T> node, T nome) {
		// Metodo recursivo
		if (node == null) {
			root = new Node(nome);
			System.out.println("'" + nome + "' is the new groot");

		} else {
			if (nome.toString().compareToIgnoreCase(node.getNome().toString()) < 0) {
				if (node.getLeft() != null) {
					add(node.getLeft(), nome);
				} else {
					System.out.println("'" + nome + "' on the left of '" + node.getNome() + "'");
					node.setLeft(new Node(nome));
				}
			}

			if (nome.toString().compareToIgnoreCase(node.getNome().toString()) > 0) {
				if (node.getRight() != null) {
					add(node.getRight(), nome);
				} else {
					System.out.println("'" + nome + "' on the right of '" + node.getNome() + "'");
					node.setRight(new Node(nome));
				}
			} else if (nome == node.getNome()) {
				System.out.println("'" + nome + "' already exists!");
			}
		}
	}

	private void view(Node node) {
		// Metodo recursivo
		if (node.getLeft() != null) {
			view(node.getLeft());
		}
		if (node.getRight() != null) {
			view(node.getRight());
		}
		qntNode++;
		System.out.println(" Node" + qntNode + ": '" + node.getNome() + "'");
	}

	public int getTotalNodes() {
		// Metodo dispon�vel em teste
		return qntNode;
	}
	
	public void remove(T value)  {
		remove(root, value);
	}
	private void remove(Node node, T value) {
		
		if (value != node.getNome() ) {
			remove(node.getLeft(), value);
			remove(node.getRight(), value);
						
			} else {
				if (node.getLeft() == null && node.getRight() == null) {
					System.out.println(node.getNome()+" removed.");
					node = null;
					qntNode--;
				}
			}
	}

}