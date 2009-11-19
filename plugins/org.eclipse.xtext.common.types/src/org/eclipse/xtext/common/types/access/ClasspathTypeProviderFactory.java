/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProviderFactory extends AbstractTypeProviderFactory {

	private final ClassLoader classLoader;

	@Inject
	public ClasspathTypeProviderFactory(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	public ClasspathTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		ClasspathTypeProvider result = createClasspathTypeProvider(resourceSet);
		return result;
	}

	protected ClasspathTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return new ClasspathTypeProvider(classLoader, resourceSet);
	}
	
	public ClassLoader getClassLoader() {
		return classLoader;
	}
	
	@Override
	public ClasspathTypeProvider createTypeProvider() {
		return (ClasspathTypeProvider) super.createTypeProvider();
	}
	
	@Override
	public ClasspathTypeProvider findTypeProvider(ResourceSet resourceSet) {
		return (ClasspathTypeProvider) super.findTypeProvider(resourceSet);
	}
	
}
