/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IReferenceDescription {
	/**
	 * @return the URI pointing to the source {@link org.eclipse.emf.ecore.EObject}
	 */
	URI getSourceEObjectUri();

	/**
	 * @return the URI pointing to the target {@link org.eclipse.emf.ecore.EObject}
	 */
	URI getTargetEObjectUri();

	/**
	 * @return the index of the reference, if the reference isMultiple, -1 if it is a single value reference
	 */
	int getIndexInList();

	/**
	 * @return the {@link EReference}
	 */
	EReference getEReference();

	/**
	 * @return the URI pointing to the exported {@link org.eclipse.emf.ecore.EObject} containing this reference. 
	 * 		   This can be the EObject defining the reference or one of its containers.
	 */
	URI getContainerEObjectURI();
}
