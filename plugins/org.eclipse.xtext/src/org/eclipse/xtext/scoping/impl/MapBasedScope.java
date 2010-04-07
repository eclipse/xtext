/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.collect.Iterables;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class MapBasedScope implements IScope{

	private IScope parent;
	private Map<String,IEObjectDescription> descriptions;
	
	public MapBasedScope(IScope parent, Map<String, IEObjectDescription> descriptions) {
		super();
		this.parent = parent;
		this.descriptions = descriptions;
	}

	public Iterable<IEObjectDescription> getContents() {
		return descriptions.values();
	}

	public Iterable<IEObjectDescription> getAllContents() {
		return Iterables.concat(getContents(), parent.getAllContents());
	}

	public IEObjectDescription getContentByName(String name) {
		IEObjectDescription ieObjectDescription = descriptions.get(name);
		return ieObjectDescription!=null?ieObjectDescription:parent.getContentByName(name);
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

	public IScope getOuterScope() {
		return parent;
	}

	@Override
	public String toString() {
		return "contains "+descriptions.size()+" elements";
	}
}
