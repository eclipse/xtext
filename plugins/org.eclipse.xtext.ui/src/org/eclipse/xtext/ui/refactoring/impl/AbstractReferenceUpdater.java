/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collection;
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
			loadTargetResource(resourceSet, elementRenameArguments, projectProgress.newChild(1));
			loadReferringResources(resourceSet, resource2references.keySet(), projectProgress.newChild(5));
			resolveReferenceProxies(resourceSet, resource2references.values(), projectProgress.newChild(10));
			elementRenameArguments.applyDeclarationChange(resourceSet);
			createReferenceUpdates(elementRenameArguments, resource2references, resourceSet, updateAcceptor,
					projectProgress.newChild(94));
		}
	}

	protected void resolveReferenceProxies(ResourceSet resourceSet, Collection<IReferenceDescription> values,
			SubMonitor newChild) {
		for (IReferenceDescription referenceDescription : values) {
			EObject sourceEObject = resourceSet.getEObject(referenceDescription.getSourceEObjectUri(), false);
			if (sourceEObject == null)
				throw new RefactoringStatusException("Cannot find referring element "
						+ notNull(referenceDescription.getSourceEObjectUri())
						+ ". Maybe the index is be corrupt. Consider a rebuild.", true);
			resolveReference(sourceEObject, referenceDescription);
		}
	}

	protected abstract void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor);

	/**
	 * @since 2.0
	 */
	protected Resource loadTargetResource(ResourceSet resourceSet, ElementRenameArguments elementRenameArguments,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Loading target resource", 1);
		Resource targetResource = resourceSet.getResource(elementRenameArguments.getTargetElementURI().trimFragment(),
				true);
		if (targetResource == null) {
			throw new RefactoringStatusException("Cannot load target resource", true);
		}
		progress.worked(1);
		return targetResource;
	}

	protected void loadReferringResources(ResourceSet resourceSet, Iterable<URI> referringResourceURIs,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Loading referencing resources", size(referringResourceURIs));
		for (URI referringResourceURI : referringResourceURIs) {
			Resource referringResource = resourceSet.getResource(referringResourceURI, true);
			if (referringResource == null)
				throw new RefactoringStatusException("Resource " + notNull(referringResourceURI) + " cannot be loaded",
						true);
			progress.worked(1);
		}
	}

	protected void resolveReference(EObject referringElement, IReferenceDescription referenceDescription) {
		Object unresolvedValue = referringElement.eGet(referenceDescription.getEReference());
		if (referenceDescription.getEReference().isMany()) {
			List<?> list = (List<?>) unresolvedValue;
			list.get(referenceDescription.getIndexInList());
		}
	}
}
