/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import java.util.Map;

import org.eclipse.emf.common.util.URI;

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

	public ElementRenameArguments(URI targetElementURI, String newName, IRenameStrategy renameStrategy,
			Map<URI, URI> original2newElementURIs) {
		this.newName = newName;
		this.targetElementURI = targetElementURI;
		this.renameStrategy = renameStrategy;
		this.original2newElementURIs = original2newElementURIs;
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

}
