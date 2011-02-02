/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
@ImplementedBy(DefaultReferenceFinder.class)
public interface IReferenceFinder {

	@ImplementedBy(EditorLocalContextProvider.class)
	interface ILocalContextProvider {
		<R> R readOnly(URI targetURI, IUnitOfWork<R, EObject> work);
	}
	/**
	 * <p>Finds all References for a given URI.</p>
	 */
	void findAllReferences(URI target, ILocalContextProvider localContextProvider, IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor monitor);
	/**
	 * <p>Finds all References for given URIs.</p>
	 */
	void findAllReferences(Iterable<URI> targetURIs, ILocalContextProvider localContextProvider, IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor progressMonitor);
	/**
	 * <p>Finds all local references for a given URI in a given Resource for. If the Resource is null the Resource corresponding to given URI is used.</p>
	 */
	void findLocalReferences(Resource resource, URI targetURI, ILocalContextProvider localContextProvider, IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor monitor);
	/**
	 * <p>Finds all local references for the given URIs in a given Resource. If the Resource is null the Resource corresponding to given URIs is used.</p>
	 */
	void findLocalReferences(Resource resource, Iterable<URI> targetURIs, ILocalContextProvider localContextProvider, IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor progressMonitor);

}
