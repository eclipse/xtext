/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.Type;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITypeProvider {

	/**
	 * Find a type by its fully qualified name, e.g. java.util.Map$Entry, int[], void or 
	 * java.lang.String[][][].
	 */
	Type findTypeByName(String name) throws TypeNotFoundException;
	
	/**
	 * Returns the resource set that will contain dynamically created resources.
	 * @return the resource set.
	 */
	ResourceSet getResourceSet();
	
	interface Factory {
		
		ITypeProvider createTypeProvider(ResourceSet resourceSet);
		
		ITypeProvider findTypeProvider(ResourceSet resourceSet);
		
		ITypeProvider createTypeProvider() throws UnsupportedOperationException;
		
	}
	
}
