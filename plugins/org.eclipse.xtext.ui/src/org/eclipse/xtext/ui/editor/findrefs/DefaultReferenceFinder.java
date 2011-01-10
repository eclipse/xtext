/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultReferenceFinder implements IReferenceFinder {

	private IResourceDescriptions index;

	@Inject
	public DefaultReferenceFinder(IResourceDescriptions index) {
		this.index = index;
	}

	public void findAllReferences(URI targetURI, ILocalContextProvider localContextProvider,
			final IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		findAllReferences(singleton(targetURI), localContextProvider, acceptor, monitor);
	}
			
	public void findAllReferences(Iterable<URI> targetURIs, ILocalContextProvider localContextProvider,
			final IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		final IProgressMonitor realMonitor = (monitor == null) ? new NullProgressMonitor() : monitor;
		realMonitor.beginTask("Find references", 2);
		for (URI targetURI : targetURIs) {
			localContextProvider.readOnly(targetURI, new IUnitOfWork<Boolean, EObject>() {
				public Boolean exec(EObject state) throws Exception {
					findLocalReferences(state, acceptor, new SubProgressMonitor(realMonitor, 1));
					return true;
				}
			});
		}
		findIndexedReferences(targetURIs, acceptor, new SubProgressMonitor(realMonitor, 1));
		realMonitor.done();
	}

	public void findLocalReferences(EObject target, IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		if (monitor.isCanceled())
			return;
		if (target != null) {
			Map<EObject, Collection<Setting>> targetResourceInternalCrossRefs = CrossReferencer.find(Collections
					.singletonList(target.eResource()));
			Collection<Setting> crossRefSettings = targetResourceInternalCrossRefs.get(target);
			if (crossRefSettings != null) {
				monitor.beginTask(Messages.ReferenceQuery_monitor, crossRefSettings.size());
				for (Setting crossRefSetting : crossRefSettings) {
					if (monitor.isCanceled())
						return;
					EObject source = crossRefSetting.getEObject();
					if (crossRefSetting.getEStructuralFeature() instanceof EReference) {
						EReference reference = (EReference) crossRefSetting.getEStructuralFeature();
						int index = 0;
						if (reference.isMany()) {
							List<?> values = (List<?>) source.eGet(reference);
							for (int i = 0; i < values.size(); ++i) {
								if (target == values.get(i)) {
									index = i;
									break;
								}
							}
						}
						IReferenceDescription localReferenceDescription = new DefaultReferenceDescription(source,
								target, reference, index, findClosestExportedParentURI(source));
						acceptor.accept(localReferenceDescription);
					}
					monitor.worked(1);
				}
			}
		}
		monitor.done();
	}

	protected URI findClosestExportedParentURI(EObject element) {
		URI resourceURI = element.eResource().getURI();
		LinkedList<URI> parentURIs = newLinkedList();
		EObject currentParent = element;
		while (currentParent != null) {
			parentURIs.addFirst(EcoreUtil.getURI(currentParent));
			currentParent = currentParent.eContainer();
		}
		int currentBestIndex = -1;
		IResourceDescription resourceDescription = index.getResourceDescription(resourceURI);
		if (resourceDescription != null) {
			for (IEObjectDescription exportedEObject : resourceDescription.getExportedObjects()) {
				currentBestIndex = Math.max(currentBestIndex, parentURIs.indexOf(exportedEObject.getEObjectURI()));
			}
		}
		if (currentBestIndex == -1)
			return null;
		else
			return parentURIs.get(currentBestIndex);
	}

	public void findIndexedReferences(Iterable<URI> targetURIs, IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		Set<URI> targetResourceURIs = newHashSet(transform(targetURIs, new Function<URI, URI>() {
			public URI apply(URI from) {
				return from.trimFragment();
			}
		}));
		if (monitor.isCanceled())
			return;
		int numResources = Iterables.size(index.getAllResourceDescriptions());
		monitor.beginTask(Messages.ReferenceQuery_monitor, numResources);
		for (IResourceDescription resourceDescription : index.getAllResourceDescriptions()) {
			if (monitor.isCanceled())
				return;
			if (!targetResourceURIs.contains(resourceDescription.getURI())) {
				for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
					if (contains(targetURIs, referenceDescription.getTargetEObjectUri())) {
						acceptor.accept(referenceDescription);
					}
				}
			}
			monitor.worked(1);
		}
		monitor.done();
	}
	
}
