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
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.ImplementedBy;

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultReferenceFinder.class)
public interface IReferenceFinder {

	interface IAcceptor {
		public void accept(IReferenceDescription referenceDescription);
	}

	@ImplementedBy(EditorLocalContextProvider.class)
	interface ILocalContextProvider {
		<R> R readOnly(URI targetURI, IUnitOfWork<R, EObject> work);
	}

	void findAllReferences(Iterable<URI> targetURI, ILocalContextProvider localContextProvider, IAcceptor acceptor,
			IProgressMonitor progressMonitor);

	void findAllReferences(URI targetURI, ILocalContextProvider localContextProvider, IAcceptor acceptor,
			IProgressMonitor monitor);
	
	void findLocalReferences(EObject target, IAcceptor acceptor, IProgressMonitor monitor);

}
