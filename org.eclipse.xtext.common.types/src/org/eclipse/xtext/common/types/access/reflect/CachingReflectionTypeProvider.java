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
import org.eclipse.xtext.common.types.access.impl.ClassMirror;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class CachingReflectionTypeProvider extends ReflectionTypeProvider {

	private ReflectionTypeFactory reusedFactory;

	@Deprecated
	public CachingReflectionTypeProvider(ClassLoader classLoader, ResourceSet resourceSet,
			IndexedJvmTypeAccess indexedJvmTypeAccess, ReflectionTypeFactory reusedFactory) {
		this(classLoader, resourceSet, indexedJvmTypeAccess, reusedFactory, null);
	}
	
	public CachingReflectionTypeProvider(ClassLoader classLoader, ResourceSet resourceSet,
			IndexedJvmTypeAccess indexedJvmTypeAccess, ReflectionTypeFactory reusedFactory, TypeResourceServices services) {
		super(classLoader, resourceSet, indexedJvmTypeAccess, services);
		this.reusedFactory = reusedFactory;
	}
	
	@Override
	protected ReflectionTypeFactory createDeclaredTypeFactory() {
		// we don't have the reusedFactory at hand at this point thus null is sufficient
		return null;
	}
	
	@Override
	public ReflectionTypeFactory getDeclaredTypeFactory() {
		return reusedFactory;
	}
	
	@Override
	public ClassMirror createMirror(Class<?> clazz) {
		return ClassMirror.createClassMirror(clazz, reusedFactory);
	}

}
