package xtend.tutorial.util;

public class ArrayAccess<T> {
	private T[] internal;
	
	public ArrayAccess(T[] internal) {
		super();
		this.internal = internal;
	}
	
	public T get(int index) {
		return internal[index];
	}
	
	public T set(int index, T value) {
		return internal[index] = value;
	}
	
	public <X> ArrayAccess<X> access(X[] val) {
		return new ArrayAccess<X>(val);
	}
	
}
