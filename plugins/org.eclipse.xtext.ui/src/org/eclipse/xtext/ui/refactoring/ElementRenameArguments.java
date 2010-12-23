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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;

/**
 * Stores information on an element to be renamed and elements whose names change as a consequence.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class ElementRenameArguments extends RenameArguments {

	private final URI baseElementURI;
	private final Map<URI,URI> original2newElementURIs;
	private final IRenameStrategy renameStrategy;

	public ElementRenameArguments(URI baseElementURI, String newName, IRenameStrategy renameStrategy,
			Map<URI,URI> original2newElementURIs,
			boolean updateReferences) {
		super(newName, updateReferences);
		this.baseElementURI = baseElementURI;
		this.renameStrategy = renameStrategy;
		this.original2newElementURIs = original2newElementURIs;
	}

	public Iterable<URI> getRenamedElementURIs() {
		return original2newElementURIs.keySet();
	}
	
	public URI getBaseElementURI() {
		return baseElementURI;
	}
	
	public URI getNewElementURI(URI originalElementURI) {
		URI newElementURI = original2newElementURIs.get(originalElementURI);
		return (newElementURI != null) ? newElementURI : originalElementURI; 
	}

	public void applyDeclarationChange(ResourceSet resourceSet) {
		renameStrategy.applyDeclarationChange(getNewName(), resourceSet);
	}

	
}
