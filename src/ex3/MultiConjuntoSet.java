package ex3;

import java.util.*;


public class MultiConjuntoSet<T> implements MultiConjunto<T>{

	//Como sets não permitem duplicatas, será implementado com uma estrutura de Tuplas.
	// Os pares srão compostos pelo o elemento do tipo T e a frequência que ele aparece no Set
	private Set<Pair<T>> set = new HashSet<Pair<T>>();
	
	@Override
	public void add(T element) {
		
		if(set.contains(element)) {
			for(Pair<T> e : set) {
				if(e.equals(element)) {
					e.increment();
					break;
				}
			}
		}
		else {
			set.add(new Pair<T>(element));
		}			
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
	public Iterator<T> iterator() {
		return new MultiConjuntoSetIterator<T>(set);
	}
	
	public void sort() {
	      List<Pair<T>> list = new ArrayList<>(set);
	      list.sort(Comparator.comparing(pair -> pair.element.toString()));
	      set = new LinkedHashSet<>(list);
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
		set.clear();
	}
}

 class Pair <T>{
	 protected T element;
	 protected int frequency = 0;
	 
	 Pair(T element){
		 this.element = element;
		 this.frequency = 1;
	 }
	 
	 protected void increment() {
		 this.frequency++;
	 }
	 
	 @Override
     public int hashCode() {
         return Objects.hash(element);
     }
	 
	 @Override
	 public boolean equals(Object o) {
		 return (this.element.getClass() == o.getClass() && element.toString() == o.toString());
	 }
 }
 
  class MultiConjuntoSetIterator<T> implements Iterator<T> {
     private Iterator<Pair<T>> pairIterator;
     private Pair<T> currentPair;
     private int count;

     MultiConjuntoSetIterator(Set<Pair<T>> set){
    	 super();
    	 pairIterator = set.iterator();
     }
     
     @Override
     public boolean hasNext() {
         return (currentPair != null && count < currentPair.frequency) || pairIterator.hasNext();
     }

     @Override
     public T next() {
         if (currentPair == null || count >= currentPair.frequency) {
             currentPair = pairIterator.next();
             count = 0;
         }
         count++;
         return currentPair.element;
     }
 }
