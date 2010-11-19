/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Predicate;

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
		return filter(container.getElements(selector), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return EcoreUtil2.isAssignableFrom(reference.getEReferenceType(), input.getEObjectOrProxy().eClass());
			}
		});
	}
	
	protected IContainer getContainer() {
		return container;
	}
	
	protected EReference getReference() {
		return reference;
	}

}