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
		reusedFactory = newClassReaderTypeFactory(classLoader);
	}

	private CachingClassReaderTypeFactory newClassReaderTypeFactory(ClassLoader classLoader) {
		ClassReaderTypeFactory factoryDelegate = new ClassReaderTypeFactory(new ClassFileReaderAccess(), classLoader);
		return new CachingClassReaderTypeFactory(factoryDelegate);
	}
	
	@Override
	protected ClassReaderTypeProvider createClassReaderBasedTypeProvider(ResourceSet resourceSet) {
		ClassLoader classLoader = getClassLoader(resourceSet);
		CachingClassReaderTypeFactory actualFactoryToUse = reusedFactory;
		if (!isDefaultClassLoader(classLoader)) {
			actualFactoryToUse = newClassReaderTypeFactory(classLoader);
		}
		return new CachingClassReaderTypeProvider(
				classLoader, 
				resourceSet, 
				getIndexedJvmTypeAccess(),
				actualFactoryToUse);
	}
	
}
