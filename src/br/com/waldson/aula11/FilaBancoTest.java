package br.com.waldson.aula11;

import org.junit.Test;

import static org.junit.Assert.*;

public class FilaBancoTest {

    @Test
    public void mustBeRemovedInOrder() {
        //Arrange
        FilaBanco fila = new FilaBanco();
        Pessoa p1 = new Pessoa("Fulano", 20);
        Pessoa p2 = new Pessoa("Beltrano", 30);
        Pessoa p3 = new Pessoa("Sicrano", 10);


        //Act
        fila.insert(p1);
        fila.insert(p2);
        fila.insert(p3);

        //Assert
        assertSame(p2, fila.peek());
        fila.remove();
        assertSame(p1, fila.peek());
        fila.remove();
        assertSame(p3, fila.peek());
        fila.remove();
        assertNull(fila.peek());
    }

    @Test
    public void itMustUpdateWhenAgeChanges() {
        //Arrange
        FilaBanco  fila = new FilaBanco();
        Pessoa p1 = new Pessoa("Fulano", 10);
        Pessoa p2 = new Pessoa("Beltrano", 20);
        fila.insert(p1);
        fila.insert(p2);

        //Act
        p1.setIdade(21);

        //Assert
        assertSame(p1, fila.peek());
    }

    @Test
    public void itMustInsertElements() {
        //Arrange
        FilaBanco fila = new FilaBanco();

        //Act
        int size = fila.getSize();
        fila.insert("Fulano", 10);

        //Assert
        assertEquals(size + 1, fila.getSize());
    }

    @Test
    public void itMustRemoveElements() {
        //Arrange
        FilaBanco fila = new FilaBanco();

        //Act
        fila.insert("Fulano", 10);
        int size = fila.getSize();
        fila.remove();

        //Assert
        assertEquals(size - 1, fila.getSize());
    }

    @Test
    public void itMustReturnElement() {
        //Arrange
        FilaBanco fila = new FilaBanco();
        Pessoa fulano = new Pessoa("Fulano", 20);

        //Act
        fila.insert(fulano);

        //Assert
        assertSame(fulano, fila.peek());
    }



}