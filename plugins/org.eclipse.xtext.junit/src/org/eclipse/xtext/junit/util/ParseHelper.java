/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Some convenience methods for parsing (i.e. testing, etc.) 
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ParseHelper<T extends EObject> {
	
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject
	private IResourceFactory resourceFactory;

	@SuppressWarnings("unchecked")
	public T parse(InputStream in, URI uriToUse, Map<?,?> options) {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		Resource resource = resourceFactory.createResource(uriToUse);
		resourceSet.getResources().add(resource);
		try {
			resource.load(in, options);
			final T root = (T) (resource.getContents().isEmpty()? null : resource.getContents().get(0));
			return root;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
	
	public T parse(String text) throws Exception {
		return parse(getAsStream(text), URI.createURI("no.uri"),null);
	}
	
	protected InputStream getAsStream(String text) {
		return new StringInputStream(text);
	}

}
