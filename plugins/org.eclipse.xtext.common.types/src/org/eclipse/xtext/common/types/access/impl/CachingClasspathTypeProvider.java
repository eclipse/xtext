/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.access.binary.BinaryClassMirror;
import org.eclipse.xtext.common.types.access.binary.ClassFileReaderAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CachingClasspathTypeProvider extends ClasspathTypeProvider {

	private ITypeFactory<BinaryClass, JvmDeclaredType> reusedFactory;

	public CachingClasspathTypeProvider(ClassLoader classLoader, ResourceSet resourceSet,
			IndexedJvmTypeAccess indexedJvmTypeAccess, ITypeFactory<BinaryClass, JvmDeclaredType> reusedFactory) {
		super(classLoader, resourceSet, indexedJvmTypeAccess);
		this.reusedFactory = reusedFactory;
	}
	
	@Override
	protected DeclaredTypeFactory createDeclaredTypeFactory(ClassFileReaderAccess readerAccess,
			ClassLoader classLoader) {
		// we don't have the reusedFactory at hand at this point thus null is sufficient
		return null;
	}
	
	@Override
	public ITypeFactory<BinaryClass, JvmDeclaredType> getDeclaredTypeFactory() {
		return reusedFactory;
	}
	
	@Override
	public BinaryClassMirror createMirror(BinaryClass clazz) {
		return BinaryClassMirror.createClassMirror(clazz, reusedFactory);
	}

}
