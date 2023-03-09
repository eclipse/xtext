/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.ImplementedBy;

/**
 * Finds cross-references to elements specified by their URIs.
 * 
 * References can be from other resources or local. To be referrable from another resource, an element has to be
 * indexed. By default, the index keeps track of such cross resource references. See
 * {@link DefaultResourceDescriptionStrategy} for details on the indexing process.
 * 
 * Local references are usually not indexed, and they don't have to be as the scope provider usually takes local
 * elements into account. This is why the reference finder needs an {@link ILocalResourceAccess} if such local
 * references should be found, too.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
@ImplementedBy(DelegatingReferenceFinder.class)
public interface IReferenceFinder {

	/**
	 * Provides safe read access to a resource set for searching local references.
	 */
	interface ILocalResourceAccess extends org.eclipse.xtext.findReferences.IReferenceFinder.IResourceAccess {
	}

	/**
	 * Finds all references from an iterable of source resources to the given <code>targetURIs</code>.
	 * 
	 * @param targetURIs
	 *            the URIs of the target elements of the references. Should be normalized.
	 * @param sourceResourceURIs
	 *            the search scope for the resources containing the sources of the references.
	 * @param localResourceAccess
	 *            used to find local references. If null, only indexed references are returned.
	 * @param referenceAcceptor
	 *            accepts the matches.
	 * @param monitor
	 *            the progress monitor. Can be null.
	 */
	void findReferences(
			Iterable<URI> targetURIs,
			Iterable<URI> sourceResourceURIs,
			ILocalResourceAccess localResourceAccess,
			IAcceptor<IReferenceDescription> referenceAcceptor,
			IProgressMonitor monitor);

	/**
	 * Finds all references to the given <code>targetURIs</code>.
	 * 
	 * @param targetURIs
	 *            the URIs of the target elements of the references. Should be normalized.
	 * @param localResourceAccess
	 *            used to find local references. If null, only indexed references are returned.
	 * @param referenceAcceptor
	 *            accepts the matches.
	 * @param monitor
	 *            the progress monitor. Can be null.
	 */
	void findAllReferences(
			Iterable<URI> targetURIs,
			ILocalResourceAccess localResourceAccess,
			IAcceptor<IReferenceDescription> referenceAcceptor,
			IProgressMonitor monitor);
}
