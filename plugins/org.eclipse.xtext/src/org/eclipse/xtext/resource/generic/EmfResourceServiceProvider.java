/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.generic;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.internal.Nullable;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EmfResourceServiceProvider implements IResourceServiceProvider {

	@Inject
	@Nullable
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
	@Nullable
	private IResourceValidator resourceValidator = IResourceValidator.NULL;

	public IResourceValidator getResourceValidator() {
		return resourceValidator;
	}

	private Set<String> extensions;
	
	@Inject
	public void setExtensions(@Named(Constants.FILE_EXTENSIONS)String extensions) {
		String[] split = extensions.split(",");
		this.extensions = Sets.newHashSet();
		for (String string : split) {
			this.extensions.add(string);
		}
	}
	
	public boolean canHandle(URI uri) {
		return extensions.contains(uri.fileExtension());
	}
	
	@Inject
	private IEncodingProvider encodingProvider;
	
	public IEncodingProvider getEncodingProvider() {
		return encodingProvider;
	}
	
	public <T> T get(Class<T> t) {
		return null;
	}
}
