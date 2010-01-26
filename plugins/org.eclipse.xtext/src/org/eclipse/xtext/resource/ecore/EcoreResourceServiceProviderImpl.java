/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IContainer.Manager;
import org.eclipse.xtext.validation.IResourceValidator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EcoreResourceServiceProviderImpl implements IResourceServiceProvider {

	public Manager getContainerManager() {
		return null;
	}

	private EcoreResourceDescriptionManager ecoreResourceDescriptionManager = new EcoreResourceDescriptionManager();

	public org.eclipse.xtext.resource.IResourceDescription.Manager getResourceDescriptionManager() {
		return ecoreResourceDescriptionManager;
	}

	public IResourceValidator getResourceValidator() {
		return null;
	}

}
