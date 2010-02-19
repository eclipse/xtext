/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IContainer.Manager;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultResourceUIServiceProvider implements IResourceUIServiceProvider {

	private IResourceServiceProvider delegate;
	
	@Inject
	public DefaultResourceUIServiceProvider(IResourceServiceProvider delegate) {
		this.delegate = delegate;
	}
	
	public Manager getContainerManager() {
		return delegate.getContainerManager();
	}

	public org.eclipse.xtext.resource.IResourceDescription.Manager getResourceDescriptionManager() {
		return delegate.getResourceDescriptionManager();
	}

	public IResourceValidator getResourceValidator() {
		return delegate.getResourceValidator();
	}

	@Inject@ResourceServiceDescriptionLabelProvider
	private ILabelProvider descriptionLabelProvider;
	
	public ILabelProvider getLabelProvider() {
		return descriptionLabelProvider;
	}
	
	public boolean canHandle(URI uri) {
		return delegate.canHandle(uri);
	}
	
	public boolean canHandle(URI uri, IStorage storage) {
		return delegate.canHandle(uri);
	}

}
