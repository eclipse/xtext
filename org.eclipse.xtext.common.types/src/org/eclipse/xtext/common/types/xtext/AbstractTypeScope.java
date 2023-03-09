/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import static java.util.Collections.*;

import java.util.Arrays;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * A scope that provides access to {@link JvmType types}.
 * Case insensitivity is not supported. It's always the most outer scope.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public abstract class AbstractTypeScope extends AbstractScope {

	private final IJvmTypeProvider typeProvider;

	private final IQualifiedNameConverter qualifiedNameConverter;

	private final Predicate<IEObjectDescription> filter;

	protected AbstractTypeScope(IJvmTypeProvider typeProvider, IQualifiedNameConverter qualifiedNameConverter,
			Predicate<IEObjectDescription> filter) {
		super(IScope.NULLSCOPE, false);
		this.typeProvider = typeProvider;
		this.qualifiedNameConverter = qualifiedNameConverter;
		this.filter = filter;
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		return getSingleElement(name, false);
	}
	
	public IEObjectDescription getSingleElement(QualifiedName name, boolean binary) {
		try {
			JvmType type = typeProvider.findTypeByName(qualifiedNameConverter.toString(name), binary);
			if (type == null)
				return null;
			IEObjectDescription result = EObjectDescription.create(name, type);
			if (filter != null && !filter.apply(result))
				return null;
			return result;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		IEObjectDescription result = getSingleElement(name);
		if (result != null)
			return singleton(result);
		return emptySet();
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		if (object instanceof JvmIdentifiableElement) {
			JvmIdentifiableElement identifiable = ((JvmIdentifiableElement) object);
			String qualifiedNameWithDots = identifiable.getQualifiedName('.');
			String qualifiedNameWithDollar = identifiable.getQualifiedName();
			if (qualifiedNameWithDollar.equals(qualifiedNameWithDots)) {
				final Set<IEObjectDescription> result = singleton(
						EObjectDescription.create(qualifiedNameConverter.toQualifiedName(qualifiedNameWithDots), object));
				return filterResult(result);
			} else {
				return filterResult(Arrays.asList(
						EObjectDescription.create(qualifiedNameConverter.toQualifiedName(qualifiedNameWithDots), object),
						EObjectDescription.create(qualifiedNameConverter.toQualifiedName(qualifiedNameWithDollar), object)));
			}
		}
		return emptySet();
	}
	
	
	protected Iterable<IEObjectDescription> filterResult(Iterable<IEObjectDescription> unfiltered) {
		if (filter == null)
			return unfiltered;
		return Iterables.filter(unfiltered, filter);
	}
	
	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		return filterResult(internalGetAllElements());
	}
	
	protected Iterable<IEObjectDescription> internalGetAllElements() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		throw new UnsupportedOperationException();
	}

	public IJvmTypeProvider getTypeProvider() {
		return typeProvider;
	}

	public IQualifiedNameConverter getQualifiedNameConverter() {
		return qualifiedNameConverter;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
