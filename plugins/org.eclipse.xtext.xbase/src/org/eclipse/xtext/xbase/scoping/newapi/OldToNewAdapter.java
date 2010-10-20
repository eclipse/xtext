/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.scoping.newapi.ISelector.SelectByEObject;
import org.eclipse.xtext.xbase.scoping.newapi.ISelector.SelectByName;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OldToNewAdapter implements INewScope {
	
	private IScope delegate;

	public IEObjectDescription getFirstElement(ISelector selector) {
		if (selector instanceof SelectByName) {
			return filter(delegate.getContentByName(((SelectByName) selector).getName()),selector);
		}
		if (selector instanceof SelectByEObject) {
			return filter(delegate.getContentByEObject(((SelectByEObject) selector).getEObject()),selector);
		}
		throw new UnsupportedOperationException("Single elements can eithe rbe queried by name or ba EObject.");
	}

	protected IEObjectDescription filter(IEObjectDescription contentByName, ISelector selector) {
		return selector.apply(contentByName) ? contentByName : null;
	}

	public Iterable<IEObjectDescription> getElements(ISelector selector) {
		if (selector instanceof SelectByEObject) {
			return filter(delegate.getAllContentsByEObject(((SelectByEObject) selector).getEObject()),selector);
		}
		return filter(delegate.getAllContents(),selector);
	}

	protected Iterable<IEObjectDescription> filter(Iterable<IEObjectDescription> allContentsByEObject, ISelector selector) {
		return Iterables.filter(allContentsByEObject, selector);
	}

}
