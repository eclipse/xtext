/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompositeScope implements INewScope {
	
	private List<INewScope> scopes;
	
	public CompositeScope(INewScope ...scopes) {
		this.scopes = Arrays.asList(scopes);
	}
	public CompositeScope(List<INewScope> scopes) {
		this.scopes = scopes;
	}

	public IEObjectDescription getSingleElement(ISelector selector) {
		for (INewScope scope : scopes) {
			IEObjectDescription element = scope.getSingleElement(selector);
			if (element!=null)
				return element;
		}
		return null;
	}

	public Iterable<? extends IEObjectDescription> getElements(final ISelector selector) {
		return Iterables.concat(Iterables.transform(scopes, new Function<INewScope, Iterable<? extends IEObjectDescription>>() {
			public Iterable<? extends IEObjectDescription> apply(INewScope from) {
				return from.getElements(selector);
			}
		}));
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+"["+scopes+"]";
	}
}
