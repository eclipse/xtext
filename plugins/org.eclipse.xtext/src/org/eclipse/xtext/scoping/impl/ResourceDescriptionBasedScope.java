/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionBasedScope extends AbstractScope {

	private final IScope outer;
	private final EClass type;
	private final IResourceDescription description;
	
	private boolean allowDuplicates = false;
	
	public ResourceDescriptionBasedScope(IScope outer, IResourceDescription description, EClass type) {
		if (outer == null)
			throw new NullPointerException("outer");
		if (description == null)
			throw new NullPointerException("description");
		if (type == null)
			throw new NullPointerException("type");
		this.outer = outer;
		this.description = description;
		this.type = type;
	}
	
	public ResourceDescriptionBasedScope(IResourceDescription description, EClass type) {
		this(IScope.NULLSCOPE, description, type);
	}
	
	@Override
	protected Iterable<IEObjectDescription> internalGetContents() {
		if (allowDuplicates)
			return description.getExportedObjects(type);
		return Scopes.filterDuplicates(description.getExportedObjects(type));
	}

	public IScope getOuterScope() {
		return outer;
	}
	
	public void setAllowDuplicates(boolean allow) {
		this.allowDuplicates = allow;
	}
	
	public boolean isAllowDuplicates() {
		return allowDuplicates;
	}
	
	protected IResourceDescription getDescription() {
		return description;
	}
	
	protected EClass getElementType() {
		return type;
	}
	
	@Override
	public IEObjectDescription getContentByName(String name) {
		// TODO: case allowDuplicates, see also impl in subclass
		Iterable<IEObjectDescription> objects = description.getExportedObjects(type, name);
		Iterator<IEObjectDescription> iter = objects.iterator();
		if (iter.hasNext()) {
			IEObjectDescription result = iter.next();
			if (!iter.hasNext())
				return result;
		}
		return getOuterScope().getContentByName(name);
	}

}
