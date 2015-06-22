/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.eclipse.emf.common.util.URI;

/**
 * @noreference This class is not intended to be referenced by clients.
 */
public class UriUtil {
	public static boolean isPrefixOf(URI prefix, URI uri) {
		if (prefix.scheme() == null || !prefix.scheme().equals(uri.scheme()))
			return false;
		String[] prefixSeg = prefix.segments();
		String[] uriSeg = uri.segments();
		if (prefixSeg.length == 0 || uriSeg.length == 0)
			return false;
		if (!"".equals(prefixSeg[prefixSeg.length - 1])) // this is true when the URI has a trailing slash ("/").
			return false;
		if (uriSeg.length < prefixSeg.length - 1)
			return false;
		for (int i = 0; i < prefixSeg.length - 1; i++)
			if (!uriSeg[i].equals(prefixSeg[i]))
				return false;
		return true;
	}
}
