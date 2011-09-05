/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public abstract class AbstractReferenceUpdater implements IReferenceUpdater {
	
	@Inject
	private ReferenceDescriptionSorter sorter;

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	public void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Iterable<IReferenceDescription> referenceDescriptions, IRefactoringUpdateAcceptor updateAcceptor,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		progress.beginTask("Sort references by project", 1);
		Multimap<IProject, IReferenceDescription> project2references = sorter.sortByProject(referenceDescriptions);
		SubMonitor allProjectsProgress = progress.newChild(98).setWorkRemaining(project2references.keySet().size());
		for (IProject project : project2references.keySet()) {
			if (allProjectsProgress.isCanceled())
				break;
			Multimap<URI, IReferenceDescription> resource2references = sorter.sortByResource(project2references
					.get(project));
			SubMonitor projectProgress = allProjectsProgress.newChild(1).setWorkRemaining(100);
			ResourceSet resourceSet = resourceSetProvider.get(project);
			StatusWrapper status = updateAcceptor.getRefactoringStatus();
			if (loadTargetResource(resourceSet, elementRenameArguments, status, projectProgress.newChild(1)) != null) {
				Multimap<URI, IReferenceDescription> referringResource = resource2references;
				List<URI> unloadableResources = loadReferringResources(resourceSet, referringResource.keySet(), status, projectProgress.newChild(5));
				for(URI unloadableResouce: unloadableResources)
					referringResource.removeAll(unloadableResouce);
				List<IReferenceDescription> unresolvableReferences = resolveReferenceProxies(resourceSet, referringResource.values(), status, projectProgress.newChild(10));
				for(IReferenceDescription unresolvableReference: unresolvableReferences) {
					URI unresolvableReferringResource = unresolvableReference.getSourceEObjectUri().trimFragment();
					resource2references.remove(unresolvableReferringResource, unresolvableReference);
				}
				elementRenameArguments.applyDeclarationChange(resourceSet);
				createReferenceUpdates(elementRenameArguments, referringResource, resourceSet, updateAcceptor,
						projectProgress.newChild(94));
			}
		}
	}

	protected List<IReferenceDescription> resolveReferenceProxies(ResourceSet resourceSet,
			Collection<IReferenceDescription> values, StatusWrapper status, SubMonitor newChild) {
		List<IReferenceDescription> unresolvedDescriptions = null;
		for (IReferenceDescription referenceDescription : values) {
			EObject sourceEObject = resourceSet.getEObject(referenceDescription.getSourceEObjectUri(), false);
			if (sourceEObject != null) {
				EObject resolvedReference = resolveReference(sourceEObject, referenceDescription);
				if (!resolvedReference.eIsProxy())
					continue;
				else
					handleCannotResolveExistingReference(sourceEObject, referenceDescription, status);
			} else {
				handleCannotLoadReferringElement(referenceDescription, status);
			}
			if (unresolvedDescriptions == null)
				unresolvedDescriptions = newArrayList();
			unresolvedDescriptions.add(referenceDescription);
		}
		return (unresolvedDescriptions == null) ? Collections.<IReferenceDescription> emptyList()
				: unresolvedDescriptions;
	}

	protected void handleCannotLoadReferringElement(IReferenceDescription referenceDescription, StatusWrapper status) {
		status.add(ERROR, "Cannot find referring element {0}.\nMaybe the index is be corrupt. Consider a rebuild.", referenceDescription.getSourceEObjectUri());
	}

	protected void handleCannotResolveExistingReference(EObject sourceEObject,
			IReferenceDescription referenceDescription, StatusWrapper status) {
		status.add(ERROR, "Cannot resolve existing reference.\nMaybe the index is be corrupt. Consider a rebuild.", referenceDescription.getSourceEObjectUri());
	}

	protected abstract void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor);

	protected Resource loadTargetResource(ResourceSet resourceSet, ElementRenameArguments elementRenameArguments,
			StatusWrapper status, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Loading target resource", 1);
		Resource targetResource = resourceSet.getResource(elementRenameArguments.getTargetElementURI().trimFragment(),
				true);
		if (targetResource == null) {
			status.add(ERROR, "Cannot load target resource {0}.", elementRenameArguments.getTargetElementURI());
		}
		progress.worked(1);
		return targetResource;
	}

	protected List<URI> loadReferringResources(ResourceSet resourceSet, Iterable<URI> referringResourceURIs,
			StatusWrapper status, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Loading referencing resources", size(referringResourceURIs));
		List<URI> unloadableResources = null;
		for (URI referringResourceURI : referringResourceURIs) {
			Resource referringResource = resourceSet.getResource(referringResourceURI, true);
			if (referringResource == null) {
				status.add(ERROR, "Could not load referring resource ", referringResourceURI);
				if (unloadableResources == null)
					unloadableResources = newArrayList();
				unloadableResources.add(referringResourceURI);
			}
			progress.worked(1);
		}
		return unloadableResources == null ? Collections.<URI> emptyList() : unloadableResources;
	}

	protected EObject resolveReference(EObject referringElement, IReferenceDescription referenceDescription) {
		Object resolvedValue = referringElement.eGet(referenceDescription.getEReference());
		if (referenceDescription.getEReference().isMany()) {
			List<?> list = (List<?>) resolvedValue;
			resolvedValue = list.get(referenceDescription.getIndexInList());
		}
		return (EObject) resolvedValue;
	}
	
}
