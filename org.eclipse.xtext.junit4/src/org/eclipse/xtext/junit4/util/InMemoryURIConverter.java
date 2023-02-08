/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtext.util.StringInputStream;


/**
 * A {@link org.eclipse.emf.ecore.resource.URIConverter} that can create input streams
 * for synthetic URIs based on previously registered mappings.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
@Deprecated(forRemoval = true, since = "2.30")
public class InMemoryURIConverter extends ExtensibleURIConverterImpl {
	private final Map<URI, InputStream> models = new HashMap<URI, InputStream>();

	public void addModel(String uri, String content) {
		models.put(URI.createURI(uri), new StringInputStream(content));
	}

	@Override
	public boolean exists(URI uri, Map<?, ?> options) {
	 	boolean result = models.containsKey(uri);
	 	if (!result) {
	 		for(URI knownUri: models.keySet()) {
	 			if (uri.toString().endsWith(knownUri.toString()))
	 				return true;
	 		}
	 	}
	 	return result;
	}

	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		return models.get(uri);
	}
}