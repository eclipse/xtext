/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImportUriResolver implements Function<EObject, String> {
	
	public static final String IMPORT_URI_FEATURE = "org.eclipse.xtext.crossref.impl.ImportUriResolver.IMPORT_URI_FEATURE";
	
	@Inject(optional=true)
	@Named(value = IMPORT_URI_FEATURE)
	private String attributeName = "importURI";
	
	private SimpleAttributeResolver<EObject, String> resolver;
	
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	
	public String getAttributeName() {
		return attributeName;
	}

	public SimpleAttributeResolver<EObject, String> getResolver() {
		if (resolver == null) {
			resolver = SimpleAttributeResolver.newResolver(String.class, attributeName);
		}
		return resolver;
	}

	public String resolve(EObject object) {
		return getResolver().apply(object);
	}

	public EStructuralFeature getAttribute(EObject object) {
		return getResolver().getAttribute(object);
	}

	@Override
	public String apply(EObject from) {
		return resolve(from);
	}
	
}