/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.core.builder.ILanguageBuilder.IEObjectDescriptorIndexer;
import org.eclipse.xtext.ui.core.builder.ILanguageBuilder.IEReferenceDescriptorIndexer;

public class ResourceToBuild {
	private ILanguageBuilder builder;
	private URI uri;
	private boolean removeOnly;
	private Resource emfResource;
	private ResourceSet resourceSet;
	private IResource iResource;

	public ResourceToBuild(ResourceSet resourceSet, URI uri, IResource resource, ILanguageBuilder builder,
			boolean removeOnly) {
		super();
		this.resourceSet = resourceSet;
		this.uri = uri;
		this.builder = builder;
		this.removeOnly = removeOnly;
		this.iResource = resource;
	}

	public URI getUri() {
		return uri;
	}

	public ILanguageBuilder getBuilder() {
		return builder;
	}

	public boolean isRemoveOnly() {
		return removeOnly;
	}

	public Resource loadEmfResource(IProgressMonitor monitor) {
		if (emfResource == null) {
			emfResource = builder.load(getUri(), resourceSet, monitor);
		}
		return emfResource;
	}

	public boolean unloadAndRemove(IProgressMonitor monitor) {
		EList<Resource> list = resourceSet.getResources();
		for (Resource emfResource : list) {
			if (emfResource.getURI().equals(getUri())) {
				emfResource.unload();
				resourceSet.getResources().remove(emfResource);
				return true;
			}
		}
		return false;
	}

	public void indexEObjects(IEObjectDescriptorIndexer indexer, IProgressMonitor monitor) {
		builder.indexEObjectDescriptors(loadEmfResource(monitor), indexer, monitor);
	}

	public void indexEReferences(IEReferenceDescriptorIndexer indexer, IProgressMonitor monitor) {
		builder.indexEReferenceDescriptors(loadEmfResource(monitor), indexer, monitor);
	}

	public List<Map<String, Object>> validate(IProgressMonitor monitor) {
		return builder.validate(loadEmfResource(monitor), monitor);
	}

	public void doBuild(IProgressMonitor monitor) {
		builder.doBuild(loadEmfResource(monitor), monitor);
	}

	public IResource getIResource() {
		return iResource;
	}

}