/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.crossref.IScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultScope extends SimpleCachingScope {

	private final static SimpleAttributeResolver<String> importResolver = SimpleAttributeResolver.newResolver(String.class, ImportUriValidator.IMPORT_URI);

	public DefaultScope(Resource resource, EClass type) {
		super(createParent(resource.getAllContents(), type, resource), resource, type);
	}

	private static IScope createParent(Iterator<EObject> iter, EClass type, Resource resource) {
		final Set<String> uniqueImportURIs = new HashSet<String>(10);
		final List<String> orderedImportURIs = new ArrayList<String>(10);
		while (iter.hasNext()) {
			EObject object = iter.next();
			String uri = importResolver.getValue(object);
			if (uri != null && uniqueImportURIs.add(uri) && ImportUriUtil.isValid(object, uri)) {
				orderedImportURIs.add(uri);
			}
		}
		IScope result = IScope.NULLSCOPE;
		for(int i = orderedImportURIs.size() - 1; i >= 0; i--) {
			result = new LazyReferencedResourceScope(result, type, resource, orderedImportURIs.get(i));
		}
		return result;
	}
}
