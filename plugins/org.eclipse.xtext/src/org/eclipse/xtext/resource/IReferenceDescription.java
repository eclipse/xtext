/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IReferenceDescription {
	/**
	 * @return the URI pointing to the source EObject 
	 */
	URI getSourceEObjectUri();
	
	/**
	 * @return the URI pointing to the target EObject 
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
}
