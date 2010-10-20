/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractConstructorScope extends AbstractScope {

	private AbstractTypeScope typeScope;
	
	protected AbstractConstructorScope(AbstractTypeScope typeScope) {
		this.typeScope = typeScope;
	}
	
	@Override
	public IEObjectDescription getContentByName(QualifiedName name) {
		IEObjectDescription typeDescription = typeScope.getContentByName(name);
		if (typeDescription == null)
			return null;
		JvmType type = (JvmType) typeDescription.getEObjectOrProxy();
		if (type.eIsProxy() || !(type instanceof JvmGenericType)) {
			return null;
		}
		JvmGenericType castedType = (JvmGenericType) type;
		if (castedType.isInterface()) {
			return null;
		}
		Iterator<JvmConstructor> constructors = castedType.getDeclaredConstructors().iterator();
		if (constructors.hasNext()) {
			JvmConstructor constructor = constructors.next();
			return EObjectDescription.create(name, constructor);
		}
		return null;
	}
	
	@Override
	public IEObjectDescription getContentByEObject(EObject object) {
		if (object instanceof JvmConstructor) {
			return EObjectDescription.create(getQualifiedNameConverter().toQualifiedName(((JvmConstructor) object).getCanonicalName()), object);
		}
		return null;
	}
	
	@Override
	protected Iterable<IEObjectDescription> internalGetContents() {
		throw new UnsupportedOperationException();
	}

	public AbstractTypeScope getTypeScope() {
		return typeScope;
	}
	
	public IQualifiedNameConverter getQualifiedNameConverter() {
		return getTypeScope().getQualifiedNameConverter();
	}
	
	public IScope getOuterScope() {
		return IScope.NULLSCOPE;
	}
}
