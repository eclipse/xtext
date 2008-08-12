/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.index.internal.ModelIndex;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IModelIndex {

	static final IModelIndex INSTANCE = new ModelIndex(false);

	boolean exists(URI fragmentUri);

	Collection<URI> findReferencesTo(EObject eObject, IProject scope);

	Collection<URI> findInstances(EClass eClass, IProject scope);

	void clearAll() throws Exception;

	void startListening();

	void stopListening();

	void shutdown() throws Exception;
}
