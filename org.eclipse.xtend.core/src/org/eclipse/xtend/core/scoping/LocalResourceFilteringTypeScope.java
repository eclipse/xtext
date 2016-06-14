/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LocalResourceFilteringTypeScope extends AbstractTypeScope {

	private AbstractTypeScope delegate;
	private IResourceDescription filterDescription;

	protected LocalResourceFilteringTypeScope(AbstractTypeScope delegate, IResourceDescription filterDescription) {
		super(null, null, null);
		this.delegate = delegate;
		this.filterDescription = filterDescription;
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		if (isFiltered(name)) {
			return null;
		}
		return delegate.getSingleElement(name);
	}

	private boolean isFiltered(QualifiedName name) {
		Iterable<IEObjectDescription> exportedObjects = filterDescription.getExportedObjects(TypesPackage.Literals.JVM_TYPE, name, false);
		return !Iterables.isEmpty(exportedObjects);
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name, boolean binary) {
		if (isFiltered(name)) {
			return null;
		}
		return delegate.getSingleElement(name, binary);
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		return Iterables.filter(delegate.getElements(name), new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				return !isFiltered(input.getQualifiedName());
			}
		});
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		return Iterables.filter(delegate.getElements(object), new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				return !isFiltered(input.getQualifiedName());
			}
		});
	}

	@Override
	public IScope getParent() {
		return delegate.getParent();
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		return Iterables.filter(delegate.getAllElements(), new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				return !isFiltered(input.getQualifiedName());
			}
		});
	}

	@Override
	public IJvmTypeProvider getTypeProvider() {
		return delegate.getTypeProvider();
	}

	@Override
	public IQualifiedNameConverter getQualifiedNameConverter() {
		return delegate.getQualifiedNameConverter();
	}

	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		return delegate.getSingleElement(object);
	}

}
