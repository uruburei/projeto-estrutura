package biblioteca.util.lista;

public class Lista<T> {
	int qtdelementos;
	Node<T> primeiro, ultimo;
	
	public Lista() {
		this.qtdelementos = 0;
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public void inserirNocomeco(Node<T> objeto) {
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
	
	public void inserirNoFinal(Node<T> objeto) {
		if(this.qtdelementos == 0) {
			this.ultimo  = this.primeiro;
			Node<T> novo = objeto;
			novo.setProximo(ultimo);
			this.ultimo = novo;
		}else {
			Node<T> novo2 = objeto;
			novo2.setProximo(ultimo);
			ultimo = novo2;
		}
		this.qtdelementos++;
	}
	
	public void inserirQualquerPosicao(int posicao, Node<T> objeto) {
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
				aux.getProximo();
			}
			aux.setProximo(null);
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
	
	public int pesquisarElemento(Node<T> objeto) {
		Node<T> aux = this.primeiro;
		int i = 0;
		while(aux.getProximo() != null) {
			i++;
			if(aux == objeto) {
				return i;
			}
			aux = aux.getProximo();
		}
		return i;
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
}
