package org.eclipse.xpect.state;

public interface Managed<T> {

	T get();

	void invalidate();
	
	// Object getID();
}
