/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.findReferences;

import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.ImplementedBy;

/**
 * Finds cross-references to elements specified by their URIs.
 * 
 * References can be from other resources or local. To be referrable from another resource, an element usually has to be
 * indexed. By default, the index keeps track of cross resource references. See
 * {@link DefaultResourceDescriptionStrategy} for details on the indexing process.
 * 
 * Local references are usually not indexed, and they don't have to be as the scope provider usually takes local
 * elements into account. This is why the reference finder needs an {@link IResourceAccess} if such local
 * references should be found, too.
 * 
 * @author Jan Koehnlein - Initial contribution and API in xtext.ui
 * @author Sebastian Zarnekow - Extracted headless API
 * 
 * @since 2.7
 */
@ImplementedBy(ReferenceFinder.class)
public interface IReferenceFinder {

	/**
	 * Provides safe read access to a resource set for searching local references or references in a demand-created or
	 * shared resource set.
	 */
	interface IResourceAccess {
		<R> R readOnly(URI resourceURI, IUnitOfWork<R, ResourceSet> work);
	}
	
	/**
	 * Used to collect the results.
	 */
	interface Acceptor {
		
		void accept(EObject source, URI sourceURI, EReference eReference, int index, EObject targetOrProxy, URI targetURI);
		
		void accept(IReferenceDescription description);
		
	}
	
	/**
	 * Finds all references from a set of source resources to the given <code>targetURIs</code>.
	 * 
	 * @param targetURIs
	 *            the URIs of the target elements of the references. Should be normalized.
	 * @param candidates
	 *            the search scope for the resources containing the sources of the references.
	 * @param resourceAccess
	 *            used to find local references. If null, only indexed references are returned.
	 * @param acceptor
	 *            accepts the matches.
	 * @param monitor
	 *            the progress monitor. Can be null.
	 */
	void findReferences(
			TargetURIs targetURIs,
			Set<URI> candidates,
			IResourceAccess resourceAccess,
			IResourceDescriptions indexData,
			Acceptor acceptor,
			IProgressMonitor monitor);
	
	/**
	 * Finds the references from the given source resource to the given <code>targetURIs</code>.
	 * 
	 * @param targetURIs
	 *            the URIs of the target elements of the references. Should be normalized.
	 * @param resourceDescription
	 *            the search scope for the resources containing the sources of the references.
	 * @param resourceAccess
	 *            used to find local references. If null, only indexed references are returned.
	 * @param acceptor
	 *            accepts the matches.
	 * @param monitor
	 *            the progress monitor. Can be null.
	 */
	void findReferences(
			TargetURIs targetURIs,
			IResourceDescription resourceDescription,
			IResourceAccess resourceAccess,
			Acceptor acceptor,
			IProgressMonitor monitor);
	
	/**
	 * Finds the references from the given source resource to the given <code>targetURIs</code>.
	 * 
	 * @param targetURIs
	 *            the URIs of the target elements of the references. Should be normalized.
	 * @param resource
	 *            the search scope for the resources containing the sources of the references.
	 * @param acceptor
	 *            accepts the matches.
	 * @param monitor
	 *            the progress monitor. Can be null.
	 */
	void findReferences(
			TargetURIs targetURIs,
			Resource resource,
			Acceptor acceptor,
			IProgressMonitor monitor);
	

	/**
	 * Finds all references to the given <code>targetURIs</code>.
	 * 
	 * @param targetURIs
	 *            the URIs of the target elements of the references. Should be normalized.
	 * @param resourceAccess
	 *            used to find local references. If null, only indexed references are returned.
	 * @param acceptor
	 *            accepts the matches.
	 * @param monitor
	 *            the progress monitor. Can be null.
	 */
	void findAllReferences(
			TargetURIs targetURIs,
			IResourceAccess resourceAccess,
			IResourceDescriptions indexData,
			Acceptor acceptor,
			IProgressMonitor monitor);
	
}
