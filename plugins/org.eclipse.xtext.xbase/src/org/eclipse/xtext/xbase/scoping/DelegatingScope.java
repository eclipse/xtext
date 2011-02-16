/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DelegatingScope extends AbstractScope {
	
	private IScope delegate = IScope.NULLSCOPE;

	protected DelegatingScope(IScope parent) {
		super(parent, false);
	}
	
	public void setDelegate(IScope delegate) {
		this.delegate = delegate;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByEObject(EObject object, URI uri) {
		return delegate.getElements(object);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		return delegate.getElements(name);
	}
	
	@Override
	protected IEObjectDescription getSingleLocalElementByName(QualifiedName name) {
		return delegate.getSingleElement(name);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return delegate.getAllElements();
	}

	@Override
	public String toString() {
		return super.toString()+" -> "+delegate;
	}

}
