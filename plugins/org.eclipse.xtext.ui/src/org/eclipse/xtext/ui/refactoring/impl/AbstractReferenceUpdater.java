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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.UpdateAcceptor;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class AbstractReferenceUpdater implements IReferenceUpdater {

	@Inject
	private ReferenceDescriptionSorter sorter;

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	public RefactoringStatus createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			IRenameStrategy renameStrategy, Iterable<IReferenceDescription> referenceDescriptions,
			UpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		RefactoringStatus status = new RefactoringStatus();
		try {
			progress.beginTask("Sort references by project", 5);
			Multimap<IProject, IReferenceDescription> project2references = sorter.sortByProject(referenceDescriptions);
			SubMonitor allProjectsProgress = progress.newChild(95).setWorkRemaining(project2references.keySet().size());
			for (IProject project : project2references.keySet()) {
				if(allProjectsProgress.isCanceled())
					break;
				Multimap<URI, IReferenceDescription> resource2references = sorter.sortByResource(project2references
						.get(project));
				int numResources = resource2references.keySet().size();
				SubMonitor projectProgress = allProjectsProgress.newChild(1).setWorkRemaining(numResources+2);
				ResourceSet resourceSet = resourceSetProvider.get(project);
				XtextResource targetResource = loadTargetResource(resourceSet, elementRenameArguments, projectProgress.newChild(1));
				loadReferringResources(resourceSet, resource2references.keySet(), projectProgress.newChild(numResources));
				ReplaceRegion declarationUpdate = applyDeclarationUpdate(elementRenameArguments, renameStrategy,
						targetResource);
				internalCreateReferenceUpdates(elementRenameArguments, resource2references, resourceSet,
						declarationUpdate, updateAcceptor, status, projectProgress.newChild(1));
			}
		} catch (Exception exc) {
			RefactoringStatusExtension.handleException(status, exc);
		}
		return status;
	}

	protected abstract void internalCreateReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			ReplaceRegion declarationEdit, UpdateAcceptor updateAcceptor, RefactoringStatus status, IProgressMonitor monitor);

	protected ReplaceRegion applyDeclarationUpdate(ElementRenameArguments elementRenameArguments,
			IRenameStrategy renameStrategy, XtextResource targetResource) {
		ReplaceRegion declarationEdit = renameStrategy.getReplaceRegion(elementRenameArguments.getNewName());
		targetResource.update(declarationEdit.getOffset(), declarationEdit.getLength(), declarationEdit.getText());
		return declarationEdit;
	}

	protected XtextResource loadTargetResource(ResourceSet resourceSet, ElementRenameArguments elementRenameArguments, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Loading target resource", 1);
		Resource targetResource = resourceSet.getResource(elementRenameArguments.getBaseElementRenameInfo()
				.getElementURI().trimFragment(), true);
		if (!(targetResource instanceof XtextResource)) {
			throw new RefactoringStatusException("Cannot load target resource", true);
		}
		progress.worked(1);
		return (XtextResource) targetResource;
	}

	protected void loadReferringResources(ResourceSet resourceSet,
			Iterable<URI> referringResourceURIs, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Loading referencing resources", size(referringResourceURIs));
		for (URI referringResourceURI : referringResourceURIs) {
			Resource referringResource = resourceSet.getResource(referringResourceURI, true);
			if (referringResource == null)
				throw new RefactoringStatusException("Resource " + notNull(referringResourceURI) + " cannot be loaded",
						true);
			progress.worked(1);
		}
	}

}
