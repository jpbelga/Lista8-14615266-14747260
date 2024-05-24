package ex3;

import static org.junit.Assert.*;
import org.junit.Test;


public class Testes {

    @Test
    public void testAddSet() {
        MultiConjuntoSet<Integer> set = new MultiConjuntoSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        assertEquals("1 1 2 ", set.toString());
    }

    @Test
    public void testAddAllSet() {
        MultiConjuntoSet<Integer> set1 = new MultiConjuntoSet<>();
        set1.add(1);
        set1.add(2);

        MultiConjuntoSet<Integer> set2 = new MultiConjuntoSet<>();
        set2.add(2);
        set2.add(3);

        set1.addAll(set2);

        assertEquals("1 2 2 3 ", set1.toString());
    }

    @Test
    public void testEqualsSet() {
        MultiConjuntoSet<Integer> set1 = new MultiConjuntoSet<>();
        set1.add(1);
        set1.add(2);

        MultiConjuntoSet<Integer> set2 = new MultiConjuntoSet<>();
        set2.add(2);
        set2.add(1);

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testSortSet() {
        MultiConjuntoSet<Integer> set = new MultiConjuntoSet<>();
        set.add(3);
        set.add(1);
        set.add(2);

        set.sort();

        assertEquals("1 2 3 ", set.toString());
    }
    

    @Test
    public void testAddArray() {
        MultiConjuntoArray<Integer> array = new MultiConjuntoArray<>();
        array.add(1);
        array.add(2);
        array.add(1);
        assertEquals("1 2 1 ", array.toString());
    }

    @Test
    public void testAddAllArray() {
        MultiConjuntoArray<Integer> array1 = new MultiConjuntoArray<>();
        array1.add(1);
        array1.add(2);

        MultiConjuntoArray<Integer> array2 = new MultiConjuntoArray<>();
        array2.add(2);
        array2.add(3);

        array1.addAll(array2);

        assertEquals("1 2 2 3 ", array1.toString());
    }

    @Test
    public void testEqualsArray() {
        MultiConjuntoArray<Integer> array1 = new MultiConjuntoArray<>();
        array1.add(1);
        array1.add(2);

        MultiConjuntoArray<Integer> array2 = new MultiConjuntoArray<>();
        array2.add(2);
        array2.add(1);

        assertTrue(array1.equals(array2));
    }

    @Test
    public void testSortArray() {
        MultiConjuntoArray<Integer> array = new MultiConjuntoArray<>();
        array.add(3);
        array.add(1);
        array.add(2);

        array.sort();

        assertEquals("1 2 3 ", array.toString());
    }
    
    @Test
    public void testAddLinkedList() {
        MultiConjuntoLinkedList<Integer> linkedList = new MultiConjuntoLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1);
        assertEquals("1 2 1 ", linkedList.toString());
    }

    @Test
    public void testAddAllLinkedList() {
        MultiConjuntoLinkedList<Integer> linkedList1 = new MultiConjuntoLinkedList<>();
        linkedList1.add(1);
        linkedList1.add(2);

        MultiConjuntoLinkedList<Integer> linkedList2 = new MultiConjuntoLinkedList<>();
        linkedList2.add(2);
        linkedList2.add(3);

        linkedList1.addAll(linkedList2);

        assertEquals("1 2 2 3 ", linkedList1.toString());
    }

    @Test
    public void testEqualsLinkedList() {
        MultiConjuntoLinkedList<Integer> linkedList1 = new MultiConjuntoLinkedList<>();
        linkedList1.add(1);
        linkedList1.add(2);

        MultiConjuntoLinkedList<Integer> linkedList2 = new MultiConjuntoLinkedList<>();
        linkedList2.add(2);
        linkedList2.add(1);

        assertTrue(linkedList1.equals(linkedList2));
    }

    @Test
    public void testSortLinkedList() {
        MultiConjuntoLinkedList<Integer> linkedList = new MultiConjuntoLinkedList<>();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(2);

        linkedList.sort();

        assertEquals("1 2 3 ", linkedList.toString());
    }
    
    @Test
    public void testAddStack() {
        MultiConjuntoStack<Integer> stack = new MultiConjuntoStack<>();
        stack.add(1);
        stack.add(2);
        stack.add(1);
        assertEquals("1 2 1 ", stack.toString());
    }

    @Test
    public void testAddAllStack() {
        MultiConjuntoStack<Integer> stack1 = new MultiConjuntoStack<>();
        stack1.add(1);
        stack1.add(2);

        MultiConjuntoStack<Integer> stack2 = new MultiConjuntoStack<>();
        stack2.add(2);
        stack2.add(3);

        stack1.addAll(stack2);

        assertEquals("1 2 2 3 ", stack1.toString());
    }

    @Test
    public void testEqualsStack() {
        MultiConjuntoStack<Integer> stack1 = new MultiConjuntoStack<>();
        stack1.add(1);
        stack1.add(2);

        MultiConjuntoStack<Integer> stack2 = new MultiConjuntoStack<>();
        stack2.add(2);
        stack2.add(1);

        assertTrue(stack1.equals(stack2));
    }

    @Test
    public void testSortStack() {
        MultiConjuntoStack<Integer> stack = new MultiConjuntoStack<>();
        stack.add(3);
        stack.add(1);
        stack.add(2);

        stack.sort();

        assertEquals("1 2 3 ", stack.toString());
    }
}
