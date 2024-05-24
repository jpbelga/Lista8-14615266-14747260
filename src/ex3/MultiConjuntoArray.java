package ex3;

import java.util.*;

public class MultiConjuntoArray<T> implements MultiConjunto<T>{

	List<T> array = new ArrayList<>();
	
	@Override
	public Iterator<T> iterator() {
		return array.iterator();
	}

	@Override
	public void add(T element) {
		array.add(element);
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
		array.sort(null);
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
		array.clear();
	}
}
