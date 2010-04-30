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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.resource.IFragmentProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveMirror extends AbstractClassMirror {
	
	private final ITypeFactory<Class<?>> typeFactory;

	public PrimitiveMirror(ITypeFactory<Class<?>> typeProvider) {
		this.typeFactory = typeProvider;
	}

	@Override
	public EObject getEObject(Resource resource, String fragment, IFragmentProvider.Fallback fallback) {
		if (fragment.endsWith("[]")) {
			return getArrayEObject(resource, fragment, fallback);
		}
		for (EObject obj: resource.getContents()) {
			String otherFragment = getFragment(obj, fallback);
			if (fragment.equals(otherFragment))
				return obj;
		}
		return fallback.getEObject(fragment);
	}
	
	@Override
	protected String getTypeName() {
		throw new UnsupportedOperationException();
	}

	public void initialize(TypeResource typeResource) {
		for(Class<?> primitiveClass: Primitives.ALL_PRIMITIVE_TYPES) {
			JvmType type = typeFactory.createType(primitiveClass);
			typeResource.getContents().add(type);
		}
	}
}
