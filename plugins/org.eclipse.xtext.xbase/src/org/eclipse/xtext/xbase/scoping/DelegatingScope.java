/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DelegatingScope implements IScope {
	
	private IScope delegate = IScope.NULLSCOPE;
	
	public void setDelegate(IScope delegate) {
		this.delegate = delegate;
	}

	public IEObjectDescription getSingleElement(QualifiedName name) {
		return delegate.getSingleElement(name);
	}

	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		return delegate.getElements(name);
	}

	public IEObjectDescription getSingleElement(EObject object) {
		return delegate.getSingleElement(object);
	}

	public Iterable<IEObjectDescription> getElements(EObject object) {
		return delegate.getElements(object);
	}

	public Iterable<IEObjectDescription> getAllElements() {
		return delegate.getAllElements();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+" -> "+delegate;
	}
}
