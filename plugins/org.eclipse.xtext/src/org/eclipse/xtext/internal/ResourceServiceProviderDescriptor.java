/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.internal;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceServiceProviderDescriptor implements Provider<IResourceServiceProvider> {
	
	private final static Logger log = Logger.getLogger(ResourceServiceProviderDescriptor.class);

	private  IConfigurationElement element;
	private String attClass;
	private IResourceServiceProvider resourceServiceProvider;

	public ResourceServiceProviderDescriptor(IConfigurationElement element, String attClass) {
		this.element = element;
		this.attClass = attClass;
	}
	
	public IConfigurationElement getElement() {
		return element;
	}

	public synchronized IResourceServiceProvider get() {
		if (this.resourceServiceProvider == null) {
			try {
				this.resourceServiceProvider = (IResourceServiceProvider) element.createExecutableExtension(attClass);
			} catch (CoreException e) {
				log.error(e.getMessage(),e);
			}
		}
		return this.resourceServiceProvider;
	}

}
