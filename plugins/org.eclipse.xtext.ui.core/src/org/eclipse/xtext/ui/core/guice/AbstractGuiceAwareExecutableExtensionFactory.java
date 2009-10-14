/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.guice;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractGuiceAwareExecutableExtensionFactory implements IExecutableExtensionFactory, IExecutableExtension {
	public static final String GUICEKEY = "guicekey";
	protected Logger log = Logger.getLogger(getClass());
	protected String clazzName;
	protected IConfigurationElement config;

	@SuppressWarnings("unchecked")
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
		throws CoreException {
		if (data instanceof String) {
			clazzName = (String) data;
		} else if (data instanceof Map) {
			clazzName = ((Map<String, String>)data).get(GUICEKEY);
		}
		if (clazzName == null) {
			throw new IllegalArgumentException("couldn't handle passed data : "+data);
		}
		this.config = config;
	}
	
	public Object create() throws CoreException {
		IGuiceAwareActivator instance = getActivator();
		if (instance == null)
			throw new IllegalStateException("The bundle has not yet been activated. Make sure the Manifest.MF contains 'Bundle-ActivationPolicy: lazy'.");
		Bundle bundle = instance.getBundle();
		try {
			final Class<?> clazz = bundle.loadClass(clazzName);
			final Injector injector = instance.getInjector("org.eclipse.xtext.example.Domainmodel");
			final Object result = injector.getInstance(clazz);
			if (result instanceof IExecutableExtension)
				((IExecutableExtension) result).setInitializationData(config, null, null);
			return result;
		}
		catch (Exception e) {
			log.error(e);
			throw new CoreException(new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage(),e));
		}
	}
	
	protected abstract IGuiceAwareActivator getActivator();
}
