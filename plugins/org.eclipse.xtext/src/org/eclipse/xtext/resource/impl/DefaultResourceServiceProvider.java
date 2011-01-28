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
	
	public org.eclipse.xtext.resource.IContainer.Manager getContainerManager() {
		return get(org.eclipse.xtext.resource.IContainer.Manager.class);
	}
	
	public IResourceDescription.Manager getResourceDescriptionManager() {
		return get(IResourceDescription.Manager.class);
	}
	
	public IResourceValidator getResourceValidator() {
		return get(IResourceValidator.class);
	}
	
	@Inject
	private FileExtensionProvider fileExtensionProvider;
	
	public boolean canHandle(URI uri) {
		return fileExtensionProvider.isValid(uri.fileExtension());
	}

	public IEncodingProvider getEncodingProvider() {
		return get(IEncodingProvider.class);
	}
	
	@Inject
	private Injector injector;
	
	public <T> T get(Class<T> t) {
		try {
			return injector.getInstance(t);
		} catch (ConfigurationException e) {
			return null;
		}
	}
	
}
