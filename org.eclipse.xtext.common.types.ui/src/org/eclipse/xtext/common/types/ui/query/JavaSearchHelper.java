/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.query;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.ui.search.ISearchRequestor;
import org.eclipse.search.ui.text.Match;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaSearchHelper {

	private ISearchRequestor requestor;
	private IResourceDescriptions resourceDescriptions;
	
	private final Map<IProject, ResourceSet> projectToResourceSet;
	
	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private IExternalContentSupport externalContentSupport;

	@Inject
	private IDirtyStateManager dirtyStateManager;
	
	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	public JavaSearchHelper() {
		projectToResourceSet = Maps.newHashMap();
	}

	public void init(ISearchRequestor requestor, IResourceDescriptions resourceDescriptions) {
		this.requestor = requestor;
		this.resourceDescriptions = resourceDescriptions;
	}

	public void search(URI uri, IProgressMonitor monitor) {
		int numResources = Iterables.size(resourceDescriptions.getAllResourceDescriptions());
		SubMonitor subMonitor = SubMonitor.convert(monitor, numResources / 10);
		subMonitor.subTask("Find references in EMF resources");
		try {
			int i = 0;
			for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
				URI resourceURI = resourceDescription.getURI();
				IResourceServiceProvider resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(resourceURI);
				if(resourceServiceProvider != null) {
					IJavaSearchParticipation javaSearchParticipation = resourceServiceProvider
							.get(IJavaSearchParticipation.class);
					if(javaSearchParticipation == null || javaSearchParticipation.canContainJvmReferences(resourceURI))
						searchIn(uri, resourceDescription);
				}
				if (++i % 10 == 0) {
					if (subMonitor.isCanceled()) {
						return; // not throwing OperationCanceledException, as the client in JDT doesn't seem to handle it properly
					}
					subMonitor.worked(1);
				}
			}
			for(ResourceSet resourceSet: projectToResourceSet.values()) {
				resourceSet.getResources().clear();
				resourceSet.eAdapters().clear();
			}
		} finally {
			subMonitor.done();
		}
	}

	protected void searchIn(final URI uri, IResourceDescription resourceDescription) {
		Iterable<IReferenceDescription> matchingReferenceDescriptors = Iterables.filter(resourceDescription
				.getReferenceDescriptions(), new Predicate<IReferenceDescription>() {
			@Override
			public boolean apply(IReferenceDescription input) {
				return uri.equals(input.getTargetEObjectUri());
			}
		});
		for (IReferenceDescription matchingReferenceDescription : matchingReferenceDescriptors) {
			accept(matchingReferenceDescription);
		}
	}

	protected void accept(IReferenceDescription referenceDescription) {
		URI sourceResourceURI = referenceDescription.getSourceEObjectUri().trimFragment();
		Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(sourceResourceURI);
		Iterator<Pair<IStorage, IProject>> iterator = storages.iterator();
		while (iterator.hasNext()) {
			Pair<IStorage, IProject> pair = iterator.next();
			IStorage storage = pair.getFirst();
			IProject project = pair.getSecond();
			if (project != null && !project.isHidden()) {
				ResourceSet resourceSet = getResourceSet(project);
				EObject sourceEObject = resourceSet.getEObject(referenceDescription.getSourceEObjectUri(), true);
				if (sourceEObject != null) {
					ITextRegion region = getLocation(
							sourceEObject, referenceDescription.getEReference(), 
							referenceDescription.getIndexInList());
					acceptMatch(storage, region);
				} else {
					acceptMatch(referenceDescription, null);
				}
			}
		}
	}

	protected ITextRegion getLocation(EObject sourceEObject, EReference eReference, int indexInList) {
		List<INode> result = NodeModelUtils.findNodesForFeature(sourceEObject, eReference);
		if (result.isEmpty())
			return ITextRegion.EMPTY_REGION;
		if (result.size() == 1) {
			INode node = result.get(0);
			return node.getTextRegion();
		}
		if (indexInList == -1 || indexInList > result.size())
			return ITextRegion.EMPTY_REGION;
		INode node = result.get(indexInList);
		return node.getTextRegion();
	}
	
	protected ResourceSet getResourceSet(IProject project) {
		ResourceSet resourceSet = projectToResourceSet.get(project);
		if (resourceSet == null) {
			resourceSet = createResourceSet(project);
			projectToResourceSet.put(project, resourceSet);
		}
		return resourceSet;
	}

	protected void acceptMatch(Object element, ITextRegion region) {
		if (region != null)
			requestor.reportMatch(new Match(element, region.getOffset(), region.getLength()));
		else
			requestor.reportMatch(new Match(element, 0, 0));
	}
	
	protected ResourceSet createResourceSet(IProject project) {
		ResourceSet result = resourceSetProvider.get(project);
		externalContentSupport.configureResourceSet(result, dirtyStateManager);
		return result;
	}
}