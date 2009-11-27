/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaElementBasedContainer extends ResourceDescriptionsBasedContainer {

	private final IPackageFragmentRoot fragmentRoot;
	
	public JavaElementBasedContainer(IResourceDescriptions descriptions, IPackageFragmentRoot fragmentRoot) {
		super(descriptions);
		this.fragmentRoot = fragmentRoot;
	}
	
	@Override
	protected boolean contains(IResourceDescription input) {
		if (!(input instanceof IPersistentResourceDescription)) {
			throw new IllegalArgumentException("input cannot be filtered: " + input);
		}
		IStorage storage = ((IPersistentResourceDescription) input).getStorage();
		if (storage instanceof IJarEntryResource) {
			IPackageFragmentRoot other = ((IJarEntryResource) storage).getPackageFragmentRoot();
			return fragmentRoot.equals(other);
		}
		return fragmentRoot.getResource().getFullPath().isPrefixOf(storage.getFullPath());
	}

	public IPackageFragmentRoot getFragmentRoot() {
		return fragmentRoot;
	}

}
