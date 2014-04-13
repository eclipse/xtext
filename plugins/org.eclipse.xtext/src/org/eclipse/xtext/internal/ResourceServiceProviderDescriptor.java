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
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceServiceProviderDescriptor implements IResourceServiceProvider.Provider {

	private final static Logger log = Logger.getLogger(ResourceServiceProviderDescriptor.class);

	private IConfigurationElement element;
	private String attClass;
	private Object extension;

	public ResourceServiceProviderDescriptor(IConfigurationElement element, String attClass) {
		this.element = element;
		this.attClass = attClass;
	}

	public IConfigurationElement getElement() {
		return element;
	}

	public synchronized IResourceServiceProvider get(URI uri, String contentType) {
		if (this.extension == null) {
			try {
				this.extension = element.createExecutableExtension(attClass);
			} catch (CoreException e) {
				log.error(e.getMessage(), e);
			} catch (NoClassDefFoundError e) {
				log.error(e.getMessage(), e);
			}
		}
		if (this.extension instanceof IResourceServiceProvider.Provider) {
			IResourceServiceProvider.Provider provider = ((IResourceServiceProvider.Provider) extension);
			IResourceServiceProvider result = provider.get(uri, contentType);
			return result;
		} else if (this.extension instanceof IResourceServiceProvider) {
			return (IResourceServiceProvider) this.extension;
		}
		String type = this.extension == null ? "null" : this.extension.getClass().getName();
		String valid = IResourceServiceProvider.class + " or " + IResourceServiceProvider.Provider.class;
		String suffix = "";
		if (element != null && element.getDeclaringExtension() != null && element.getDeclaringExtension().getContributor() != null) {
			suffix += " contributed by "+element.getDeclaringExtension().getContributor();
		}
		throw new ClassCastException("The type " + type + " is not a valid " + valid + suffix);
	}

}
