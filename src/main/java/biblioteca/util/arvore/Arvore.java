package biblioteca.util.arvore;

import com.google.gson.Gson;

import java.io.Serializable;

public class Arvore<T> implements Serializable {
	Node2<T> root;
	public T index;
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
			qntNode++;
			System.out.println("'" + nome + "' is the new groot");
		} else {
			if (Integer.parseInt(nome.toString()) < Integer.parseInt(node.getNome().toString())) {
				if (node.getLeft() != null) {
					add(node.getLeft(), nome);
				} else {
					System.out.println("'" + nome + "' on the left of '" + node.getNome() + "'");
					node.setLeft(new Node2(nome));
					qntNode++;
				}
			}
			if (Integer.parseInt(nome.toString()) > Integer.parseInt(node.getNome().toString())) {
				if (node.getRight() != null) {
					add(node.getRight(), nome);
				} else {
					System.out.println("'" + nome + "' on the right of '" + node.getNome() + "'");
					node.setRight(new Node2(nome));
					qntNode++;
				}
			} else if (Integer.parseInt(nome.toString()) == Integer.parseInt(node.getNome().toString())) {
				System.out.println("'" + nome + "' already exists!");
			}
		}
	}


	public void find(T value){
		find(root,value);
	}

	private void find(Node2 node2,T value){
		index = null;
		if(Integer.parseInt(node2.getNome().toString()) != Integer.parseInt(value.toString())){
			if (node2.getLeft() != null)
				find(node2.getLeft(),value);
			if (node2.getRight() != null)
				find(node2.getRight(),value);
		}else {
			index= (T) node2.getNome();
		}
	}

	public void update(T value){
		update(root,value);
	}

	private void update(Node2 node2,T value){
		if(Integer.parseInt(node2.getNome().toString()) != Integer.parseInt(value.toString())){
			if (node2.getLeft() != null)
				update(node2.getLeft(),value);
			if (node2.getRight() != null)
				update(node2.getRight(),value);
		}else {
			node2.setNome(value);
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