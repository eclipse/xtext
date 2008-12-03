/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.crossref.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LazyReferencedResourceScope extends AbstractCachingScope {

	private EObject context;
	
	private String uri;
	
	public LazyReferencedResourceScope(IScope parent, EClass type, EObject context, String uri) {
		super(parent, type);
		this.context = context;
		this.uri = uri;
	}
	
	protected Map<String, EObject> initElements(SimpleAttributeResolver<String> resolver) {
		try {
			Resource resource = context.eResource().getResourceSet().getResource(URI.createURI(uri), true);
			return initElements(resolver, resource);
		} catch (RuntimeException e) {
			return Collections.emptyMap();
		}
	}
}