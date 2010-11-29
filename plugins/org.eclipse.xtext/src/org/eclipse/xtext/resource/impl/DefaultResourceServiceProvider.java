/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.common.collect.Sets;
import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

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
