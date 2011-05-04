/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.HashSet;
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
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.xtext.EcoreUtil2;
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

	public void findAllReferences(IQueryData queryData, ILocalResourceAccess localResourceAccess,
			final IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
		if (!queryData.getTargetURIs().isEmpty()) {
			findLocalReferences(queryData, localResourceAccess, acceptor, subMonitor.newChild(1));
			findIndexedReferences(queryData, acceptor, subMonitor.newChild(1));
		}
	}

	public void findIndexedReferences(final IQueryData queryData, final IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor monitor) {
		findIndexedReferences(queryData.getTargetURIs(), acceptor, queryData.getResultFilter(), monitor);
	}

	/**
	 * @since 2.0
	 */
	public void findIndexedReferences(IQueryData queryData, URI resourceURI, IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor progressMonitor) {
		IResourceDescription resourceDescription = index.getResourceDescription(resourceURI.trimFragment());
		if (resourceDescription != null) {
			for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
				if (queryData.getTargetURIs().contains(referenceDescription.getTargetEObjectUri())
						&& (queryData.getResultFilter() == null || queryData.getResultFilter().apply(
								referenceDescription))) {
					acceptor.accept(referenceDescription);
				}
			}
		}
	}

	public void findLocalReferences(final IQueryData queryData, ILocalResourceAccess localResourceAccess,
			final IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor, "Find references", 1);
		localResourceAccess.readOnly(queryData.getLocalContextResourceURI(), new IUnitOfWork<Boolean, ResourceSet>() {
			public Boolean exec(ResourceSet localContext) throws Exception {
				Set<EObject> targets = newHashSet();
				for (URI targetURI : queryData.getTargetURIs()) {
					EObject target = localContext.getEObject(targetURI, true);
					if (target != null)
						targets.add(target);
				}
				findLocalReferences(targets, acceptor, queryData.getResultFilter(), subMonitor);
				return true;
			}
		});
	}

	public void findLocalReferences(Set<EObject> targets, IAcceptor<IReferenceDescription> acceptor,
			Predicate<IReferenceDescription> filter, IProgressMonitor monitor) {
		if (monitor != null && monitor.isCanceled())
			return;
		if (targets != null && !targets.isEmpty()) {
			Set<Resource> targetResources = new HashSet<Resource>();
			for (EObject target : targets) {
				targetResources.add(target.eResource());
			}
			Map<EObject, Collection<Setting>> targetResourceInternalCrossRefs = CrossReferencer.find(targetResources);
			Map<EObject, URI> exportedElementsMap = null;
			SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.ReferenceQuery_monitor, targets.size());
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
							if (exportedElementsMap == null)
								exportedElementsMap = createExportedElementsMap(target.eResource());
							IReferenceDescription localReferenceDescription = new DefaultReferenceDescription(source,
									target, reference, index, findClosestExportedContainerURI(source,
											exportedElementsMap));
							if (filter == null || filter.apply(localReferenceDescription))
								acceptor.accept(localReferenceDescription);
						}
						subSubMonitor.worked(1);
					}
				}
			}
		}
	}

	protected Map<EObject, URI> createExportedElementsMap(Resource resource) {
		IResourceDescription resourceDescription = index.getResourceDescription(EcoreUtil2.getNormalizedURI(resource));
		Map<EObject, URI> exportedElementMap = newHashMap();
		if (resourceDescription != null) {
			for (IEObjectDescription exportedEObjectDescription : resourceDescription.getExportedObjects()) {
				EObject eObject = resource.getEObject(exportedEObjectDescription.getEObjectURI().fragment());
				if (eObject != null)
					exportedElementMap.put(eObject, exportedEObjectDescription.getEObjectURI());
			}
		}
		return exportedElementMap;
	}

	protected URI findClosestExportedContainerURI(EObject element, Map<EObject, URI> exportedElementsMap) {
		EObject current = element;
		while (current != null) {
			URI uri = exportedElementsMap.get(current);
			if (uri != null)
				return uri;
			current = current.eContainer();
		}
		return null;
	}

	protected void findIndexedReferences(Set<URI> targetURIs, IAcceptor<IReferenceDescription> acceptor,
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
					if (targetURIs.contains(referenceDescription.getTargetEObjectUri())
							&& (filter == null || filter.apply(referenceDescription))) {
						acceptor.accept(referenceDescription);
					}
				}
			}
			subMonitor.worked(1);
		}
	}
}
