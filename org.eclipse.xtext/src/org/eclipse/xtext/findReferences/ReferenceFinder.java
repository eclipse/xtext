/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.findReferences;

import static com.google.common.collect.Iterables.*;

import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class ReferenceFinder implements IReferenceFinder {

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;
	
	protected static final int MONITOR_CHUNK_SIZE = 100;
	
	@Inject
	public ReferenceFinder() {
		super();
	}
	
	protected ReferenceFinder(IResourceServiceProvider.Registry serviceProviderRegistry) {
		this.serviceProviderRegistry = serviceProviderRegistry;
	}
	
	protected IResourceServiceProvider.Registry getServiceProviderRegistry() {
		return serviceProviderRegistry;
	}
	
	@Override
	public void findReferences(
			TargetURIs targetURIs,
			Set<URI> candidates,
			IResourceAccess resourceAccess,
			IResourceDescriptions descriptions,
			Acceptor acceptor,
			IProgressMonitor monitor) {
		if (!targetURIs.isEmpty() && !candidates.isEmpty()) {
			SubMonitor subMonitor = SubMonitor.convert(monitor, targetURIs.size() / MONITOR_CHUNK_SIZE + 1);
			IProgressMonitor useMe = subMonitor.newChild(1);
			int i = 0;
			for (URI candidate : candidates) {
				if (subMonitor.isCanceled())
					throw new OperationCanceledException();
				IReferenceFinder languageSpecific = getLanguageSpecificReferenceFinder(candidate);
				doFindReferencesWith(languageSpecific, targetURIs, candidate, resourceAccess, descriptions, acceptor, useMe);
				i++;
				if (i % MONITOR_CHUNK_SIZE == 0) {
					useMe = subMonitor.newChild(1);
				}
			}
		}
	}

	protected IReferenceFinder getLanguageSpecificReferenceFinder(final URI candidate) {
		IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(candidate);
		final IReferenceFinder languageSpecific;
		if (serviceProvider != null) {
			languageSpecific = serviceProvider.get(IReferenceFinder.class);
		} else {
			// fallback to the current
			languageSpecific = this;
		}
		return languageSpecific;
	}

	protected void doFindReferencesWith(final IReferenceFinder referenceFinder, final TargetURIs targetURIs, final URI candidate,
			IResourceAccess resourceAccess, IResourceDescriptions descriptions, final Acceptor acceptor,
			final IProgressMonitor monitor) {
		IResourceDescription resourceDescription = null;
		if (!targetURIs.getTargetResourceURIs().contains(candidate) && (resourceDescription = descriptions.getResourceDescription(candidate)) != null) {
			referenceFinder.findReferences(targetURIs, resourceDescription, resourceAccess, acceptor, monitor);
		} else if (resourceAccess != null) {
			resourceAccess.readOnly(candidate, new IUnitOfWork.Void<ResourceSet>() {
				@Override
				public void process(final ResourceSet state) throws Exception {
					Resource resource = state.getResource(candidate, false);
					if (resource != null) {
						referenceFinder.findReferences(targetURIs, resource, acceptor, monitor);
					}
				}
			});
		}
	}
	
	@Override
	public void findAllReferences(Resource scope, Acceptor acceptor, IProgressMonitor monitor) {
		findReferences(Predicates.<URI>alwaysTrue(), scope, acceptor, monitor);
	}
	
	@Override
	public void findReferences(Predicate<URI> targetURIs, Resource resource, Acceptor acceptor, IProgressMonitor monitor) {
		for (EObject content : resource.getContents()) {
			findReferences(targetURIs, content, acceptor, monitor);
		}
	}
	
	@Override
	public void findAllReferences(EObject scope, Acceptor acceptor, IProgressMonitor monitor) {
		findReferences(Predicates.<URI>alwaysTrue(), scope, acceptor, monitor);
	}
	
	@Override
	public void findReferences(Predicate<URI> targetURIs, EObject scope, Acceptor acceptor, IProgressMonitor monitor) {
		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		findLocalReferencesFromElement(targetURIs, scope, scope.eResource(), acceptor);
	}
	
	@Override
	public void findReferences(final TargetURIs targetURIs, IResourceDescription resourceDescription,
			IResourceAccess resourceAccess, final Acceptor acceptor, final IProgressMonitor monitor) {
		final URI resourceURI = resourceDescription.getURI();
		if (resourceAccess != null && targetURIs.containsResource(resourceURI)) {
			IUnitOfWork.Void<ResourceSet> finder = new IUnitOfWork.Void<ResourceSet>() {
				@Override
				public void process(final ResourceSet state) throws Exception {
					Resource resource = state.getResource(resourceURI, true);
					findReferences(targetURIs, resource, acceptor, monitor);
				}
			};
			resourceAccess.readOnly(resourceURI, finder);
		} else {
			findReferencesInDescription(targetURIs, resourceDescription, resourceAccess, acceptor, monitor);
		}
	}

	protected void findReferencesInDescription(TargetURIs targetURIs, IResourceDescription resourceDescription,
			IResourceAccess resourceAccess, Acceptor acceptor, IProgressMonitor monitor) {
		for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
			if (targetURIs.contains(referenceDescription.getTargetEObjectUri())) {
				acceptor.accept(referenceDescription);
			}
		}
	}
	
	@Override
	public void findAllReferences(TargetURIs targetURIs, IResourceAccess resourceAccess,
			IResourceDescriptions indexData, Acceptor acceptor, IProgressMonitor monitor) {
		if (!targetURIs.isEmpty()) {
			Iterable<IResourceDescription> allResourceDescriptions = indexData.getAllResourceDescriptions();
			SubMonitor subMonitor = SubMonitor.convert(monitor, size(allResourceDescriptions) / MONITOR_CHUNK_SIZE + 1);
			IProgressMonitor useMe = subMonitor.newChild(1);
			int i = 0;
			for (IResourceDescription resourceDescription : allResourceDescriptions) {
				if (subMonitor.isCanceled())
					throw new OperationCanceledException();
				IReferenceFinder languageSpecific = getLanguageSpecificReferenceFinder(resourceDescription.getURI());
				languageSpecific.findReferences(targetURIs, resourceDescription, resourceAccess, acceptor, useMe);
				i++;
				if (i % MONITOR_CHUNK_SIZE == 0) {
					useMe = subMonitor.newChild(1);
				}
			}
		}
	}

	protected void findLocalReferencesFromElement(
			Predicate<URI> targetURIs, 
			EObject sourceCandidate,
			Resource localResource,
			Acceptor acceptor) {
		URI sourceURI = null;
		if (doProcess(sourceCandidate, targetURIs)) {
			for(EReference ref: sourceCandidate.eClass().getEAllReferences()) {
				Object value = sourceCandidate.eGet(ref, false);
				if(sourceCandidate.eIsSet(ref) && value != null) {
					if(ref.isContainment()) {
						if(ref.isMany()) {
							@SuppressWarnings("unchecked")
							InternalEList<EObject> contentList = (InternalEList<EObject>) value;
							for(int i=0; i<contentList.size(); ++i) {
								EObject childElement = contentList.basicGet(i);
								if(!childElement.eIsProxy()) {
									findLocalReferencesFromElement(targetURIs, childElement, localResource, acceptor);
								}
							}
						} else {
							EObject childElement = (EObject) value;
							if(!childElement.eIsProxy()) {
								findLocalReferencesFromElement(targetURIs, childElement, localResource, acceptor);
							}
						}
					} else if (!ref.isContainer()) {
						if (doProcess(ref, targetURIs)) {
							if(ref.isMany()) {
								@SuppressWarnings("unchecked")
								InternalEList<EObject> values = (InternalEList<EObject>) value;
								for(int i=0; i< values.size(); ++i) {
									EObject instanceOrProxy = toValidInstanceOrNull(localResource, targetURIs, values.basicGet(i));
									if (instanceOrProxy != null) {
										URI refURI= EcoreUtil2.getPlatformResourceOrNormalizedURI(instanceOrProxy);
										if(targetURIs.apply(refURI)) {
											sourceURI = (sourceURI == null) ? EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
											acceptor.accept(sourceCandidate, sourceURI, ref, i, instanceOrProxy, refURI);
										}
									}
								}
							} else {
								EObject instanceOrProxy = toValidInstanceOrNull(localResource, targetURIs, (EObject) value);
								if (instanceOrProxy != null) {
									URI refURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(instanceOrProxy);
									if (targetURIs.apply(refURI)) {
										sourceURI = (sourceURI == null) ? EcoreUtil2
												.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
										acceptor.accept(sourceCandidate, sourceURI, ref, -1, instanceOrProxy, refURI);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	protected EObject toValidInstanceOrNull(Resource resource, Predicate<URI> targetURIs, EObject value) {
		EObject result = resolveInternalProxy(value, resource);
		return result;
	}
	
	protected EObject resolveInternalProxy(EObject elementOrProxy, Resource resource) {
		if (elementOrProxy.eIsProxy() && ((InternalEObject) elementOrProxy).eProxyURI().trimFragment().equals(resource.getURI()))
			return EcoreUtil.resolve(elementOrProxy, resource);
		else
			return elementOrProxy;
	}

	protected boolean doProcess(EObject sourceCandidate, Predicate<URI> targetURIs) {
		return true;
	}
	
	protected boolean doProcess(EReference reference, Predicate<URI> targetURIs) {
		return true;
	}
	
}
