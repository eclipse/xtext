/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.IdentifyableElement;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.access.ITypeProvider;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeScope extends AbstractScope {

	private final ITypeProvider typeProvider;

	public AbstractTypeScope(ITypeProvider typeProvider) {
		this.typeProvider = typeProvider;
	}

	@Override
	public Iterable<IEObjectDescription> internalGetContents() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IEObjectDescription getContentByName(String name) {
		if (Strings.isEmpty(name))
			return null;
		try {
			Type type = typeProvider.findTypeByName(name);
			if (type == null)
				return null;
			return EObjectDescription.create(name, type);
		} catch (TypeNotFoundException e) {
			return null;
		}
	}
	
	@Override
	public IEObjectDescription getContentByEObject(EObject object) {
		if (object instanceof IdentifyableElement) {
			return EObjectDescription.create(((IdentifyableElement) object).getCanonicalName(), object);
		}
		return null;
	}

	public IScope getOuterScope() {
		return IScope.NULLSCOPE;
	}
	
	public ITypeProvider getTypeProvider() {
		return typeProvider;
	}

}
