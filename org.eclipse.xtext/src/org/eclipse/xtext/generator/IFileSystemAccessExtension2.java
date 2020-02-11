/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.common.util.URI;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public interface IFileSystemAccessExtension2 {
	
	/**
	 * Returns an URI for the specified path.
	 * 
	 * For workspace resources a platform:/resource URI should be returned in order to pick up project specific preferences.
	 */
	URI getURI(String path, String outputConfiguration);

	/**
	 * Returns an URI for the specified path in the default output location.
	 * 
	 * For workspace resources a platform:/resource URI should be returned in order to pick up project specific preferences.
	 */
	URI getURI(String path);

}
