package ex3;

import java.util.*;

public class MultiConjuntoStack<T> implements MultiConjunto<T> {

    Stack<T> stack = new Stack<>();
        
    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }

    @Override
    public void add(T element) {
        stack.push(element);
    }

    @Override
    public boolean equals(MultiConjunto<T> m) {
        m.sort();
        this.sort();
        
        Iterator<T> thisIterator = this.iterator();
        Iterator<T> otherIterator = m.iterator();
        
        while(thisIterator.hasNext() && otherIterator.hasNext()) {
            T thisElement = thisIterator.next();
            T otherElement = otherIterator.next();
            
            if(!thisElement.equals(otherElement))
                return false;
        }
        
        return !thisIterator.hasNext() && !otherIterator.hasNext();
    }

    @Override
    public void addAll(MultiConjunto<T> m) {
        for (T element : m) {
            add(element);
        }   
    }

    @Override
    public void sort() {
        List<T> list = new ArrayList<>(stack);
        Collections.sort(list, Comparator.comparing(Object::toString));
        stack = new Stack<>();
        for (T element : list) {
            stack.push(element);
        }
    }
    
    @Override
    public String toString() {
        String str = "";
        for (T element : this)
            str += element.toString() + " ";
        return str;
    }

	@Override
	public void removeAll() {
		stack.clear();
	}
}
