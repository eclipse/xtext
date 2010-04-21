/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;


/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill - Contribution to Bug 309764
 */
public abstract class AbstractScope implements IScope {
	
	public Iterable<IEObjectDescription> getContents() {
		return internalGetContents();
	}

	protected abstract Iterable<IEObjectDescription> internalGetContents();

	public Iterable<IEObjectDescription> getAllContents() {
		final Set<String> identifiers = Sets.newHashSet();
		return Iterables.concat(Iterables.transform(getContents(), new Function<IEObjectDescription, IEObjectDescription>() {
			public IEObjectDescription apply(IEObjectDescription param) {
				identifiers.add(param.getName());
				return param;
			}
		}), Iterables.filter(getOuterScope().getAllContents(), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription param) {
				return !identifiers.contains(param.getName());
			}
		}));
	}

	public IEObjectDescription getContentByEObject(EObject object) {
		Iterator<IEObjectDescription> iterator = getAllContentsByEObject(object).iterator();
		if(iterator.hasNext())
			return iterator.next();
		return null;
	}
	
	
	public Iterable<IEObjectDescription> getAllContentsByEObject(EObject object) {
		final Set<String> identifiers = Sets.newHashSet(); 
		final URI uri = EcoreUtil.getURI(object);
		return Iterables.concat(Iterables.filter(getContents(), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription param) {
				identifiers.add(param.getName());
				return param.getEObjectURI().equals(uri);
			}
		}), Iterables.filter(getOuterScope().getAllContentsByEObject(object), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription param) {
				return !identifiers.contains(param.getName());
			}
		}));
	}

	public IEObjectDescription getContentByName(String name) {
		if (name==null)
			throw new NullPointerException("name");
		Iterator<IEObjectDescription> contents = getContents().iterator();
		while (contents.hasNext()) {
			IEObjectDescription element = contents.next();
			if (name.equals(element.getName())) 
				return element;
		}
		return getOuterScope().getContentByName(name);
	}
}
