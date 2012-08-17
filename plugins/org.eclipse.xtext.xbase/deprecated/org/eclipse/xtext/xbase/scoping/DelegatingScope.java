/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class DelegatingScope extends JvmFeatureScope {
	
	private IScope delegate = IScope.NULLSCOPE;

	public DelegatingScope(IScope parent) {
		this(parent, "DelegatingScope");
	}
	
	public DelegatingScope(IScope parent, String name) {
		super(parent, name, Collections.<IValidatedEObjectDescription>emptyList());
	}
	
	public void setDelegate(IScope delegate) {
		this.delegate = delegate;
	}
	
	protected IScope getDelegate() {
		return delegate;
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
