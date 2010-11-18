/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.impl.AbstractScope;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractConstructorScope extends AbstractScope {

	private AbstractTypeScope typeScope;
	
	protected AbstractConstructorScope(AbstractTypeScope typeScope) {
		this.typeScope = typeScope;
	}
	
	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		if (selector instanceof ISelector.SelectByName) {
			final QualifiedName qualifiedName = ((ISelector.SelectByName) selector).getName();
			IEObjectDescription typeDescription = typeScope.getSingleElement(selector);
			if (typeDescription == null)
				return emptySet();
			JvmType type = (JvmType) typeDescription.getEObjectOrProxy();
			if (type.eIsProxy() || !(type instanceof JvmGenericType)) {
				return emptySet();
			}
			final JvmGenericType castedType = (JvmGenericType) type;
			if (castedType.isInterface()) {
				return emptySet();
			}
			Iterable<JvmConstructor> constructors = new Iterable<JvmConstructor>() {
				public Iterator<JvmConstructor> iterator() {
					return castedType.getDeclaredConstructors().iterator();
				}
			};
			return transform(constructors, new Function<JvmConstructor,IEObjectDescription>(){
				public IEObjectDescription apply(JvmConstructor from) {
					return EObjectDescription.create(qualifiedName, from);
				}});
		} else if (selector instanceof ISelector.SelectByEObject) {
			EObject object = ((ISelector.SelectByEObject) selector).getEObject();
				if (object instanceof JvmConstructor) {
				final Set<IEObjectDescription> result = singleton(EObjectDescription.create(getQualifiedNameConverter().toQualifiedName(((JvmIdentifyableElement) object).getCanonicalName()), object));
				return selector.applySelector(result);
			}
			return emptySet();
		}
		return internalGetAllLocalElements(selector);
	}

	protected Iterable<IEObjectDescription> internalGetAllLocalElements(ISelector selector) {
		throw new UnsupportedOperationException();
	}
	
	public AbstractTypeScope getTypeScope() {
		return typeScope;
	}
	
	public IQualifiedNameConverter getQualifiedNameConverter() {
		return getTypeScope().getQualifiedNameConverter();
	}
	
}
