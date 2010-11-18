/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DelegatingScope implements IScope {
	
	private IScope delegate = IScope.NULLSCOPE;
	
	public void setDelegate(IScope delegate) {
		this.delegate = delegate;
	}

	public IEObjectDescription getSingleElement(ISelector selector) {
		return delegate.getSingleElement(selector);
	}

	public Iterable<IEObjectDescription> getElements(ISelector selector) {
		return delegate.getElements(selector);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+" -> "+delegate;
	}
}
