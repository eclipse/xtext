/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

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

import com.google.common.base.Function;

/**
 * A scope that provides access to {@link JvmConstructor constructors}.
 * Case insensitivity is not supported. It's always the most outer scope.
 * Lookup is delegated to a {@link AbstractTypeScope type scope}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractConstructorScope extends AbstractScope {

	private AbstractTypeScope typeScope;
	
	protected AbstractConstructorScope(AbstractTypeScope typeScope) {
		super(IScope.NULLSCOPE, false);
		this.typeScope = typeScope;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		if (object instanceof JvmConstructor) {
			JvmConstructor constructor = ((JvmConstructor) object);
			String qualifiedNameWithDots = constructor.getQualifiedName('.');
			String qualifiedNameWithDollar = constructor.getQualifiedName();
			if (qualifiedNameWithDollar.equals(qualifiedNameWithDots)) {
				final Set<IEObjectDescription> result = singleton(
						EObjectDescription.create(getQualifiedNameConverter().toQualifiedName(qualifiedNameWithDots), object));
				return result;
			} else {
				return Arrays.asList(
						EObjectDescription.create(getQualifiedNameConverter().toQualifiedName(qualifiedNameWithDots), object),
						EObjectDescription.create(getQualifiedNameConverter().toQualifiedName(qualifiedNameWithDollar), object));
			}
		}
		return emptySet();
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
		IEObjectDescription typeDescription = typeScope.getSingleElement(name);
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
			@Override
			public Iterator<JvmConstructor> iterator() {
				return castedType.getDeclaredConstructors().iterator();
			}
		};
		return transform(constructors, new Function<JvmConstructor,IEObjectDescription>(){
			@Override
			public IEObjectDescription apply(JvmConstructor from) {
				return EObjectDescription.create(name, from);
			}
		});
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		Iterable<IEObjectDescription> byName = getElements(name);
		Iterator<IEObjectDescription> iterator = byName.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}
	
	@Override
	public final Iterable<IEObjectDescription> getAllElements() {
		return internalGetAllElements();
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		throw new UnsupportedOperationException();
	}

	protected Iterable<IEObjectDescription> internalGetAllElements() {
		throw new UnsupportedOperationException();
	}
	
	public AbstractTypeScope getTypeScope() {
		return typeScope;
	}
	
	public IQualifiedNameConverter getQualifiedNameConverter() {
		return getTypeScope().getQualifiedNameConverter();
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
