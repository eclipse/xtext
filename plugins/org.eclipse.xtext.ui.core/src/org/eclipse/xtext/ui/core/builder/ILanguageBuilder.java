/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * the callback methods are called during the build of a resource in the declared order.
 */
public interface ILanguageBuilder {
	
	/**
	 * Used to load a resource.
	 */
	Resource load(URI platformResourceUri, ResourceSet resourceSet, IProgressMonitor monitor);

	/**
	 * callback used to provide indexing information about the referencable EObjects
	 */
	void indexEObjectDescriptors(Resource resource, IEObjectDescriptorIndexer feeder, IProgressMonitor monitor);
	
	/**
	 * callback used to provide indexing information about cross references
	 */
	void indexEReferenceDescriptors(Resource resource, IEReferenceDescriptorIndexer feeder, IProgressMonitor monitor);

	/**
	 * used to validate the given resource.
	 * 
	 * @return a list of maps, where each map represents meta data about an issue as they go into the {@link org.eclipse.core.resources.IMarker}s. 
	 */
	List<Map<String, Object>> validate(Resource res, IProgressMonitor monitor);
	
	/**
	 * used to do things like code generation.
	 */
	void doBuild(Resource res, IProgressMonitor monitor);

	
	public interface IEReferenceDescriptorIndexer {
		void index(EObject from, EObject to, EReference reference);
	}
	
	public interface IEObjectDescriptorIndexer {
		void index(String name, EObject obj, Map<String, Serializable> userData);
	}
}
