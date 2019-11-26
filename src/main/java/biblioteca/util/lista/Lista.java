package biblioteca.util.lista;

import java.io.Serializable;

public class Lista<T> implements Serializable {
	public int qtdelementos;
	public Node<T> primeiro, ultimo;
	
	public Lista() {
		this.qtdelementos = 0;
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public void inserirNocomeco(T objeto) {
		Node<T> node = new Node<T>(objeto);
		inserirNocomeco(node);
	}
	
	public void inserirNoFinal(T objeto) {
		Node<T> node = new Node<T>(objeto);
		inserirNoFinal(node);
	}
	
	public void inserirQualquerPosicao(int posicao, T objeto) {
		Node<T> node = new Node<T>(objeto);
		inserirQualquerPosicao(posicao, node);
	}
	
	private void inserirNocomeco(Node<T> objeto) {
		if(this.qtdelementos == 0) {
			this.ultimo  = this.primeiro;
			Node<T> novo = objeto;
			novo.setProximo(primeiro);
			this.primeiro = novo;
		}else {
			Node<T> novo2 = objeto;
			novo2.setProximo(primeiro);
			primeiro = novo2;
		}
		this.qtdelementos++;
	}
	
	private void inserirNoFinal(Node<T> objeto) {
		if(this.qtdelementos == 0) {
			this.ultimo  = this.primeiro;
			Node<T> novo = objeto;
			novo.setProximo(ultimo);
			this.primeiro = novo;
		}else {
			Node<T> novo2 = objeto;
			novo2.setProximo(ultimo);
			ultimo = novo2;
		}
		this.qtdelementos++;
	}
	
	private void inserirQualquerPosicao(int posicao, Node<T> objeto) {
		Node<T> novo = objeto;
		Node<T> aux = this.primeiro;
		if(posicao < 0 || posicao > this.qtdelementos) {
			System.out.println("Posição invalida");
		}
		if(posicao == this.qtdelementos) {
			this.inserirNoFinal(objeto);
		}else if (posicao == 0) {
			this.inserirNocomeco(objeto);
		}else {
			for(int i =0; i<posicao-1; i++) {
				aux = aux.getProximo();
			}
			novo.setProximo(aux.getProximo());
			aux.setProximo(novo);
			aux = novo;
		}
		this.qtdelementos++;
	}
	
	public void removerNoInicio() {
		if(this.qtdelementos == 0) {
			System.out.println("Não existe elementos a ser removido");
		}else {
			Node<T> aux = primeiro;
			primeiro = primeiro.getProximo();
			aux.setProximo(null);
			this.qtdelementos--;
		}
		
	}
	
	public void removerNoFinal() {
		if(this.qtdelementos == 0) {
			System.out.println("Não existe elementos a ser removido");
		}else {
			Node<T> aux = primeiro;
			while(aux.getProximo() != null){
				aux=aux.getProximo();
			}
			aux.setAtual(null);
			this.qtdelementos--;
		}
		
	}
	
	public void removerPosicao(int posicao) {
		if(posicao < 0 || posicao >this.qtdelementos) {
			System.out.println("posicao invalida");
		}
		if(posicao == this.qtdelementos) {
			removerNoFinal();
		}else if (posicao == 1) {
			removerNoInicio();
		}else if (posicao == 0) {
			System.out.println("lista vazia");
		}else {
			Node<T> aux = primeiro;
			for(int i =0; i < posicao; i++) {
				if (i == posicao -2) {
					aux.setProximo(aux.getProximo().getProximo());
					this.qtdelementos--;
				}
				aux = aux.getProximo();
			}
		}
	}

	public Object pesquisarElemento(String nome) {
		Node<T> aux = this.primeiro;
		T found = null;
		while(aux.getProximo() != null) {
			if(aux.getProximo().toString().equals(nome)) {
				found = aux.getAtual();
			}
				aux = aux.getProximo();
		}
		return found;
	}
	
	public void imprimirLista() {
		if(this.qtdelementos == 0) {
			System.out.println("[]");
		}else {
			System.out.println("[");
			Node<T> aux = this.primeiro;
			for(int i = 0; i<this.qtdelementos-1; i++) {
				System.out.println(aux + ",");
				aux = aux.getProximo();
			}
			System.out.println(aux + "]");
		}
		
	}
	
	public void ordenarLista() {
		for (int i = 0; i != qtdelementos; i++) {
			if(primeiro.getAtual().toString().charAt(i) > primeiro.getProximo().getAtual().toString().charAt(i)){
				Node<T> aux = primeiro.getProximo();
				primeiro.setAtual((T)primeiro.getProximo().getAtual());
				primeiro.getProximo().setAtual(aux);
			}
		}




//		int i=0;
//		Node<T> aux = primeiro.getProximo().getProximo();
//		primeiro.getProximo();
//		primeiro.getAtual();
//		while (aux.getProximo() != null){
//			if(aux.getAtual().toString().charAt(i) > aux.getProximo().toString().charAt(i)) {
//				aux.setProximo(aux);
//			}else if(aux.getAtual().toString().charAt(i) == aux.getProximo().toString().charAt(i)){
//				i++;
//			}
//			aux = aux.getProximo();
//		}
//		imprimirLista();
//		if(primeiro.getAtual().toString().charAt(0) > primeiro.getProximo().toString().charAt(0)) {
//
//			System.out.println("menor");
//
//			ordenarLista();
//		}
//		if (primeiro.getAtual().toString().charAt(0) < primeiro.getProximo().toString().charAt(0)) {
//			ordenarLista();
//			System.out.println("maior");
//		}
//		if(primeiro.getAtual().toString().charAt(0) == primeiro.getProximo().toString().charAt(0)){
//			imprimirLista();
//		}
//		imprimirLista();
	}
}


