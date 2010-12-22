/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import static com.google.common.collect.Iterables.*;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;

/**
 * Stores information on an element to be renamed and elements whose names change as a consequence.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class ElementRenameArguments extends RenameArguments {

	private final URI baseElementURI;
	private final Iterable<URI> dependentElementURIs;

	public ElementRenameArguments(String newName, URI baseElementURI, Iterable<URI> dependentElementURIs,
			boolean updateReferences) {
		super(newName, updateReferences);
		this.baseElementURI = baseElementURI;
		this.dependentElementURIs = dependentElementURIs;
	}

	public Iterable<URI> getAllElementURIs() {
		return concat(Collections.singletonList(baseElementURI), dependentElementURIs);
	}

	public URI getBaseElementURI() {
		return baseElementURI;
	}

	public Iterable<URI> getDependentElementURIs() {
		return dependentElementURIs;
	}
	
}
