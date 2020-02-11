/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.findReferences.IReferenceFinder.Acceptor;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.findReferences.TargetURIConverter;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Implementation of the UI APIs for find references that delegates to the runtime
 * implementation.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DelegatingReferenceFinder implements IReferenceFinder, IReferenceFinderExtension1 {

	@Inject
	private IResourceDescriptions indexData;
	
	@Inject
	private org.eclipse.xtext.findReferences.IReferenceFinder delegate;
	
	@Inject
	private TargetURIConverter converter;
	
	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
	
	@Override
	public void findReferences(Set<URI> targetURIs, IResourceDescription resourceDescription,
			IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor,
			ILocalResourceAccess localResourceAccess) {
		delegate.findReferences(converter.fromIterable(targetURIs), resourceDescription, localResourceAccess, toAcceptor(acceptor), monitor);
	}

	@Override
	public void findReferences(Iterable<URI> targetURIs, Iterable<URI> sourceResourceURIs,
			ILocalResourceAccess localResourceAccess, IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor monitor) {
		Set<URI> asSet = Sets.newHashSet(sourceResourceURIs);
		delegate.findReferences(converter.fromIterable(targetURIs), asSet, localResourceAccess, indexData, toAcceptor(acceptor), monitor);
	}

	@Override
	public void findAllReferences(Iterable<URI> targetURIs, ILocalResourceAccess localResourceAccess,
			IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		delegate.findAllReferences(converter.fromIterable(targetURIs), localResourceAccess, indexData, toAcceptor(acceptor), monitor);
	}
	
	protected Acceptor toAcceptor(IAcceptor<IReferenceDescription> acceptor) {
		return new ReferenceAcceptor(acceptor, resourceServiceProviderRegistry);
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public TargetURIConverter getConverter() {
		return converter;
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setConverter(TargetURIConverter converter) {
		this.converter = converter;
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public org.eclipse.xtext.findReferences.IReferenceFinder getDelegate() {
		return delegate;
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setDelegate(org.eclipse.xtext.findReferences.IReferenceFinder delegate) {
		this.delegate = delegate;
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public IResourceDescriptions getIndexData() {
		return indexData;
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setIndexData(IResourceDescriptions indexData) {
		this.indexData = indexData;
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public IResourceServiceProvider.Registry getResourceServiceProviderRegistry() {
		return resourceServiceProviderRegistry;
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setResourceServiceProviderRegistry(IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
		this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
	}
	
}
