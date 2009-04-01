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
 */
public class SimpleCachingScope extends AbstractCachingScope {

	public SimpleCachingScope(IScope outer, Resource resource, EClass type) {
		this(outer, resource, type, true);
	}

	public SimpleCachingScope(IScope outer, Resource resource, EClass type, boolean refuseDuplicates) {
		super(outer, type, refuseDuplicates);
		initElements(resource);
	}

	@Override
	protected void initElements(SimpleAttributeResolver<EObject, String> resolver, ScopedElementProducer producer) {
		// should never be called
		throw new UnsupportedOperationException();
	}

}
