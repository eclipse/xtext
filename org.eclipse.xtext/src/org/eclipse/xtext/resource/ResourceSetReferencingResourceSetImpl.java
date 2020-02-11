/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceSetReferencingResourceSetImpl extends XtextResourceSet implements ResourceSetReferencingResourceSet {

	private final List<ResourceSet> referencedResourceSets = new ArrayList<ResourceSet>();

	@Override
	public List<ResourceSet> getReferencedResourceSets() {
		return referencedResourceSets;
	}

	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		Resource resource = getResource(uri.trimFragment(), loadOnDemand);
		return resource.getEObject(uri.fragment());
	}

	@Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		Resource resource = findResourceInResourceSet(uri, this);
		Iterator<ResourceSet> iterator = referencedResourceSets.iterator();
		while (resource == null && iterator.hasNext()) {
			resource = findResourceInResourceSet(uri, iterator.next());
		}
		if (resource!=null)
			return load(resource,loadOnDemand);
		return super.getResource(uri, loadOnDemand);
	}

	private Resource findResourceInResourceSet(URI uri, ResourceSet set) {
		EList<Resource> resources = set.getResources();
		for (Resource resource : resources) {
			if (resource.getURI().equals(uri))
				return resource;
		}
		return null;
	}

	private Resource load(Resource resource, boolean loadOnDemand) {
		if (!loadOnDemand)
			try {
				resource.load(resource.getResourceSet().getLoadOptions());
			}
			catch (IOException e) {
				throw new WrappedException(e);
			}
		return resource;
	}

}
