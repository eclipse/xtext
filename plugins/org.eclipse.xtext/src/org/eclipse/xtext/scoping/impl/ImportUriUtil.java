/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImportUriUtil {

	private static Logger log = Logger.getLogger(ImportUriUtil.class);

	public static boolean isValid(EObject context, String uri) {
		URI newURI = getResolvedImportUri(context.eResource(), uri);
		try {
			URIConverter uriConverter = context.eResource().getResourceSet().getURIConverter();
			URI normalized = uriConverter.normalize(newURI);
			for (Resource res: context.eResource().getResourceSet().getResources()) {
				if (uriConverter.normalize(res.getURI()).equals(normalized))
					return true;
			}
			if (normalized != null)
				return uriConverter.exists(normalized, new HashMap<Object,Object>(2));
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
