/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Maps.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;

/**
 * Renames an element without loosing track of the element and dependent elements.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class RenamedElementTracker {

	private Map<URI, URI> old2newURI;

	public void rename(ElementRenameArguments renameArguments, ResourceSet resourceSet, IRenameStrategy renameStrategy) {
		Map<EObject, URI> renamedElement2oldURI = resolveRenamedElements(renameArguments, resourceSet);
		renameStrategy.applyChange(renameArguments.getNewName(), resourceSet);
		old2newURI = relocateRenamedElements(renamedElement2oldURI);		
	}
	
	protected Map<URI, URI> relocateRenamedElements(Map<EObject, URI> renamedElement2oldURI) {
		Map<URI, URI> old2newURI = newHashMap();
		for(Map.Entry<EObject, URI> entry: renamedElement2oldURI.entrySet()) {
			URI newURI = EcoreUtil.getURI(entry.getKey());
			old2newURI.put(entry.getValue(), newURI);
		}
		return old2newURI;
	}

	protected Map<EObject, URI> resolveRenamedElements(ElementRenameArguments renameArguments,
			ResourceSet resourceSet) {
		Map<EObject, URI> renamedElement2oldURI = newHashMap();
		for (URI renamedElementURI : renameArguments.getAllElementURIs()) {
			EObject renamedElement = resourceSet.getEObject(renamedElementURI, true);
			if (renamedElement == null)
				throw new RefactoringStatusException("Cannot resolve dependent element "
						+ notNull(renamedElementURI), true);
			renamedElement2oldURI.put(renamedElement, renamedElementURI);
		}
		return renamedElement2oldURI;
	}

	public URI getNewURI(URI oldURI) {
		if (old2newURI.containsKey(oldURI))
			return old2newURI.get(oldURI);
		return oldURI;
	}

}
