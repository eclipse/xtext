/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Predicate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionBasedScope extends AbstractScope {

	private final EClass type;
	private final IResourceDescription description;
	
	private boolean allowDuplicates = false;
	
	public ResourceDescriptionBasedScope(IScope parent, IResourceDescription description, EClass type) {
		super(parent);
		if (description == null)
			throw new NullPointerException("description");
		if (type == null)
			throw new NullPointerException("type");
		this.description = description;
		this.type = type;
	}
	
	public ResourceDescriptionBasedScope(IResourceDescription description, EClass type) {
		this(IScope.NULLSCOPE, description, type);
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
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		return filter(description.getExportedObjects(selector), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return EcoreUtil2.isAssignableFrom(type, input.getEClass());
			}
		});
	}

}
