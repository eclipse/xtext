/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExternalContentSupport implements IExternalContentSupport {
	
	public void configureResourceSet(ResourceSet resourceSet, IExternalContentProvider contentProvider) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null");
		if (contentProvider == null)
			throw new IllegalArgumentException("contentProvider may not be null");
		configureConverter(resourceSet.getURIConverter(), contentProvider);
	}
	
	public void configureConverter(URIConverter converter, final IExternalContentProvider contentProvider) {
		List<URIHandler> uriHandlers = converter.getURIHandlers();
		ListIterator<URIHandler> iter = uriHandlers.listIterator();
		while(iter.hasNext()) {
			URIHandler transformed = new ExternalContentAwareURIHandler(iter.next(), contentProvider);
			iter.set(transformed);
		}
	}
	
	public static class ExternalContentAwareURIHandler implements URIHandler {

		private URIHandler delegate;
		private final IExternalContentProvider contentProvider;
		
		public ExternalContentAwareURIHandler(URIHandler delegate, IExternalContentProvider contentProvider) {
			this.delegate = delegate;
			this.contentProvider = contentProvider;
		}

		public boolean canHandle(URI uri) {
			return delegate.canHandle(uri);
		}

		public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
			return delegate.contentDescription(uri, options);
		}

		public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
			if (contentProvider.hasContent(uri)) {
				return new StringInputStream(contentProvider.getContent(uri));
			}
			return delegate.createInputStream(uri, options);
		}

		public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
			return delegate.createOutputStream(uri, options);
		}

		public void delete(URI uri, Map<?, ?> options) throws IOException {
			delegate.delete(uri, options);
		}

		public boolean exists(URI uri, Map<?, ?> options) {
			return contentProvider.hasContent(uri) || delegate.exists(uri, options);
		}

		public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
			return delegate.getAttributes(uri, options);
		}

		public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
			delegate.setAttributes(uri, attributes, options);
		}
		
	}

}
