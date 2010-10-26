/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * An adapter scope adapting the old scope API to the new one.
 */
public class NewToOldAdapter implements IScope {
	
	private INewScope newScope;
	private ISelector selector;
	
	public NewToOldAdapter(INewScope newScope, ISelector selector) {
		super();
		this.newScope = newScope;
		this.selector = selector;
	}

	public IScope getOuterScope() {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getContents() {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	public Iterable<IEObjectDescription> getAllContents() {
		return (Iterable<IEObjectDescription>) newScope.getElements(ISelector.SELECT_ALL);
	}

	public IEObjectDescription getContentByName(QualifiedName name) {
		return newScope.getSingleElement(Selectors.byName(name, selector));
	}

	public IEObjectDescription getContentByEObject(EObject object) {
		return newScope.getSingleElement(Selectors.byEObject(object, selector));
	}

	@SuppressWarnings("unchecked")
	public Iterable<IEObjectDescription> getAllContentsByEObject(EObject object) {
		return (Iterable<IEObjectDescription>) newScope.getElements(Selectors.byEObject(object, selector));
	}

}
