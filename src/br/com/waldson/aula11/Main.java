package br.com.waldson.aula11;

public class Main {

    public static void main(String[] args) {
        FilaBanco fila = new FilaBanco();
        fila.insert("Fulano", 20);
        fila.insert("Fulano", 22);
        fila.insert("Fulano", 21);
        fila.insert("Sicrano", 23);
        
        //fila.insert("Beltrano", 45);
        //fila.insert("Vovó", 65);
        //fila.insert("Tio", 48);
        
        Pessoa p1 = new Pessoa("Primo", 18);
        fila.insert(p1);
        
        p1.setIdade(26);
        
        while(fila.isMaxHeap() != -1) {
        	int i = fila.isMaxHeap();
        	fila.ajsutarHeap(i);
        	System.out.println(i);
        	
        }
        
        //fila.ajsutarHeap(fila.isMaxHeap());                       
        
        System.out.println(fila.isMaxHeap());        
        
        
        while (fila.getSize() > 0) {
            Pessoa p = fila.peek();
            System.out.println("Atendendo " + p.getNome() + ";Idade: "+p.getIdade());
            fila.remove();
        }
    }
}
