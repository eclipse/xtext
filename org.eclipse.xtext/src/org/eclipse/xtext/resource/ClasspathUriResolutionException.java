/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;

/**
 * @author Jan Köhnlein
 */
public class ClasspathUriResolutionException extends RuntimeException {

	private static final long serialVersionUID = 1124765L;

	public ClasspathUriResolutionException(Exception exc) {
		super(exc);
	}
	
	public ClasspathUriResolutionException(URI unresolvedURI) {
		super(unresolvedURI.toString());
	}

}
