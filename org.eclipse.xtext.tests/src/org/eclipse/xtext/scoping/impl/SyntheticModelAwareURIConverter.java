/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtext.util.StringInputStream;

public class SyntheticModelAwareURIConverter extends ExtensibleURIConverterImpl {
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