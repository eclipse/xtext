/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lsp;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.access.binary.BinaryClassMirror;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;

import com.google.inject.Inject;

/**
 * @since 2.35
 */
public class NonSealedClasspathTypeProviderFactory extends ClasspathTypeProviderFactory {
	
	@Inject
	public NonSealedClasspathTypeProviderFactory(ClassLoader classLoader, TypeResourceServices services) {
		super(classLoader, services);
	}
	
	@Override
	protected ClasspathTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return new NonSealedClasspathTypeProvider(getClassLoader(resourceSet), resourceSet, getIndexedJvmTypeAccess(), services);
	}

	protected static class NonSealedClasspathTypeProvider extends ClasspathTypeProvider {

		protected NonSealedClasspathTypeProvider(ClassLoader classLoader, ResourceSet resourceSet,
				IndexedJvmTypeAccess indexedJvmTypeAccess, TypeResourceServices services) {
			super(classLoader, resourceSet, indexedJvmTypeAccess, services);
		}

		@Override
		public BinaryClassMirror createMirror(BinaryClass clazz) {
			return BinaryClassMirror.createClassMirror(clazz, getDeclaredTypeFactory(), false);
		}

	}
}
