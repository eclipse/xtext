/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.crossref.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class LazyReferencedResourceScope extends AbstractCachingScope {

	private final EObject context;

	private final String uri;

	public LazyReferencedResourceScope(IScope parent, EClass type, EObject context, String uri) {
		super(parent, type, true);
		this.context = context;
		this.uri = uri;
	}

	@Override
	protected void initElements(SimpleAttributeResolver<String> resolver, ScopedElementProducer producer) {
		final Resource resource = ImportUriUtil.getResource(context, uri);
		if (resource != null)
			initElements(resolver, resource, producer);
	}
}