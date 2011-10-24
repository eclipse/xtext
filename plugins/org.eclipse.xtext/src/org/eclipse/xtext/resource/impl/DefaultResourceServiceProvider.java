/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

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

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultResourceServiceProvider implements IResourceServiceProvider {
	
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
	
	public org.eclipse.xtext.resource.IContainer.Manager getContainerManager() {
		return containerManager;
	}
	
	public IResourceDescription.Manager getResourceDescriptionManager() {
		return resourceDescriptionManager;
	}
	
	public IResourceValidator getResourceValidator() {
		return resourceValidator;
	}
	
	public boolean canHandle(URI uri) {
		return fileExtensionProvider.isValid(uri.fileExtension());
	}

	public IEncodingProvider getEncodingProvider() {
		return encodingProvider;
	}
	
	public <T> T get(Class<T> t) {
		try {
			return injector.getInstance(t);
		} catch (ConfigurationException e) {
			return null;
		}
	}
	
}
