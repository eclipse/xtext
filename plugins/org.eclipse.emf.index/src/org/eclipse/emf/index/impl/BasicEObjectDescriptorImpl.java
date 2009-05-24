/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;
import static org.eclipse.emf.index.util.CollectionUtils.equalsNullSafe;

import java.io.Serializable;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class BasicEObjectDescriptorImpl implements EObjectDescriptor, Serializable {

	private static final long serialVersionUID = 5006367856591582998L;

	private transient URI cachedFragmentURI;

	protected String name;

	protected String displayName;

	protected String fragment;

	protected ResourceDescriptor resourceDescriptor;

	protected EClassDescriptor typeDescriptor;

	protected BasicEObjectDescriptorImpl(ResourceDescriptor resourceDescriptor, String fragment, String name,
			String displayName, EClassDescriptor typeDescriptor) {
		super();
		this.resourceDescriptor = resourceDescriptor;
		this.fragment = fragment;
		this.name = name;
		this.displayName = displayName;
		this.typeDescriptor = typeDescriptor;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public ResourceDescriptor getResourceDescriptor() {
		return resourceDescriptor;
	}

	public String getFragment() {
		return fragment;
	}

	public URI getFragmentURI() {
		if (cachedFragmentURI == null) {
			cachedFragmentURI = URI.createURI(resourceDescriptor.getURI()).appendFragment(getFragment());
		}
		return cachedFragmentURI;
	}

	public EClassDescriptor getEClassDescriptor() {
		return typeDescriptor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EObjectDescriptor) {
			EObjectDescriptor elementDescriptor = (EObjectDescriptor) obj;
			return obj.hashCode() == hashCode() && fragment.equals(elementDescriptor.getFragment())
					&& resourceDescriptor.equals(elementDescriptor.getResourceDescriptor());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return fragment.hashCode() + 97 * resourceDescriptor.hashCode();
	}
	
	public boolean copyDetails(EObjectDescriptor eObjectDesc) {
		boolean hasChanged = false;
		if(!equalsNullSafe(name, eObjectDesc.getName())) {
			name = eObjectDesc.getName();
			hasChanged = true;
		}
		if(!equalsNullSafe(displayName, eObjectDesc.getDisplayName())) { 
			displayName = eObjectDesc.getDisplayName();
			hasChanged = true;
		}
		if (!equalsNullSafe(getEClassDescriptor(), eObjectDesc.getEClassDescriptor())) {
			this.typeDescriptor = eObjectDesc.getEClassDescriptor();
			hasChanged = true;
		}
		return hasChanged;
	}
}
