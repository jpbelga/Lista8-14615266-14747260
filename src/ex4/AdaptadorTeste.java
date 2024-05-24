package ex4;

import static org.junit.Assert.*;
import org.junit.Test;

import ex3.*;


public class AdaptadorTeste {

    @Test
    public void testAdd() {
        MultiConjunto<Integer> multiConjunto = new MultiConjuntoArray<>();
        multiConjunto.add(1);
        multiConjunto.add(2);
        multiConjunto.add(2);

        Adaptador<Integer> adaptador = new Adaptador<>(multiConjunto);
        adaptador.add(3);
        adaptador.add(2);

        assertEquals("1 2 3 ", adaptador.toString());
    }

    @Test
    public void testAddAll() {
        MultiConjunto<Integer> multiConjunto1 = new MultiConjuntoArray<>();
        multiConjunto1.add(1);
        multiConjunto1.add(2);

        MultiConjunto<Integer> multiConjunto2 = new MultiConjuntoArray<>();
        multiConjunto2.add(2);
        multiConjunto2.add(3);

        Adaptador<Integer> adaptador = new Adaptador<>(multiConjunto1);
        adaptador.addAll(multiConjunto2);

        assertEquals("1 2 3 ", adaptador.toString());
    }

    @Test
    public void testEquals() {
        MultiConjunto<Integer> multiConjunto1 = new MultiConjuntoArray<>();
        multiConjunto1.add(1);
        multiConjunto1.add(2);

        MultiConjunto<Integer> multiConjunto2 = new MultiConjuntoArray<>();
        multiConjunto2.add(2);
        multiConjunto2.add(1);

        Adaptador<Integer> adaptador1 = new Adaptador<>(multiConjunto1);
        Adaptador<Integer> adaptador2 = new Adaptador<>(multiConjunto2);

        assertTrue(adaptador1.equals(adaptador2));
    }

    @Test
    public void testSort() {
        MultiConjunto<Integer> multiConjunto = new MultiConjuntoArray<>();
        multiConjunto.add(3);
        multiConjunto.add(1);
        multiConjunto.add(2);

        Adaptador<Integer> adaptador = new Adaptador<>(multiConjunto);
        adaptador.sort();

        assertEquals("1 2 3 ", adaptador.toString());
    }
}

