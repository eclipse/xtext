/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaElementBasedContainer extends ResourceDescriptionsBasedContainer {

	private final IPackageFragmentRoot fragmentRoot;
	private IStorage2UriMapper mapper;
	
	public JavaElementBasedContainer(IResourceDescriptions descriptions, IPackageFragmentRoot fragmentRoot, IStorage2UriMapper mapper) {
		super(descriptions);
		this.fragmentRoot = fragmentRoot;
		this.mapper = mapper;
		
	}
	
	@Override
	protected boolean contains(IResourceDescription input) {
		Iterable<IStorage> storages = mapper.getStorages(input.getURI());
		for (IStorage storage : storages) {
			if (storage instanceof IJarEntryResource) {
				IPackageFragmentRoot other = ((IJarEntryResource) storage).getPackageFragmentRoot();
				if (fragmentRoot.equals(other))
					return true;
			}
			if (storage instanceof IFile) {
				if (!fragmentRoot.isExternal()) {
					if (fragmentRoot.getResource().getFullPath().isPrefixOf(storage.getFullPath()))
						return true;
				}
			}
		}
		return false;
	}

	public IPackageFragmentRoot getFragmentRoot() {
		return fragmentRoot;
	}

	@Override
	public String toString() {
		return fragmentRoot.toString();
	}
}
