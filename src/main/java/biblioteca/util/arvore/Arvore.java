package biblioteca.util.arvore;

public class Arvore<T> {
	Node2<T> root;
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

	private void add(Node2<T> node, T nome) {
		// Metodo recursivo
		if (node == null) {
			root = new Node2(nome);
			System.out.println("'" + nome + "' is the new groot");

		} else {
			if (nome.toString().compareToIgnoreCase(node.getNome().toString()) < 0) {
				if (node.getLeft() != null) {
					add(node.getLeft(), nome);
				} else {
					System.out.println("'" + nome + "' on the left of '" + node.getNome() + "'");
					node.setLeft(new Node2(nome));
				}
			}

			if (nome.toString().compareToIgnoreCase(node.getNome().toString()) > 0) {
				if (node.getRight() != null) {
					add(node.getRight(), nome);
				} else {
					System.out.println("'" + nome + "' on the right of '" + node.getNome() + "'");
					node.setRight(new Node2(nome));
				}
			} else if (nome == node.getNome()) {
				System.out.println("'" + nome + "' already exists!");
			}
		}
	}

	private void view(Node2 node2) {
		// Metodo recursivo
		if (node2.getLeft() != null) {
			view(node2.getLeft());
		}
		if (node2.getRight() != null) {
			view(node2.getRight());
		}
		qntNode++;
		System.out.println(" Node" + qntNode + ": '" + node2.getNome() + "'");
	}

	public int getTotalNodes() {
		// Metodo dispon�vel em teste
		return qntNode;
	}
	
	public void remove(T value)  {
		remove(root, value);
	}
	private void remove(Node2 node2, T value) {
		
		if (value != node2.getNome() ) {
			remove(node2.getLeft(), value);
			remove(node2.getRight(), value);
						
			} else {
				if (node2.getLeft() == null && node2.getRight() == null) {
					System.out.println(node2.getNome()+" removed.");
					node2 = null;
					qntNode--;
				}
			}
	}

}