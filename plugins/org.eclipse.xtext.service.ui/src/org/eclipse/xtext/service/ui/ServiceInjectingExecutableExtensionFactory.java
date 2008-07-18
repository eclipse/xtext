/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;

/**
 * @author Peter Friese - Initial contribution and API
 * @author svenefftinge
 */
public class ServiceInjectingExecutableExtensionFactory implements IExecutableExtensionFactory, IExecutableExtension {

	private Log log = LogFactory.getLog(getClass());
	private String id;
	private IConfigurationElement config;
	private String propertyName;
	private String extensionClassName;
	private String languageId;

	private IServiceScope getLanguageDescriptor(String languageId) {
		return ServiceScopeFactory.get(languageId);
	}

	public Object create() throws CoreException {
		Object extensionInstance = instantiateDelegate(config);
		configure(extensionInstance);
		return extensionInstance;
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		if (data instanceof String) {
			id = (String) data;
			String[] split = id.split("/");
			extensionClassName = split[0];
			languageId = split[1];
		} else {
			throw new CoreException(new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID, 0,
					"Data argument must be a String for " + getClass(), null)); //$NON-NLS-1$
		}
		this.config = config;
		this.propertyName = propertyName;
	}

	private Object configure(Object extensionInstance) throws CoreException {
		IServiceScope languageDescriptor = getLanguageDescriptor(languageId);
		ServiceRegistry.injectServices(languageDescriptor, extensionInstance);

		if (extensionInstance instanceof IExecutableExtension) {
			((IExecutableExtension) extensionInstance).setInitializationData(config, propertyName, null);
		}
		return extensionInstance;
	}

	private Object instantiateDelegate(IConfigurationElement config) {
		try {
			Class<?> javaClass = Platform.getBundle(config.getDeclaringExtension().getContributor().getName())
					.loadClass(extensionClassName);
			return javaClass.newInstance();
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

}
