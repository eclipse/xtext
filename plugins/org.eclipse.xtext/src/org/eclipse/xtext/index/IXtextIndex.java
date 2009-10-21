/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.index;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.store.UpdateableIndex;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IXtextIndex extends UpdateableIndex {
	
	public void clearNameSearchesFor(URI uri);
	
	/**
	 * finds instances of the given type with the given name in the given container.
	 * Registers the search.
	 */
	EObjectDescriptor executeFindEObjectByName(EObject context, String containerName, EClass type, String name);

	Iterable<URI> getPotentiallyInterestedResources(Set<String> names);
	
}
