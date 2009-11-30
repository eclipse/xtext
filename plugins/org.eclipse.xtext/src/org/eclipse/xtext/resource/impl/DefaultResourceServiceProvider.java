/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IContainer.Manager;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultResourceServiceProvider implements IResourceServiceProvider {
	
	@Inject
	private Manager containerManager;
	
	public void setContainerManager(Manager containerManager) {
		this.containerManager = containerManager;
	}

	public Manager getContainerManager() {
		return containerManager;
	}
	
	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;

	public IResourceDescription.Manager getResourceDescriptionManager() {
		return resourceDescriptionManager;
	}
	
	public void setResourceDescriptionManager(IResourceDescription.Manager resourceDescriptionManager) {
		this.resourceDescriptionManager = resourceDescriptionManager;
	}
	
	@Inject(optional=true)
	private IResourceValidator resourceValidator;

	public IResourceValidator getResourceValidator() {
		return resourceValidator;
	}

}
