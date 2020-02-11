/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractResourceDescription implements IResourceDescription {
	
	protected EObjectDescriptionLookUp lookup;
	
	@Override
	public boolean isEmpty() {
		return getLookUp().isEmpty();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		return getLookUp().getExportedObjects();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return getLookUp().getExportedObjectsByType(type);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return getLookUp().getExportedObjectsByObject(object);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return getLookUp().getExportedObjects(type, name, ignoreCase);
	}
	
	protected abstract List<IEObjectDescription> computeExportedObjects();
	
	protected EObjectDescriptionLookUp getLookUp() {
		if (lookup == null)
			lookup = new EObjectDescriptionLookUp(computeExportedObjects());
		return lookup;
	}

	protected URI getNormalizedURI(Resource resource) {
		URI uri = resource.getURI();
		URIConverter uriConverter = resource.getResourceSet()!=null?resource.getResourceSet().getURIConverter():null;
		if (uri != null && uriConverter != null) {
			if (!uri.isPlatform()) {
				return uriConverter.normalize(uri);
			}
			// This is a fix for resources which have been loaded using a platform:/plugin URI
			// This happens when one resource has absolute references using a platform:/plugin uri and the corresponding
			// ResourceDescriptionManager resolves references in the first phase, i.e. during EObjectDecription computation.
			// EMF's GenModelResourceDescriptionStrategy does so as it needs to call GenModel.reconcile() eagerly.
			if (uri.isPlatformPlugin()) {
				URI resourceURI = uri.replacePrefix(URI.createURI("platform:/plugin/"), URI.createURI("platform:/resource/"));
				if (uriConverter.normalize(uri).equals(uriConverter.normalize(resourceURI)))
					return resourceURI;
			}
		}
		return uri;
	}
	
}
