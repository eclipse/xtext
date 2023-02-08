/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.util;

import java.io.InputStream;

import org.eclipse.xtext.resource.XtextResource;

/**
 * Abstraction for other test utilities that want to load a resource for a
 * textual model.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public interface ResourceLoadHelper {

	XtextResource getResourceFor(InputStream stream);
	
}
