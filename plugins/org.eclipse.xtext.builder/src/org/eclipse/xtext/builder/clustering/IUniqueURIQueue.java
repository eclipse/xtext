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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IUniqueURIQueue {

	@ImplementedBy(UniqueURIQueue.Factory.class)
	interface Factory {
		IUniqueURIQueue create(Collection<URI> initial);
	}
	
	boolean isEmpty();

	Collection<URI> getAllURIs();

	URI get();

	void add(URI uri);

}
