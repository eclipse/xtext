package org.xpect.state;

public class ManagedImpl<T> implements Managed<T> {

	private final T value;

	public ManagedImpl(T value) {
		super();
		this.value = value;
	}

	public T get() {
		return value;
	}

	public void invalidate() {
	}

	@Override
	public String toString() {
		return "Managed[" + value + "]";
	}

}
