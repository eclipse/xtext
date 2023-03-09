/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class JavaResourceServiceProvider implements IResourceServiceProvider {
	@Inject
	private Injector injector;

	@Inject
	private FileExtensionProvider extensionProvider;

	@Override
	public boolean canHandle(final URI uri) {
		return extensionProvider.getFileExtensions().contains(uri.fileExtension()) && !uri.isArchive();
	}

	@Override
	public <T extends Object> T get(final Class<T> t) {
		try {
			return injector.<T>getInstance(t);
		} catch (final ConfigurationException e) {
			return null;
		}
	}

	@Override
	public IContainer.Manager getContainerManager() {
		return get(IContainer.Manager.class);
	}

	@Override
	public IEncodingProvider getEncodingProvider() {
		return get(IEncodingProvider.class);
	}

	@Override
	public IResourceDescription.Manager getResourceDescriptionManager() {
		return get(IResourceDescription.Manager.class);
	}

	@Override
	public IResourceValidator getResourceValidator() {
		return null;
	}
}
