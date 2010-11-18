/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.impl.ContainerBasedScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseContainerBasedScope extends ContainerBasedScope {

	public IgnoreCaseContainerBasedScope(IScope outer, EReference reference, IIgnoreCaseContainer container) {
		super(outer, reference, container);
	}
	
	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		if (selector instanceof ISelector.SelectByName) {
			QualifiedName name = ((ISelector.SelectByName) selector).getName();
			return getContainer().findAllEObjectsIgnoreCase(getReference().getEReferenceType(), name);
		} else {
			return super.getLocalElements(selector);
		}
	}

	@Override
	protected IIgnoreCaseContainer getContainer() {
		return (IIgnoreCaseContainer) super.getContainer();
	}
}
