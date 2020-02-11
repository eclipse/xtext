/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;

/**
 * Stores information on an element to be renamed and elements whose names change as a consequence.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class ElementRenameArguments {

	private final URI targetElementURI;
	private final Map<URI, URI> original2newElementURIs;
	private final IRenameStrategy renameStrategy;
	private final String newName;
	private final RefactoringResourceSetProvider resourceSetProvider;

	public ElementRenameArguments(
			URI targetElementURI,
			String newName,
			IRenameStrategy renameStrategy,
			Map<URI, URI> original2newElementURIs,
			RefactoringResourceSetProvider resourceSetProvider) {
		this.newName = newName;
		this.targetElementURI = targetElementURI;
		this.renameStrategy = renameStrategy;
		this.original2newElementURIs = original2newElementURIs;
		this.resourceSetProvider = resourceSetProvider;
	}

	public Iterable<URI> getRenamedElementURIs() {
		return original2newElementURIs.keySet();
	}

	public URI getTargetElementURI() {
		return targetElementURI;
	}

	public URI getNewElementURI(URI originalElementURI) {
		URI newElementURI = original2newElementURIs.get(originalElementURI);
		return (newElementURI != null) ? newElementURI : originalElementURI;
	}

	public IRenameStrategy getRenameStrategy() {
		return renameStrategy;
	}
	
	public String getNewName() {
		return newName;
	}
	
	public RefactoringResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

}
