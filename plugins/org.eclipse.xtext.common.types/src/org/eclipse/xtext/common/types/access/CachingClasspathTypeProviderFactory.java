/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.impl.CachingClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.CachingDeclaredTypeFactory;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.DeclaredTypeFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class CachingClasspathTypeProviderFactory extends ClasspathTypeProviderFactory {

	private CachingDeclaredTypeFactory reusedFactory;

	@Inject
	public CachingClasspathTypeProviderFactory(ClassLoader classLoader) {
		super(classLoader);
		DeclaredTypeFactory factoryDelegate = new DeclaredTypeFactory(new ClassURIHelper());
		reusedFactory = new CachingDeclaredTypeFactory(factoryDelegate);
	}
	
	@Override
	protected ClasspathTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return new CachingClasspathTypeProvider(getClassLoader(resourceSet), resourceSet, getIndexedJvmTypeAccess(), reusedFactory);
	}
	
}
