/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface URIHelperConstants {

	URI PRIMITIVES_URI = URI.createURI("java:/Primitives");
	URI OBJECTS_URI = URI.createURI("java:/Objects");

	String PRIMITIVES = "/Primitives"; //$NON-NLS-1$
	String OBJECTS = "/Objects/"; //$NON-NLS-1$
	String PROTOCOL = "java"; //$NON-NLS-1$
	
}
