package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.common.util.TreeIterator;

public interface TreeIterable<E> extends Iterable<E> {

	TreeIterator<E> treeIterator();
	
}
