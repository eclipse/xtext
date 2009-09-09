/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProviderFactory implements ITypeProvider.Factory {

	private final ClassLoader classLoader;

	@Inject
	public ClasspathTypeProviderFactory(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	public ClasspathTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		ClasspathTypeProvider result = new ClasspathTypeProvider(classLoader, resourceSet);
		return result;
	}

	public ClasspathTypeProvider createTypeProvider() {
		return createTypeProvider(new ResourceSetImpl());
	}
	
}
