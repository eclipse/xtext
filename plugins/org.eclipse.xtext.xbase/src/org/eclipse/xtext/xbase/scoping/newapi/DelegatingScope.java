/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DelegatingScope implements INewScope {
	
	private INewScope delegate = INewScope.NULL_SCOPE;
	
	public void setDelegate(INewScope delegate) {
		this.delegate = delegate;
	}

	public IEObjectDescription getSingleElement(ISelector selector) {
		return delegate.getSingleElement(selector);
	}

	public Iterable<? extends IEObjectDescription> getElements(ISelector selector) {
		return delegate.getElements(selector);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" -> "+(delegate!=null?delegate.toString():"<no delegate>");
	}

}
