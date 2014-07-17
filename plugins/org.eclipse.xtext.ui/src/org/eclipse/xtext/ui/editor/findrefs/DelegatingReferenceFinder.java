/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.findReferences.IReferenceFinder.Acceptor;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

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
	private Provider<TargetURIs> targetURIProvider;
	
	protected TargetURIs toTargetURIs(Iterable<URI> uris) {
		if (uris instanceof TargetURIs) {
			return (TargetURIs) uris;
		}
		TargetURIs result = targetURIProvider.get();
		result.addAllURIs(uris);
		return result;
	}
	
	protected class ReferenceAcceptor implements org.eclipse.xtext.findReferences.IReferenceFinder.Acceptor {

		private IAcceptor<IReferenceDescription> delegate;

		protected ReferenceAcceptor(IAcceptor<IReferenceDescription> delegate) {
			this.delegate = delegate;
		}
		
		public void accept(EObject source, URI sourceURI, EReference eReference, int index, URI targetURI) {
			accept(createReferenceDescription(sourceURI, eReference, index, targetURI));
		}

		public void accept(IReferenceDescription description) {
			this.delegate.accept(description);
		}
		
	}
	
	public void findReferences(Set<URI> targetURIs, IResourceDescription resourceDescription,
			IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor,
			ILocalResourceAccess localResourceAccess) {
		delegate.findReferences(toTargetURIs(targetURIs), resourceDescription, localResourceAccess, toAcceptor(acceptor), monitor);
	}

	protected Acceptor toAcceptor(IAcceptor<IReferenceDescription> acceptor) {
		return new ReferenceAcceptor(acceptor);
	}
	
	protected DefaultReferenceDescription createReferenceDescription(URI sourceURI, EReference eReference,
			int index, URI targetURI) {
		return new DefaultReferenceDescription(sourceURI, targetURI, eReference, index, null);
	}

	public void findReferences(Iterable<URI> targetURIs, Iterable<URI> sourceResourceURIs,
			ILocalResourceAccess localResourceAccess, IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor monitor) {
		Set<URI> asSet = Sets.newHashSet(sourceResourceURIs);
		delegate.findReferences(toTargetURIs(targetURIs), asSet, localResourceAccess, indexData, toAcceptor(acceptor), monitor);
	}

	public void findAllReferences(Iterable<URI> targetURIs, ILocalResourceAccess localResourceAccess,
			IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		delegate.findAllReferences(toTargetURIs(targetURIs), localResourceAccess, indexData, toAcceptor(acceptor), monitor);
	}

}
