/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class CachingReflectionTypeProviderFactory extends ReflectionTypeProviderFactory {

	private CachingReflectionTypeFactory reusedFactory;

	@Inject
	public CachingReflectionTypeProviderFactory(ClassLoader classLoader) {
		super(classLoader);
		ReflectionTypeFactory factoryDelegate = new ReflectionTypeFactory(new ReflectURIHelper());
		reusedFactory = new CachingReflectionTypeFactory(factoryDelegate);
	}
	
	@Override
	protected ReflectionTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return new CachingReflectionTypeProvider(getClassLoader(resourceSet), resourceSet, getIndexedJvmTypeAccess(), reusedFactory);
	}
	
}
