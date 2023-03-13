/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class LocalResourceFilteringTypeScope extends AbstractTypeScope {

	private AbstractTypeScope delegate;
	private IResourceDescription filterDescription;

	protected LocalResourceFilteringTypeScope(AbstractTypeScope delegate, IResourceDescription filterDescription) {
		super(null, null, null);
		this.delegate = delegate;
		this.filterDescription = filterDescription;
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name, boolean binary) {
		if (isFiltered(name)) {
			return null;
		}
		return delegate.getSingleElement(name, binary);
	}
	
	private boolean isFiltered(QualifiedName name) {
		Iterable<IEObjectDescription> exportedObjects = filterDescription.getExportedObjects(TypesPackage.Literals.JVM_TYPE, name, false);
		return !Iterables.isEmpty(exportedObjects);
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		return filtered(delegate.getElements(name));
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		return filtered(delegate.getElements(object));
	}
	
	@Override
	public IScope getParent() {
		return delegate.getParent();
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		return filtered(delegate.getAllElements());
	}
	
	private Iterable<IEObjectDescription> filtered(Iterable<IEObjectDescription> unfiltered) {
		return Iterables.filter(unfiltered, input -> !isFiltered(input.getQualifiedName()));
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
