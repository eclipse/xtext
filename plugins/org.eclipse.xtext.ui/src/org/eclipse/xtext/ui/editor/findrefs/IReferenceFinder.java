/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
@ImplementedBy(DefaultReferenceFinder.class)
public interface IReferenceFinder {

	/**
	 * Executes <code>work</code> on the element referred to by the <code>targetURI</code>. That involves reloading the
	 * element if it is proxified or the editor it belonged to has been closed.
	 */
	interface ILocalResourceAccess {
		<R> R readOnly(URI resourceURI, IUnitOfWork<R, ResourceSet> work);
	}

	interface IQueryData {
		URI getLeadElementURI();

		Set<URI> getTargetURIs();

		Predicate<IReferenceDescription> getResultFilter();

		URI getLocalContextResourceURI();

		String getLabel();
	}

	/**
	 * Finds all References for given URIs.
	 */
	void findAllReferences(IQueryData queryData, ILocalResourceAccess localContextProvider,
			IAcceptor<IReferenceDescription> acceptor, IProgressMonitor progressMonitor);

	/**
	 * Finds all References for given URIs.
	 */
	void findIndexedReferences(IQueryData queryData, IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor progressMonitor);

	/**
	 * Finds all local references for the given URIs.
	 */
	void findLocalReferences(IQueryData queryData, ILocalResourceAccess localContextProvider,
			IAcceptor<IReferenceDescription> acceptor, IProgressMonitor progressMonitor);

}
