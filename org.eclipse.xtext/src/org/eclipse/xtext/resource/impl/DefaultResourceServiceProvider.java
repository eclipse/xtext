/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProviderExtension;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultResourceServiceProvider implements IResourceServiceProvider, IResourceServiceProviderExtension {
	
	@Inject
	private IContainer.Manager containerManager;
	
	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;
	
	@Inject
	private IResourceValidator resourceValidator;
	
	@Inject
	private FileExtensionProvider fileExtensionProvider;
	
	@Inject(optional = true)
	private IEncodingProvider encodingProvider;
	
	@Inject
	private Injector injector;
	
	@Override
	public org.eclipse.xtext.resource.IContainer.Manager getContainerManager() {
		return containerManager;
	}
	
	@Override
	public IResourceDescription.Manager getResourceDescriptionManager() {
		return resourceDescriptionManager;
	}
	
	@Override
	public IResourceValidator getResourceValidator() {
		return resourceValidator;
	}
	
	@Override
	public boolean canHandle(URI uri) {
		return fileExtensionProvider.isValid(uri.fileExtension());
	}

	@Override
	public IEncodingProvider getEncodingProvider() {
		return encodingProvider;
	}
	
	@Override
	public <T> T get(Class<T> t) {
		try {
			return injector.getInstance(t);
		} catch (ConfigurationException e) {
			return null;
		}
	}

	/**
	 * @since 2.9
	 */
	@Override
	public boolean isSource(URI uri) {
		return !uri.isArchive();
	}
	
}
