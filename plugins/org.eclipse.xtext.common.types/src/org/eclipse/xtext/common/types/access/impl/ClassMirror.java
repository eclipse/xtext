/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.access.TypeResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassMirror extends AbstractClassMirror {

	private final Class<?> clazz;
	
	private final ITypeFactory<Class<?>> typeFactory;

	public static ClassMirror createClassMirror(Class<?> clazz, ITypeFactory<Class<?>> typeProvider) {
		if (clazz.isPrimitive() || clazz.isArray() || clazz.isMemberClass())
			throw new IllegalArgumentException("Cannot create class mirror for " + clazz.getName());
		return new ClassMirror(clazz, typeProvider);
	}
	
	protected ClassMirror(Class<?> clazz, ITypeFactory<Class<?>> typeFactory) {
		this.clazz = clazz;
		this.typeFactory = typeFactory;
	}

	public Class<?> getMirroredClass() {
		return clazz;
	}
	
	@Override
	protected String getTypeName() {
		return clazz.getName();
	}

	public void initialize(TypeResource typeResource) {
		typeResource.getContents().add(typeFactory.createType(clazz));
	}

}
