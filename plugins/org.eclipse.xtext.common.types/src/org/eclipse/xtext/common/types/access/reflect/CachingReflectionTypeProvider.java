/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.impl.ClassMirror;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class CachingReflectionTypeProvider extends ReflectionTypeProvider {

	private ReflectionTypeFactory reusedFactory;

	public CachingReflectionTypeProvider(ClassLoader classLoader, ResourceSet resourceSet,
			IndexedJvmTypeAccess indexedJvmTypeAccess, ReflectionTypeFactory reusedFactory) {
		super(classLoader, resourceSet, indexedJvmTypeAccess);
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
