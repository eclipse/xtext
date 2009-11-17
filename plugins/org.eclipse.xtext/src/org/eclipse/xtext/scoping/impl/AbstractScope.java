/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.HashSet;
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


/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class AbstractScope implements IScope {
	
	public Iterable<IEObjectDescription> getContents() {
		return internalGetContents();
	}

	protected abstract Iterable<IEObjectDescription> internalGetContents();

	public Iterable<IEObjectDescription> getAllContents() {
		final Set<String> identifiers = new HashSet<String>();
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
		Iterator<IEObjectDescription> contents = getContents().iterator();
		URI uri = EcoreUtil.getURI(object);
		Set<String> names = new HashSet<String>();
		while (contents.hasNext()) {
			IEObjectDescription element = contents.next();
			names.add(element.getName());
			URI elementsUri = EcoreUtil.getURI(element.getEObjectOrProxy());
			if (uri.equals(elementsUri))
				return element;
		}
		IEObjectDescription contentByEObject = getOuterScope().getContentByEObject(object);
		if (contentByEObject!=null && names.contains(contentByEObject.getName())) {
			// element is shadowed by a local element with the same name.
			return null;
		}
		return contentByEObject;
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
