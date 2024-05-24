package ex3;

public interface MultiConjunto <T> extends Iterable<T>{
	void add(T element);
	boolean equals(MultiConjunto<T> m);
	void addAll(MultiConjunto<T> m);
	public void sort();
	public void removeAll();
}
