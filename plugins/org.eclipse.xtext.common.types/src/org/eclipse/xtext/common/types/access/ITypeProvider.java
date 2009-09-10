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

	Type findTypeByName(String name) throws TypeNotFoundException;
	
	ResourceSet getResourceSet();
	
	interface Factory {
		
		ITypeProvider createTypeProvider(ResourceSet resourceSet);
		
		ITypeProvider findTypeProvider(ResourceSet resourceSet);
		
		ITypeProvider createTypeProvider();
		
	}
	
}
