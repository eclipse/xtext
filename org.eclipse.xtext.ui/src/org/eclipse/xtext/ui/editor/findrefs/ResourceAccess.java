/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static com.google.common.collect.Maps.*;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.4
 */
public class ResourceAccess implements IReferenceFinder.ILocalResourceAccess {

	private Map<IProject,ResourceSet> resourceSets = newHashMap();

	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	@Inject
	private IStorage2UriMapper storage2UriMapper;

	private ResourceSet fallBackResourceSet;
	
	public void registerResourceSet(ResourceSet resourceSet) {
		if (resourceSet instanceof XtextResourceSet) {
			Object context = ((XtextResourceSet) resourceSet).getClasspathURIContext();
			if (context instanceof IJavaProject) {
				IProject project = ((IJavaProject) context).getProject();
				resourceSets.put(project, resourceSet);
			}
		}
		this.fallBackResourceSet = resourceSet;
	}
	
	@Override
	public <R> R readOnly(URI targetURI, IUnitOfWork<R, ResourceSet> work) {
		URI resourceURI = targetURI.trimFragment();
		Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(resourceURI);
		Iterator<Pair<IStorage, IProject>> iterator = storages.iterator();
		ResourceSet resourceSet = fallBackResourceSet; 
		while(iterator.hasNext()) {
			Pair<IStorage, IProject> pair = iterator.next();
			IProject project = pair.getSecond();
			if (project != null) {
				resourceSet = getResourceSet(project);
				break;
			}
		}
		if(resourceSet != null) {
			resourceSet.getResource(resourceURI, true);
			try {
				return work.exec(resourceSet);
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		}
		return null;
	}
	
	protected ResourceSet getResourceSet(IProject p) {
		// if the initially registered resource set wasn'T configured with a java project, we aways use the same resourceSet (old behavior)
		if (resourceSets.isEmpty() && fallBackResourceSet != null) {
			return fallBackResourceSet;
		}
		if (resourceSets.containsKey(p)) {
			return resourceSets.get(p);
		}
		ResourceSet resourceSet = resourceSetProvider.get(p);
		if (resourceSet == null)
			return null;
		resourceSets.put(p, resourceSet);
		return resourceSet;
	}

}
