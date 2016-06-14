/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class RecordingTypeScope extends AbstractTypeScope {

	private final AbstractTypeScope typeScope;
	private final Set<QualifiedName> importedNames;

	public RecordingTypeScope(AbstractTypeScope typeScope, Set<QualifiedName> importedNames) {
		super(null, null, null);
		this.typeScope = typeScope;
		this.importedNames = importedNames;
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name, boolean binary) {
		importedNames.add(name.toLowerCase());
		return typeScope.getSingleElement(name, binary);
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		importedNames.add(name.toLowerCase());
		return typeScope.getSingleElement(name);
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		return typeScope.getElements(object);
	}
	
	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		return typeScope.getElements(name);
	}
	
	@Override
	public IScope getParent() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		return typeScope.getSingleElement(object);
	}
	
}
