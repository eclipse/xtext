/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.IMirrorExtension;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IClassMirror extends IMirror, IMirrorExtension {
	
	/**
	 * Return the location URI of this class mirror. Returns null if none is available.
	 * @since 2.35
	 */
	default URI getLocationURI(Resource resource) {
		return null;
	}
	
}
