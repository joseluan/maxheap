package br.com.waldson.aula11;

import java.util.Arrays;

public class FilaBanco {
    private Pessoa[] pessoas;
    private int size;//quantos elementos tem
    private int capacity;//quantos elementos cabem

    public FilaBanco() {
        this(10);
    }

    public FilaBanco(int capacity) {
        pessoas = new Pessoa[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void insert(String nome, int idade) {
        insert(new Pessoa(nome, idade));
    }

    public void insert(Pessoa pessoa) {
        ensureCapacity();
        pessoas[getSize()] = pessoa;
        heapifyUp(getSize());
        size++;
    }

    private void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex < 0) {
            return;
        }

        Pessoa pai    = pessoas[parentIndex];
        Pessoa pessoa = pessoas[index];

        if (pessoa.getIdade() > pai.getIdade()) {
            pessoas[index]   = pai;
            pessoas[parentIndex] = pessoa;
            heapifyUp(parentIndex);
        }
    }

    public int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void ensureCapacity() {
        if (size == capacity) {
            pessoas = Arrays.copyOf(pessoas, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int getSize() {
        return size;
    }
    
    public int isMaxHeap() {
    	return isMaxHeap(0);
    }
    
    public int isMaxHeap(int raiz) {
    	int ie = raiz*2, id = (raiz*2) + 1;
    	int retorno1 = -1, retorno2 = -1;
    	if(raiz == 0) {
    		ie = 1;
    		id = 2;
    	}
    	
    	if(ie <= capacity && pessoas[ie] != null) {
    		if(pessoas[ie].getIdade() <= pessoas[raiz].getIdade()) {
    			 retorno1 = isMaxHeap(ie);
    		}else {
    			return ie;
    		}
    	}
    	
    	if(id <= capacity && pessoas[id] != null) {
    		if(pessoas[id].getIdade() <= pessoas[raiz].getIdade()) {
    			retorno2 = isMaxHeap(id);
    		}else {
    			return id;
    		}
    	}
    	
    	if(retorno1 == -1 && retorno2 == -1)
    		return -1;
    	
    	return -2;
    }
    
    public void ajsutarHeap(int indice) {
    	int ipai = (int) (Math.ceil(indice/2) - 1);
    	if(ipai < 0) {
    		ipai = (int) (Math.ceil(indice/2));
    	}
    	
    	if(pessoas[ipai].getIdade() < pessoas[indice].getIdade()) {
    		Pessoa p = pessoas[ipai];
    		pessoas[ipai] = pessoas[indice];
    		pessoas[indice] = p;
    	}
    }

    public Pessoa peek() {
        if (getSize() == 0) {
            return null;
        }                
        
        return pessoas[0];
    }

    public void remove() {
        pessoas[0] = pessoas[getSize() - 1];
        pessoas[getSize() - 1] = null;
        size--;
        heapifyDown(0);
    }

    private void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;
        if (leftChild < getSize()) {
            childIndex = leftChild;
        }

        if (childIndex == -1) {
            return;
        }

        if (rightChild < getSize()) {
            if (pessoas[rightChild].getIdade() > pessoas[leftChild].getIdade()) {
                childIndex = rightChild;
            }
        }

        if (pessoas[index].getIdade() < pessoas[childIndex].getIdade()) {
            Pessoa tmp          = pessoas[index];
            pessoas[index]      = pessoas[childIndex];
            pessoas[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }
}


















































