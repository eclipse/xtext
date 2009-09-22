/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.ComponentType;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.TypeResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveMirror extends AbstractClassMirror {
	
	private final ITypeFactory<Class<?>> typeFactory;

	public PrimitiveMirror(ITypeFactory<Class<?>> typeProvider) {
		this.typeFactory = typeProvider;
	}

	@Override
	public EObject getEObject(Resource resource, String fragment) {
		if (fragment.endsWith("[]")) {
			ComponentType component = (ComponentType) getEObject(resource, fragment.substring(0, fragment.length() - 2));
			if (component == null)
				return null;
			if (component.getArrayType() == null) {
				component.setArrayType(TypesFactory.eINSTANCE.createArrayType());
			}
			return component.getArrayType();
		}
		for (EObject obj: resource.getContents()) {
			String otherFragment = getFragment(obj);
			if (fragment.equals(otherFragment))
				return obj;
		}
		return null;
	}
	
	@Override
	protected String getTypeName() {
		throw new UnsupportedOperationException();
	}

	public void initialize(TypeResource typeResource) {
		for(Class<?> primitiveClass: Primitives.ALL_PRIMITIVE_TYPES) {
			Type type = typeFactory.createType(primitiveClass);
			typeResource.getContents().add(type);
		}
	}
}
