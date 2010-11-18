/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.ISelector.SelectByEObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContainerBasedScope extends AbstractScope {
	
	private final EReference reference;
	private final IContainer container;

	public ContainerBasedScope(IScope outer, EReference reference, IContainer container) {
		super(outer);
		this.reference = reference;
		this.container = container;
	}
	
	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		if (selector instanceof ISelector.SelectByName) {
			QualifiedName name = ((ISelector.SelectByName) selector).getName();
			return container.findAllEObjects(reference.getEReferenceType(), name);
		} else if (selector instanceof ISelector.SelectByEObject) {
			SelectByEObject eObjectSelector = (ISelector.SelectByEObject) selector;
			URI uri = eObjectSelector.getUri();
			IResourceDescription description = container.getResourceDescription(uri.trimFragment());
			if (description != null) {
				return description.getExportedObjectsForEObject(eObjectSelector.getEObject());
			}
			return Collections.emptySet();
		}
		return container.findAllEObjects(reference.getEReferenceType());
	}
	
	protected IContainer getContainer() {
		return container;
	}
	
	protected EReference getReference() {
		return reference;
	}

}