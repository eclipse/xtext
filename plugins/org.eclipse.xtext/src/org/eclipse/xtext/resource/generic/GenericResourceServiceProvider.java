/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.generic;

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
 * An {@link IResourceServiceProvider} for non-Xtext resources. 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class GenericResourceServiceProvider implements IResourceServiceProvider {

	@Inject
//	@Nullable
	private IContainer.Manager containerManager;
	
	public IContainer.Manager getContainerManager() {
		return containerManager;
	}
	
	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;

	public IResourceDescription.Manager getResourceDescriptionManager() {
		return resourceDescriptionManager;
	}

	@Inject
//	@Nullable
	private IResourceValidator resourceValidator = IResourceValidator.NULL;

	public IResourceValidator getResourceValidator() {
		return resourceValidator;
	}

	@Inject
	private FileExtensionProvider fileExtensionProvider;
	
	public boolean canHandle(URI uri) {
		return fileExtensionProvider.isValid(uri.fileExtension());
	}
	
	@Inject
	private IEncodingProvider encodingProvider;
	
	public IEncodingProvider getEncodingProvider() {
		return encodingProvider;
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
