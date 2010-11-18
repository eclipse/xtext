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
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompositeScope implements IScope {
	
	private List<IScope> scopes;
	
	public CompositeScope(IScope ...scopes) {
		this.scopes = Arrays.asList(scopes);
	}
	public CompositeScope(List<IScope> scopes) {
		this.scopes = scopes;
	}

	public IEObjectDescription getSingleElement(ISelector selector) {
		for (IScope scope : scopes) {
			IEObjectDescription element = scope.getSingleElement(selector);
			if (element!=null)
				return element;
		}
		return null;
	}

	public Iterable<IEObjectDescription> getElements(final ISelector selector) {
		return Iterables.concat(Iterables.transform(scopes, new Function<IScope, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IScope from) {
				return from.getElements(selector);
			}
		}));
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+"["+scopes+"]";
	}
}
