/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class CachingClassReaderTypeProviderFactory extends ClassReaderTypeProviderFactory {

	private CachingClassReaderTypeFactory reusedFactory;

	@Inject
	public CachingClassReaderTypeProviderFactory(ClassLoader classLoader) {
		super(classLoader);
		ClassReaderTypeFactory factoryDelegate = new ClassReaderTypeFactory(new ClassFileReaderAccess(), classLoader);
		reusedFactory = new CachingClassReaderTypeFactory(factoryDelegate);
	}
	
	@Override
	protected ClassReaderTypeProvider createClassReaderBasedTypeProvider(ResourceSet resourceSet) {
		ClassLoader resourceSetClassLoader = getClassLoader(resourceSet);
		if (isDefaultClassLoader(resourceSetClassLoader)) {
			return new CachingClassReaderTypeProvider(
					getClassLoader(resourceSet), 
					resourceSet, 
					getIndexedJvmTypeAccess(),
					reusedFactory);
		} else {
			ClassReaderTypeFactory factoryDelegate = new ClassReaderTypeFactory(new ClassFileReaderAccess(), resourceSetClassLoader);
			return new CachingClassReaderTypeProvider(
					resourceSetClassLoader, 
					resourceSet, 
					getIndexedJvmTypeAccess(),
					new CachingClassReaderTypeFactory(factoryDelegate));
		}
	}
	
}
