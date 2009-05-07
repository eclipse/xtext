/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IndexFacade {

	private IndexStore store;

	public IndexFacade(IndexStore store) {
		this.store = store;
	}

	public Iterable<EReferenceDescriptor> findReferencesTo(EObject target) {
		return store.eReferenceDAO().createQueryEReferencesTo(target).executeListResult();
	}

	public Iterable<EObjectDescriptor> findInstances(EClass eClass) {
		return store.eObjectDAO().createQueryEObjectsByType(eClass).executeListResult();
	}

	public boolean exists(URI fragmentURI) {
		return store.eObjectDAO().createQueryEObjectByURI(fragmentURI).executeSingleResult() != null;
	}

}
