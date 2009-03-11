/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImportUriUtil {

	private static Logger log = Logger.getLogger(ImportUriUtil.class);

	public static boolean isValid(EObject context, String uri) {
		URI newURI = getResolvedImportUri(context.eResource(), uri);
		try {
			URI normalized = context.eResource().getResourceSet().getURIConverter().normalize(newURI);
			if (normalized != null)
				return context.eResource().getResourceSet().getURIConverter().exists(normalized, new HashMap<Object,Object>(2));
		} catch(RuntimeException e) { // thrown by org.eclipse.emf.ecore.resource.ResourceSet#getResource(URI, boolean)
			log.trace("Cannot load resource: " + newURI, e);
		}
		return false;
	}

	private static URI getResolvedImportUri(Resource context, String uri) {
		URI contextURI = context.getURI();
		URI newURI = URI.createURI(uri);
		if (contextURI.isHierarchical() && !contextURI.isRelative() && newURI.isRelative()) {
			newURI = newURI.resolve(contextURI);
		}
		return newURI;
	}

	public static Resource getResource(Resource context, String uri) {
		URI newURI = getResolvedImportUri(context, uri);
		try {
			return context.getResourceSet().getResource(newURI, true);
		} catch(RuntimeException e) { // thrown by org.eclipse.emf.ecore.resource.ResourceSet#getResource(URI, boolean)
			log.trace("Cannot load resource: " + newURI, e);
		}
		return null;
	}
}
