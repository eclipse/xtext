/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;
import org.eclipse.xtext.ui.refactoring.IIndexBasedReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class CompositeIndexBasedReferenceUpdater implements IReferenceUpdater {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	private IResourceDescriptions index;

	public RefactoringStatus createReferenceUpdates(ElementRenameInfo baseRenameInfo,
			Iterable<ElementRenameInfo> dependentRenameInfos, ReplaceRegion declarationEdit, ResourceSet resourceSet,
			UpdateAcceptor textEditChangeAcceptor) {
		RefactoringStatus status = new RefactoringStatus();
		Iterable<ElementRenameInfo> allRenameInfos = concat(singletonList(baseRenameInfo), dependentRenameInfos);
		Iterable<IReferenceUpdater> referenceUpdaters = collectIndexBasedReferenceUpdaters(status, allRenameInfos);
		for (IReferenceUpdater referenceUpdater : referenceUpdaters) {
			RefactoringStatus referenceUpdateStatus = referenceUpdater.createReferenceUpdates(baseRenameInfo,
					dependentRenameInfos, declarationEdit, resourceSet, textEditChangeAcceptor);
			status.merge(referenceUpdateStatus);
		}
		return status;
	}

	protected Iterable<IReferenceUpdater> collectIndexBasedReferenceUpdaters(RefactoringStatus status,
			Iterable<ElementRenameInfo> allRenameInfos) {
		Set<URI> declarationResourceURIs = collectDeclarationResourceURIs(allRenameInfos);
		Set<IReferenceUpdater> referenceUpdaters = newHashSet();
		Set<IResourceServiceProvider> resourceServiceProviders = newHashSet();
		for (IResourceDescription resourceDescription : index.getAllResourceDescriptions()) {
			if (!declarationResourceURIs.contains(resourceDescription.getURI())) {
				IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry
						.getResourceServiceProvider(resourceDescription.getURI());
				if (resourceServiceProvider == null) {
					status.addError("No resource service provider registered for "
							+ notNull(resourceDescription.getURI()));
				} else {
					if(resourceServiceProviders.add(resourceServiceProvider)) {
						IIndexBasedReferenceUpdater referenceUpdater = resourceServiceProvider.get(IIndexBasedReferenceUpdater.class);
						if (referenceUpdater != null)
							referenceUpdaters.add(referenceUpdater);
					}
				}
			}
		}
		return referenceUpdaters;
	}

	protected Set<URI> collectDeclarationResourceURIs(Iterable<ElementRenameInfo> allRenameInfos) {
		Set<URI> declarationResourceURIs = newHashSet();
		for (ElementRenameInfo elementRenameInfo : allRenameInfos) {
			declarationResourceURIs.add(elementRenameInfo.getElementURI().trimFragment());
		}
		return declarationResourceURIs;
	}

}
