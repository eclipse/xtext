/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.Iterator;

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
		super(createParent(resource.getAllContents(), type), resource, type);
	}

	private static IScope createParent(Iterator<EObject> iter, EClass type) {
		while (iter.hasNext()) {
			EObject object = iter.next();
			String uri = importResolver.getValue(object);
			if (uri != null) {
				return new LazyReferencedResourceScope(createParent(iter, type), type, object, uri);
			}
		}
		return IScope.NULLSCOPE;
	}
}
