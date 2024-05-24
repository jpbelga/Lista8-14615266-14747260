package ex4;

import java.util.*;

import ex3.MultiConjunto;

public class Adaptador<T> implements MultiConjunto<T>{
    private MultiConjunto<T> conjunto;

    public Adaptador(MultiConjunto<T> multiConjunto) {
        
    	Set<T> set = new HashSet<>();
    	
    	for (T element : multiConjunto)
        	set.add(element);	
    	
    	multiConjunto.removeAll();
    	this.conjunto = multiConjunto;
    	for(T element : set)
        this.conjunto.add(element);
    	
    }
    
    public Iterator<T> iterator() {
        return conjunto.iterator();
    }

	@Override
	public void add(T element) {
		boolean contains = false;
		for(T e : conjunto) {
			if(element.equals(e)) {
				contains = true;
				break;
			}
		}
		if(!contains)
			conjunto.add(element);
	}

	@Override
	public boolean equals(MultiConjunto<T> m) {
		return conjunto.equals(m);
	}

	@Override
	public void addAll(MultiConjunto<T> m) {
		
		conjunto.addAll(m);

		Set<T> set = new HashSet<>();
    	
    	for (T element : conjunto)
    		set.add(element);	
    	
    	conjunto.removeAll();
    	
    	for (T element : set)
    		conjunto.add(element);
		
	}

	@Override
	public void sort() {
		conjunto.sort();
	}
	
	@Override
	public String toString() {
		return conjunto.toString();
	}

	@Override
	public void removeAll() {
		conjunto.removeAll();
	}
}
