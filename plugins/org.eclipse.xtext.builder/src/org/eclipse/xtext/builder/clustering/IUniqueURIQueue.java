/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

import com.google.inject.ImplementedBy;

/**
 * A queue that holds a number of URIs. Subsequently added equal URIs will be ignored.
 * Implementors are free to provide prioritized or otherwise ordered results.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IUniqueURIQueue {

	/**
	 * An injectable factory allows to instantiate queues with initial content.
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	@ImplementedBy(UniqueURIQueue.Factory.class)
	interface Factory {
		
		/**
		 * @return a newly created queue that holds the unique entries 
		 * of the initial collection URIs.
		 */
		IUniqueURIQueue create(Collection<URI> initial);
	}
	
	/**
	 * Remove the first entry of the queue. 
	 * @return the first entry of the queue or <code>null<code> if it is empty.
	 */
	URI remove();

	/**
	 * Add an URI to the queue. If it has been added before, it will be ignored. 
	 */
	void add(URI uri);
	
	/**
	 * @return <code>true</code> if the queue is empty.
	 */
	boolean isEmpty();
	
	/**
	 * @return the total number of elements.
	 */
	int totalSize();
	
	/**
	 * @return the current number of available elements.
	 */
	int currentSize();

}
