package org.eclipse.emf.index.impl;

import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.impl.memory.InMemoryIndex;

public class IndexStoreFactory {
	
	public static final IIndexStore createIndexStore() {
		return new InMemoryIndex();
	}
}
