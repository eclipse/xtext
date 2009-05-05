/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.impl.SimpleAttributeResolver;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Function;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultScope extends SimpleScope {

	public DefaultScope(Resource resource, EClass type, ImportUriResolver resolver) {
		this(resource, type, resolver, SimpleAttributeResolver.NAME_RESOLVER);
	}
	
	public DefaultScope(Resource resource, EClass type, Function<EObject, String> importResolver, Function<EObject, String> nameResolver) {
		super(createParent(resource.getAllContents(), type, resource, importResolver, nameResolver), ScopedElements.allInResource(resource,type,nameResolver));
	}


	private static IScope createParent(Iterator<EObject> iter, EClass type, Resource resource, Function<EObject, String> importResolver, Function<EObject, String> nameResolver) {
		final Set<String> uniqueImportURIs = new HashSet<String>(10);
		final List<String> orderedImportURIs = new ArrayList<String>(10);
		while (iter.hasNext()) {
			EObject object = iter.next();
			String uri = importResolver.apply(object);
			if (uri != null && uniqueImportURIs.add(uri) && ImportUriUtil.isValid(object, uri)) {
				orderedImportURIs.add(uri);
			}
		}
		IScope result = IScope.NULLSCOPE;
		for(int i = orderedImportURIs.size() - 1; i >= 0; i--) {
			result = new LazyReferencedResourceScope(result, type, resource, orderedImportURIs.get(i), nameResolver);
		}
		return result;
	}
	
	static class LazyReferencedResourceScope extends SimpleScope {

		public LazyReferencedResourceScope(IScope parent, EClass type, Resource context, String uri, Function<EObject, String> nameFunc) {
			super(parent, ScopedElements.allInResource(ImportUriUtil.getResource(context, uri), type, nameFunc));
		}

	}
}
