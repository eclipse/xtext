/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Maps.*;
import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIConverter;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.ResourceAccess;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Finds all references to renamed elements and dispatches to the {@link IReferenceUpdater} of the referring languages
 * to calculate the updates.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferenceUpdaterDispatcher {

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
	
	@Inject
	private TargetURIConverter targetURIConverter;
	
	@Inject
	private Provider<ResourceAccess> resourceAccessProvider;
	
	@Inject
	private IResourceDescriptions indexData;
	
	public void createReferenceUpdates(
			ElementRenameArguments elementRenameArguments,
			ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Updating references", 100);
		ResourceAccess resourceAccess = resourceAccessProvider.get();
		resourceAccess.registerResourceSet(resourceSet);
		
		ReferenceDescriptionAcceptor referenceDescriptionAcceptor = createFindReferenceAcceptor(updateAcceptor);
		referenceFinder.findAllReferences(
				targetURIConverter.fromIterable(elementRenameArguments.getRenamedElementURIs()),
				resourceAccess,
				indexData,
				referenceDescriptionAcceptor,
				progress.newChild(2));
		Multimap<IReferenceUpdater, IReferenceDescription> updater2descriptions = referenceDescriptionAcceptor
				.getReferenceUpdater2ReferenceDescriptions();
		SubMonitor updaterProgress = progress.newChild(98).setWorkRemaining(updater2descriptions.keySet().size());
		for (IReferenceUpdater referenceUpdater : updater2descriptions.keySet()) {
			if (updaterProgress.isCanceled())
				return;
			referenceUpdater.createReferenceUpdates(elementRenameArguments, updater2descriptions.get(referenceUpdater), updateAcceptor,
					updaterProgress.newChild(1));
		}
	}

	protected ReferenceDescriptionAcceptor createFindReferenceAcceptor(IRefactoringUpdateAcceptor updateAcceptor) {
		return new ReferenceDescriptionAcceptor(resourceServiceProviderRegistry, updateAcceptor.getRefactoringStatus());
	}

	public static class ReferenceDescriptionAcceptor implements IReferenceFinder.Acceptor {

		private Map<IResourceServiceProvider, IReferenceUpdater> provider2updater = newHashMap();
		private Multimap<IReferenceUpdater, IReferenceDescription> updater2refs = HashMultimap.create();

		private StatusWrapper status;
		private final Registry resourceServiceProviderRegistry;

		public ReferenceDescriptionAcceptor(IResourceServiceProvider.Registry resourceServiceProviderRegistry,
				StatusWrapper status) {
			this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
			this.status = status;
		}

		@Override
		public void accept(IReferenceDescription referenceDescription) {
			if (referenceDescription.getSourceEObjectUri() == null
					|| referenceDescription.getTargetEObjectUri() == null
					|| referenceDescription.getEReference() == null) {
				handleCorruptReferenceDescription(referenceDescription, status);
			} else {
				URI sourceResourceURI = referenceDescription.getSourceEObjectUri().trimFragment();
				IReferenceUpdater referenceUpdater = getReferenceUpdater(sourceResourceURI);
				if (referenceUpdater == null)
					handleNoReferenceUpdater(sourceResourceURI, status);
				else
					updater2refs.put(referenceUpdater, referenceDescription);
			}
		}
		
		@Override
		public void accept(EObject source, URI sourceURI, EReference eReference, int index, EObject targetOrProxy,
				URI targetURI) {
			accept(new DefaultReferenceDescription(EcoreUtil2.getFragmentPathURI(source), targetURI, eReference, index, null));
		}

		protected void handleNoReferenceUpdater(URI sourceResourceURI, StatusWrapper status) {
			status.add(WARNING,
					"References from {0} will not be updated as the language has not registered an IReferenceUpdater",
					sourceResourceURI);
		}

		protected void handleCorruptReferenceDescription(IReferenceDescription referenceDescription,
				StatusWrapper status) {
			status.add(ERROR,
					"Xtext index contains invalid entries. It is suggested to perform a workspace refresh and a clean build.");
		}

		protected IReferenceUpdater getReferenceUpdater(URI sourceResourceURI) {
			//TODO Why do we cache the IReferenceUpdater here?
			IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry
					.getResourceServiceProvider(sourceResourceURI);
			if (resourceServiceProvider == null)
				return null;
			IReferenceUpdater referenceUpdater = provider2updater.get(resourceServiceProvider);
			if (referenceUpdater == null) {
				referenceUpdater = resourceServiceProvider.get(OptionalReferenceUpdaterProxy.class).get();
				if (referenceUpdater != null)
					provider2updater.put(resourceServiceProvider, referenceUpdater);
			}
			return referenceUpdater;
		}

		public Multimap<IReferenceUpdater, IReferenceDescription> getReferenceUpdater2ReferenceDescriptions() {
			return updater2refs;
		}
	}

	protected static class OptionalReferenceUpdaterProxy {
		@Inject(optional = true)
		private IReferenceUpdater referenceUpdater;

		public IReferenceUpdater get() {
			return referenceUpdater;
		}
	}
}
