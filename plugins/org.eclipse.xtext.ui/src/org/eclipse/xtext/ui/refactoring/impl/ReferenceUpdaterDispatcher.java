/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Maps.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.ResourceSetLocalContextProvider;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReferenceUpdaterDispatcher {

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private ReferenceDescriptionAcceptor referenceDescriptionAcceptor;

	public void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Updating references", 100);
		ResourceSetLocalContextProvider localContextProvider = new ResourceSetLocalContextProvider(resourceSet);
		referenceFinder.findAllReferences(elementRenameArguments.getRenamedElementURIs(), localContextProvider, referenceDescriptionAcceptor,
				progress.newChild(30));
		if (!progress.isCanceled()) {
			Multimap<IReferenceUpdater, IReferenceDescription> updater2descriptions = referenceDescriptionAcceptor
					.getReferenceUpdater2ReferenceDescriptions();
			progress = progress.newChild(70).setWorkRemaining(updater2descriptions.keySet().size());
			for (IReferenceUpdater referenceUpdater : updater2descriptions.keySet()) {
				if (progress.isCanceled())
					break;
				referenceUpdater.createReferenceUpdates(elementRenameArguments, 
						updater2descriptions.get(referenceUpdater), updateAcceptor, progress.newChild(1));
			}
		}
	}

	public static class ReferenceDescriptionAcceptor implements IReferenceFinder.IAcceptor {

		@Inject
		private IResourceServiceProvider.Registry resourceServicveProviderRegistry;

		private Map<IResourceServiceProvider, IReferenceUpdater> provider2updater = newHashMap();
		private Multimap<IReferenceUpdater, IReferenceDescription> updater2refs = HashMultimap.create();

		public void accept(IReferenceDescription referenceDescription) {
			if (referenceDescription.getSourceEObjectUri() == null
					|| referenceDescription.getTargetEObjectUri() == null
					|| referenceDescription.getEReference() == null) {
				throw new RefactoringStatusException(
						"Xtext index is corrupt. It is suggested to perform a workspace refresh and a clean build.",
						true);
			}
			URI sourceResourceURI = referenceDescription.getSourceEObjectUri().trimFragment();
			if (!sourceResourceURI.isPlatformResource()) {
				throw new RefactoringStatusException("Referring element is not in workspace: "
						+ notNull(sourceResourceURI), false);
			}
			updater2refs.put(getReferenceUpdater(sourceResourceURI), referenceDescription);
		}

		protected IReferenceUpdater getReferenceUpdater(URI sourceResourceURI) {
			IResourceServiceProvider resourceServiceProvider = resourceServicveProviderRegistry
					.getResourceServiceProvider(sourceResourceURI);
			IReferenceUpdater referenceUpdater = provider2updater.get(resourceServiceProvider);
			if (referenceUpdater == null) {
				referenceUpdater = resourceServiceProvider.get(IReferenceUpdater.class);
				provider2updater.put(resourceServiceProvider, referenceUpdater);
			}
			return referenceUpdater;
		}

		public Multimap<IReferenceUpdater, IReferenceDescription> getReferenceUpdater2ReferenceDescriptions() {
			return updater2refs;
		}
	}
}
