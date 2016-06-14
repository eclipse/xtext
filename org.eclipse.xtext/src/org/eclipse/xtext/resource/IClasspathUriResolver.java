/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
