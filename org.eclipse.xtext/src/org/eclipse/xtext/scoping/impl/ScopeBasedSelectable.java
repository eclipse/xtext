/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ScopeBasedSelectable implements ISelectable {

	private final IScope scope;

	public ScopeBasedSelectable(IScope scope) {
		this.scope = scope;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		return scope.getAllElements();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return scope.getElements(name);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return scope.getAllElements();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return scope.getElements(object);
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public String toString() {
		return scope.toString();
	}

}
