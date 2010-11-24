/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import static java.util.Collections.*;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.impl.AbstractScope;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public abstract class AbstractTypeScope extends AbstractScope {

	private final IJvmTypeProvider typeProvider;

	private final IQualifiedNameConverter qualifiedNameConverter;

	private Predicate<IEObjectDescription> filter = Predicates.<IEObjectDescription> alwaysTrue();

	protected AbstractTypeScope(IJvmTypeProvider typeProvider, IQualifiedNameConverter qualifiedNameConverter,
			Predicate<IEObjectDescription> filter) {
		this.typeProvider = typeProvider;
		this.qualifiedNameConverter = qualifiedNameConverter;
		if (filter != null)
			this.filter = filter;
	}

	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		if (selector instanceof ISelector.SelectByName) {
			QualifiedName qualifiedName = ((ISelector.SelectByName) selector).getName();
			try {
				JvmType type = typeProvider.findTypeByName(qualifiedNameConverter.toString(qualifiedName));
				if (type == null)
					return emptySet();
				final Set<IEObjectDescription> result = singleton(EObjectDescription.create(qualifiedName, type));
				return selector.applySelector(result);
			} catch (TypeNotFoundException e) {
				return emptySet();
			}
		} else if (selector instanceof ISelector.SelectByEObject) {
			EObject object = ((ISelector.SelectByEObject) selector).getEObject();
			if (object instanceof JvmIdentifyableElement) {
				final Set<IEObjectDescription> result = singleton(EObjectDescription.create(
						qualifiedNameConverter.toQualifiedName(((JvmIdentifyableElement) object).getCanonicalName()),
						object));
				return selector.applySelector(result);
			}
			return emptySet();
		}
		return Iterables.filter(internalGetAllLocalElements(selector), filter);
	}

	protected Iterable<IEObjectDescription> internalGetAllLocalElements(ISelector selector) {
		throw new UnsupportedOperationException();
	}

	public IJvmTypeProvider getTypeProvider() {
		return typeProvider;
	}

	public IQualifiedNameConverter getQualifiedNameConverter() {
		return qualifiedNameConverter;
	}

}
