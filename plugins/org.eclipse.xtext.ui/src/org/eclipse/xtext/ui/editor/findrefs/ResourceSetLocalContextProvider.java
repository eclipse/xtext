/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.ILocalContextProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ResourceSetLocalContextProvider implements ILocalContextProvider {

	private ResourceSet resourceSet;
	
	public ResourceSetLocalContextProvider(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	public <R> R readOnly(URI targetURI, IUnitOfWork<R, EObject> work) {
		EObject eObject = resourceSet.getEObject(targetURI, true);
		try {
			if(eObject != null)
				return work.exec(eObject);			
			return null;
		} catch(Exception e) {
			throw new WrappedException(e);
		}
	}

}
