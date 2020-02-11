/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class CachingReflectionTypeProviderFactory extends ReflectionTypeProviderFactory {

	private CachingReflectionTypeFactory reusedFactory;

	@Inject
	public CachingReflectionTypeProviderFactory(ClassLoader classLoader, TypeResourceServices services) {
		super(classLoader, services);
		ReflectionTypeFactory factoryDelegate = new ReflectionTypeFactory(new ReflectURIHelper());
		reusedFactory = new CachingReflectionTypeFactory(factoryDelegate);
	}
	
	@Override
	protected ReflectionTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return new CachingReflectionTypeProvider(getClassLoader(resourceSet), resourceSet, getIndexedJvmTypeAccess(), reusedFactory, services);
	}
	
}
