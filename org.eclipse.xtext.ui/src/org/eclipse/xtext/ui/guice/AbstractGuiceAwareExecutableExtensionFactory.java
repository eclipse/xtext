/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.guice;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
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

	@Override
	@SuppressWarnings({ "unchecked" })
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
		throws CoreException {
		if (data instanceof String) {
			clazzName = (String) data;
		} else if (data instanceof Map<?, ?>) {
			clazzName = ((Map<String, String>)data).get(GUICEKEY);
		}
		if (clazzName == null) {
			throw new IllegalArgumentException("couldn't handle passed data : "+data);
		}
		this.config = config;
	}
	
	@Override
	public Object create() throws CoreException {
		try {
			final Class<?> clazz = getBundle().loadClass(clazzName);
			final Injector injector = getInjector();
			if (injector == null) {
				throw handleCreationError(null);
			}
			final Object result = injector.getInstance(clazz);
			if (result instanceof IExecutableExtension)
				((IExecutableExtension) result).setInitializationData(config, null, null);
			return result;
		} catch (Throwable e) {
			throw handleCreationError(e);
		}
	}
	
	private CoreException handleCreationError (Throwable cause) {
		Bundle bundle = null;
		String bundleName = null;
		try {
			bundle = getBundle();
		} catch (NullPointerException e) {
			// subclasses generated with Xtext <2.13 will raise a NPE when the UI bundle wqs not activated
			// try to guess the bundle from the EEF's package
			bundle = Platform.getBundle(getClass().getPackage().getName());
		}
		bundleName = bundle != null ? bundle.getSymbolicName() : "UNKNOWN";
		
		if (bundle != null && bundle.getState()!=Bundle.ACTIVE) {
			return new CoreException(new Status(IStatus.ERROR, bundleName, "Bundle "+ bundleName+" not activated. Please check that all dependencies could be resolved and 'Bundle-ActivationPolicy: lazy' is configured in the bundle's MANIFEST.MF. Check also the error log."));	
		}
		
		return new CoreException(new Status(IStatus.ERROR, bundleName, cause.getMessage() + " ExtensionFactory: "+ getClass().getName(), cause));
	}
	
	protected abstract Bundle getBundle();
	protected abstract Injector getInjector();
}
