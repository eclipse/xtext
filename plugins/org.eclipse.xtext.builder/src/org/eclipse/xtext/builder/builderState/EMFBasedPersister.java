/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builder.internal.Activator;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EMFBasedPersister implements PersistableResourceDescriptionsImpl.Persister {

	private Resource.Factory factory;
	
	public Iterable<IResourceDescription> load() throws Exception {
		Resource resource = createResource();
		resource.load(null);
		return loadFromResource(resource);
	}

	public Iterable<IResourceDescription> loadFromResource(Resource resource) {
		return Iterables.filter(resource.getContents(), IResourceDescription.class);
	}
	
	public void save(Iterable<IResourceDescription> descriptions) throws Exception {
		Resource res = createResource();
		saveToResource(res, descriptions);
		res.save(null);
	}

	public Resource createResource() {
		URI fileURI = getBuilderStateURI();
		Resource res = getFactory().createResource(fileURI);
		return res;
	}

	public void saveToResource(Resource res, Iterable<IResourceDescription> descriptions) {
		Iterables.addAll(res.getContents(), Iterables.filter(descriptions, EObject.class));
	}

	public URI getBuilderStateURI() {
		IPath location = Activator.getDefault().getBuilderStateLocation();
		String osString = location.toOSString();
		URI fileURI = URI.createFileURI(osString);
		return fileURI;
	}

	public void setFactory(Resource.Factory factory) {
		this.factory = factory;
	}

	public Resource.Factory getFactory() {
		if (factory == null)
			factory = new XMIResourceFactoryImpl();
		return factory;
	}

}
