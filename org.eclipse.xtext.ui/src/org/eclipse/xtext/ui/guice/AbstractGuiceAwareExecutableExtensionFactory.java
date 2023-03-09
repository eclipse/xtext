/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * @author Karsten Thoms - Bug#462906
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
		} catch (VirtualMachineError | CoreException e) {
			throw e;
		} catch (Throwable e) {
			throw handleCreationError(e);
		}
	}
	
	/**
	 * In the case that the EEF fails to create an injector or an instance of the desired class
	 * this method is called to produce a more user friendly error message.
	 * @since 2.13
	 */
	protected CoreException handleCreationError(Throwable cause) {
		String message;
		String contributor = config.getDeclaringExtension().getContributor().getName();
		Bundle bundle = Platform.getBundle(contributor);
		if (cause != null && ! (cause instanceof NullPointerException)) {
			message = cause.getMessage() + " (occurred in " + getClass().getName() + ")";
		} else {
			message = "Could not create the Injector for " + getClass().getName() + ".";
		}

		if (bundle.getState() != Bundle.ACTIVE) {
			message += "\nBundle " + bundle.getSymbolicName() + " was not activated.\n"
				+ "Please check that all dependencies could be resolved and 'Bundle-ActivationPolicy: lazy' is configured in the bundle's MANIFEST.MF. "
				+ "Check also the error log.";
		}
		if (cause instanceof NullPointerException) {
			message += "\nA NullPointerException occurred. This also indicates that bundle "+bundle.getSymbolicName()
				+ " was compiled with an outdated version of Xtext. Please consider to regenerate the DSL implementation "
				+ " with a current version.\n"
				+ "Your currently installed version of Xtext is "
				+ Platform.getBundle("org.eclipse.xtext.ui").getVersion() + ".";
		}

		return new CoreException(
				new Status(IStatus.ERROR, bundle.getSymbolicName(), message, cause));
	}
	
	protected abstract Bundle getBundle();
	protected abstract Injector getInjector();
}
