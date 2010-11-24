/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionBasedScope extends AbstractScope {

	private final IResourceDescription description;
	
	private boolean allowDuplicates = false;
	private Predicate<IEObjectDescription> filter;
	
	public ResourceDescriptionBasedScope(IScope parent, IResourceDescription description, Predicate<IEObjectDescription> filter) {
		super(parent);
		if (description == null)
			throw new NullPointerException("description");
		this.description = description;
		this.filter = filter;
		if (filter == null)
			this.filter = Predicates.alwaysTrue();
	}
	
	public ResourceDescriptionBasedScope(IResourceDescription description, Predicate<IEObjectDescription> filter) {
		this(IScope.NULLSCOPE, description, filter);
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

	public Predicate<IEObjectDescription> getFilter() {
		return filter;
	}
	
	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		return filter(description.getExportedObjects(selector), filter);
	}

}
