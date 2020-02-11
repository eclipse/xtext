/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.binary.asm.ClassFileBytesAccess;
import org.eclipse.xtext.common.types.access.impl.CachingClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.CachingDeclaredTypeFactory;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.DeclaredTypeFactory;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class CachingClasspathTypeProviderFactory extends ClasspathTypeProviderFactory {

	private CachingDeclaredTypeFactory reusedFactory;

	@Inject
	public CachingClasspathTypeProviderFactory(ClassLoader classLoader, TypeResourceServices services) {
		super(classLoader, services);
		reusedFactory = newClassReaderTypeFactory(classLoader);
	}

	private CachingDeclaredTypeFactory newClassReaderTypeFactory(ClassLoader classLoader) {
		DeclaredTypeFactory factoryDelegate = new DeclaredTypeFactory(new ClassFileBytesAccess(), classLoader);
		return new CachingDeclaredTypeFactory(factoryDelegate);
	}
	
	@Override
	protected ClasspathTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		ClassLoader classLoader = getClassLoader(resourceSet);
		CachingDeclaredTypeFactory actualFactoryToUse = reusedFactory;
		if (!isDefaultClassLoader(classLoader)) {
			actualFactoryToUse = newClassReaderTypeFactory(classLoader);
		}
		return new CachingClasspathTypeProvider(
				classLoader, 
				resourceSet, 
				getIndexedJvmTypeAccess(),
				actualFactoryToUse, services);
	}
	
}
