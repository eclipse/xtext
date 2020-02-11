/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.access.binary.BinaryClassMirror;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class ClassMirror extends BinaryClassMirror {

	private final Class<?> clazz;
	
	private final ITypeFactory<Class<?>, JvmDeclaredType> typeFactory;

	public static ClassMirror createClassMirror(Class<?> clazz, ITypeFactory<Class<?>, JvmDeclaredType> typeProvider) {
		if (clazz.isPrimitive() || clazz.isArray() || clazz.isMemberClass())
			throw new IllegalArgumentException("Cannot create class mirror for " + clazz.getName());
		return new ClassMirror(clazz, typeProvider);
	}
	
	protected ClassMirror(Class<?> clazz, ITypeFactory<Class<?>, JvmDeclaredType> typeFactory) {
		super(null, null);
		this.clazz = clazz;
		this.typeFactory = typeFactory;
	}

	@Override
	public Class<?> getMirroredClass() {
		return clazz;
	}
	
	@Override
	protected String getTypeName() {
		return clazz.getName();
	}
	
	@Override
	public BinaryClass getMirroredBinaryClass() {
		return new BinaryClass(getTypeName(), clazz.getClassLoader());
	}

	@Override
	public void initialize(TypeResource typeResource) {
		typeResource.getContents().add(typeFactory.createType(clazz));
	}

}
