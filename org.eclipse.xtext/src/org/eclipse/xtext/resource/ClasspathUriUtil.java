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
 * Creates classpath URIs for files in the workspace.
 * 
 * See {@link IClasspathUriResolver} for details.
 * 
 * @author Jan Koehnlein
 */
public class ClasspathUriUtil {

    public static final String CLASSPATH_SCHEME = "classpath";

    public static boolean isClasspathUri(URI uri) {
    	if (uri == null)
    		return false;
        String scheme = uri.scheme();
        return CLASSPATH_SCHEME.equals(scheme);
    }

}
