/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tests;

import java.io.InputStream;

import org.eclipse.xtext.resource.XtextResource;

/**
 * Abstraction for other test utilities that want to load a resource for a
 * textual model.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ResourceLoadHelper {

	XtextResource getResourceFor(InputStream stream);
	
}
