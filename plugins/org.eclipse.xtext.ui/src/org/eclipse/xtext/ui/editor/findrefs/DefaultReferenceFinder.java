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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class DefaultReferenceFinder implements IReferenceFinder {

	private IResourceDescriptions index;

	@Inject
	public DefaultReferenceFinder(IResourceDescriptions index) {
		this.index = index;
	}

	public void findAllReferences(Iterable<URI> targetURIs, ILocalContextProvider localContextProvider,
			final IAcceptor<IReferenceDescription> acceptor, Predicate<IReferenceDescription> filter,
			IProgressMonitor monitor) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
		Iterator<URI> iterator = targetURIs.iterator();
		if (iterator.hasNext()) {
			findLocalReferences(targetURIs.iterator().next().trimFragment(), targetURIs, localContextProvider,
					acceptor, filter, subMonitor.newChild(1));
			findIndexedReferences(targetURIs, acceptor, filter, subMonitor.newChild(1));
		}
	}

	public void findLocalReferences(final URI resourceURI, final Iterable<URI> targetURIs,
			ILocalContextProvider localContextProvider, final IAcceptor<IReferenceDescription> acceptor,
			final Predicate<IReferenceDescription> filter, IProgressMonitor monitor) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor, "Find references", 1);
		localContextProvider.readOnly(resourceURI, new IUnitOfWork<Boolean, ResourceSet>() {
			public Boolean exec(ResourceSet localContext) throws Exception {
				Resource resource = localContext.getResource(resourceURI.trimFragment(), true);
				List<EObject> targets = newArrayList();
				for (URI targetURI : targetURIs) {
					EObject target = localContext.getEObject(targetURI, true);
					if (target != null)
						targets.add(target);
				}
				findLocalReferences(resource, targets, acceptor, filter, subMonitor);
				return true;
			}
		});
	}

	public void findLocalReferences(Resource resource, Iterable<EObject> targets,
			IAcceptor<IReferenceDescription> acceptor, Predicate<IReferenceDescription> filter, IProgressMonitor monitor) {
		if (monitor.isCanceled())
			return;
		if (targets != null && !isEmpty(targets)) {
			Map<EObject, Collection<Setting>> targetResourceInternalCrossRefs = CrossReferencer.find(Collections
					.singletonList(resource));
			SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.ReferenceQuery_monitor, size(targets));
			for (EObject target : targets) {
				Collection<Setting> crossRefSettings = targetResourceInternalCrossRefs.get(target);
				if (crossRefSettings != null) {
					SubMonitor subSubMonitor = subMonitor.newChild(crossRefSettings.size());
					for (Setting crossRefSetting : crossRefSettings) {
						if (subSubMonitor.isCanceled())
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
							if (filter == null || filter.apply(localReferenceDescription))
								acceptor.accept(localReferenceDescription);
						}
						subSubMonitor.worked(1);
					}
				}
			}
		}
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

	public void findIndexedReferences(Iterable<URI> targetURIs, IAcceptor<IReferenceDescription> acceptor,
			Predicate<IReferenceDescription> filter, IProgressMonitor monitor) {
		Set<URI> targetResourceURIs = newHashSet(transform(targetURIs, new Function<URI, URI>() {
			public URI apply(URI from) {
				return from.trimFragment();
			}
		}));
		int numResources = Iterables.size(index.getAllResourceDescriptions());
		SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.ReferenceQuery_monitor, numResources);
		for (IResourceDescription resourceDescription : index.getAllResourceDescriptions()) {
			if (subMonitor.isCanceled())
				return;
			if (!targetResourceURIs.contains(resourceDescription.getURI())) {
				for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
					if (contains(targetURIs, referenceDescription.getTargetEObjectUri())
							&& (filter == null || filter.apply(referenceDescription))) {
						acceptor.accept(referenceDescription);
					}
				}
			}
			subMonitor.worked(1);
		}
	}
}
