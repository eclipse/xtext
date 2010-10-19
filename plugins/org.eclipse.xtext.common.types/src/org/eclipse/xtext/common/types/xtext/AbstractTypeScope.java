/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public abstract class AbstractTypeScope extends AbstractScope {

	private final IJvmTypeProvider typeProvider;

	private final IQualifiedNameProvider qualifiedNameProvider;
	
	public AbstractTypeScope(IJvmTypeProvider typeProvider, IQualifiedNameProvider qualifiedNameProvider) {
		this.typeProvider = typeProvider;
		this.qualifiedNameProvider = qualifiedNameProvider;
	}

	@Override
	public Iterable<IEObjectDescription> internalGetContents() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IEObjectDescription getContentByName(QualifiedName qualifiedName) {
		try {
			JvmType type = typeProvider.findTypeByName(qualifiedNameProvider.toString(qualifiedName));
			if (type == null)
				return null;
			return EObjectDescription.create(qualifiedName, type);
		} catch (TypeNotFoundException e) {
			return null;
		}
	}
	
	@Override
	public IEObjectDescription getContentByEObject(EObject object) {
		if (object instanceof JvmIdentifyableElement) {
			return EObjectDescription.create(qualifiedNameProvider.toValue(((JvmIdentifyableElement) object).getCanonicalName()), object);
		}
		return null;
	}

	public IScope getOuterScope() {
		return IScope.NULLSCOPE;
	}
	
	public IJvmTypeProvider getTypeProvider() {
		return typeProvider;
	}
	
	public IQualifiedNameProvider getQualifiedNameProvider() {
		return qualifiedNameProvider;
	}

}
