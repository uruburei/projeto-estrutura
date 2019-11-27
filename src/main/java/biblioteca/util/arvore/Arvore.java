package biblioteca.util.arvore;

import com.google.gson.Gson;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Arvore<T> implements Serializable {
	public Node2<T> root;
	public T index;
	int qntNode = 0;
	public ArrayList sorted = new ArrayList();
	public ArrayList formated = new ArrayList();


	public Arvore() {
		
	}

	public void add(T nome) {
		add(root, nome);
	}

	public void view() {
		formated.clear();
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
			formated.add(nome);
		} else {
			if (nome.toString().charAt(0) < node.getNome().toString().charAt(0)) {
				if (node.getLeft() != null) {
					add(node.getLeft(), nome);
				} else {
					System.out.println("'" + nome + "' on the left of '" + node.getNome() + "'");
					node.setLeft(new Node2(nome));
					qntNode++;
					formated.add(nome);
				}
			}
			if (nome.toString().charAt(0) > node.getNome().toString().charAt(0)) {
				if (node.getRight() != null) {
					add(node.getRight(), nome);
				} else {
					System.out.println("'" + nome + "' on the right of '" + node.getNome() + "'");
					node.setRight(new Node2(nome));
					qntNode++;
					formated.add(nome);
				}
			} else if (nome.toString().charAt(0) == node.getNome().toString().charAt(0)) {
				System.out.println("'" + nome + "' already exists!");
			}
		}
	}



	public void find(String value){
		find(root,value);
	}

	private void find(Node2 node2,String value){
		index = null;
		if(!node2.getNome().toString().equals(value)){
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
		formated.add(node2.getNome());
	}

	public int getTotalNodes() {
		// Metodo dispon�vel em teste
		return qntNode;
	}

	public void deleteKey(String key)
	{
		root = deleteRec(root, key);
	}

	Object minValue(Node2 root)
	{
		Object minv = root.getNome();
		while (root.getLeft() != null)
		{
			minv = root.getLeft().getNome();
			root = root.getLeft();
		}
		return minv;
	}

	public Node2 deleteRec(Node2 root, String key)
	{
		if (root.getNome() == null)  return root;

		if (key.compareToIgnoreCase(root.getNome().toString()) < 0)
			root.setLeft(deleteRec(root.getLeft(), key));
		else if (key.compareToIgnoreCase(root.getNome().toString()) > 0)
			root.setRight(deleteRec(root.getRight(), key));

			// if key is same as root's key, then This is the node
			// to be deleted
		else
		{
			if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();
			root.setNome(minValue(root.getRight()));

			root.setRight(deleteRec(root.getRight(), root.getNome().toString()));
		}

		return root;
	}


	public void inorderRec(Node2 root2)
	{
		if (root2 != null)
		{
			inorderRec(root2.getLeft());
			sorted.add(root2.getNome());
			inorderRec(root2.getRight());
		}
	}

}