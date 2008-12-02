/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DefaultScope extends SimpleCachingScope {

	private static final SimpleAttributeResolver<String> importResolver = SimpleAttributeResolver.newResolver(String.class, "importURI");

	public DefaultScope(Resource resource, EClass type) {
		super(getParent(resource.getAllContents(), type), resource, type);
	}

	private static IScope getParent(Iterator<EObject> iter, EClass type) {
		while (iter.hasNext()) {
			EObject object = (EObject) iter.next();
			String uri = importResolver.getValue(object);
			if (uri != null) {
				return new LazyReferencedResourceScope(object, type, uri, getParent(iter, type));
			}
		}
		return (IScope) IScope.NULLSCOPE;
	}

	static class LazyReferencedResourceScope extends AbstractNestedScope {

		private EObject context;
		private String uri;
		private Map<String, EObject> elements;
		private SimpleAttributeResolver<String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");
		private EClass type;

		public LazyReferencedResourceScope(EObject context, EClass type, String uri, IScope parent) {
			super(parent);
			this.context = context;
			this.uri = uri;
			this.type = type;
		}

		@Override
		public synchronized Iterable<IScopedElement> getContents() {
			if (elements == null) {
				try {
					Resource resource = context.eResource().getResourceSet().getResource(URI.createURI(uri), true);
					elements = createMap(resource, type, resolver);
				} catch (RuntimeException e) {
					elements = Collections.emptyMap();
				}
			}
			return convert(elements, type);
		}
	}
}
