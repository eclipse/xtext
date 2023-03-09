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
 * An interface for a classpath URI resolution strategy.
 *  
 * @author Jan Köhnlein
 */
public interface IClasspathUriResolver {

    URI resolve(Object context, URI classpathUri);
}
