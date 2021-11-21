package com.deniza.utils.ListaDuplaEncadeadaInt;

public class ListaDuplaEncadeada {
	
	No cabeca;
	No cauda;
	
	public ListaDuplaEncadeada() {
		cabeca = null;
		cauda = null;
	}
	
	public boolean isEmpty() {
		if(cabeca == null && cauda == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void insertAtBack(int valor) {
		No elemento = new No();
		elemento.dado = valor;
		
		if(cabeca == null) {
			cabeca = elemento;
			cauda = elemento;
			elemento.proximo = null;
			elemento.anterior = null;
		} else {
			cauda.proximo = elemento;
			elemento.proximo = null;
			elemento.anterior = cauda;
			cauda = elemento;
		}
	}
	
	public void insertAtFront(int valor) {
		No elemento = new No();
		elemento.dado = valor;
		
		if(cabeca == null) {
			cabeca = elemento;
			cauda = elemento;
			elemento.proximo = null;
			elemento.anterior = null;
		} else {
			elemento.proximo = cabeca;
			elemento.anterior = null;
			cabeca.anterior = elemento;
			cabeca = elemento;
		}
	}
	
	public int removeAtFront() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		No auxiliar = cabeca;
		if(cabeca == cauda && cabeca != null) {
			cabeca = null;
			cauda = null;
		} else {
			cabeca = cabeca.proximo;
			cabeca.anterior = null;
		}
		return auxiliar.dado;
	}
	
	public int removeAtBack() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		No auxiliar = cauda;
		if(cabeca == cauda && cauda != null) {
			cabeca = null;
			cauda = null;
		} else {
			cauda = cauda.anterior;
			cauda.proximo = null;
		}
		return auxiliar.dado;
	}
	
	public void print() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		No auxiliar = cabeca;
		System.out.println("=============================================");
		System.out.println("");
		System.out.print("NULL<==");
		while(auxiliar != null) {
			System.out.print("[][ " + auxiliar.dado + " ][]<==>");
			auxiliar = auxiliar.proximo;
		}
		System.out.println("NULL");
		System.out.println("");
		System.out.println("=============================================");
	}
	
	public int size() {
		int cont = 0;
		if(!isEmpty()) {
			No auxiliar = cabeca;
			while(auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	
	public boolean contains(int valor) {
		boolean achou = false;
		No metade1 = cabeca;
		No metade2 = cauda;
		int numComparacoes = (size() / 2);
		int cont = 0;
		while(cont <= numComparacoes) {
			if(metade1.dado == valor || metade2.dado == valor) {
				return true;
			}
			metade1 = metade1.proximo;
			metade2 = metade2.anterior;
			cont++;
		}
		return achou;
	}
	
	public boolean isBusy(int posicao) {
		boolean ocupado = false;
		if(posicao >= 0 && posicao < size()) {
			ocupado = true;
		}
		return ocupado;
	}
	
	public No getNo(int posicao) throws Exception {
		if(!isBusy(posicao)) {
			throw new Exception("Posição não existe");
		}
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		if(posicao <= (size() - 1) / 2){
			No auxiliar = cabeca;
			for(int i = 0; i <= posicao - 1; i++) {
				auxiliar = auxiliar.proximo;
			}
			return auxiliar;
		} else {
			No auxiliar = cauda;
			for(int i = (size() - 1); i >= posicao + 1; i--) {
				auxiliar = auxiliar.anterior;
			}
			return auxiliar;
		}
	}
	
	public int getValue(int posicao) throws Exception {
		return getNo(posicao).dado;
	}
	
	public void insertPosition(int posicao, int valor) throws Exception {
		if(posicao == 0) {
			insertAtFront(valor);
		} else {
			if(posicao == size() - 1) {
				insertAtBack(valor);
			} else {
				No anterior = getNo(posicao - 1);
				No proximo = anterior.proximo;
				No novoNo = new No();
				novoNo.dado = valor;
				novoNo.proximo = proximo;
				novoNo.anterior = anterior;
				anterior.proximo = novoNo;
				proximo.anterior = novoNo;
			}
		}
	}
	
	public void removePosition(int posicao) throws Exception {
		if(posicao == 0) {
			removeAtFront();
		} else {
			if(posicao == size() - 1) {
				removeAtBack();
			} else {
				No removido = getNo(posicao);
				No anterior = removido.anterior;
				No proximo = removido.proximo;
				anterior.proximo = proximo;
				proximo.anterior = anterior;
			}
		}
	}
	
	@Override
	public String toString() {
		int tamanho = size();
		if(tamanho == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No atual = cabeca;
		for(int i = 0; i < tamanho - 1; i++) {
			builder.append(atual.dado);
			builder.append(", ");
			atual = atual.proximo;
		}
		builder.append(atual.dado);
		builder.append("]");
		return builder.toString();
	}

}
