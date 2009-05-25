/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sven Efftinge 
 */
public class GuiceExecutableExtensionFactory implements IExecutableExtensionFactory, IExecutableExtension {

	private String clazzName;
	private IConfigurationElement config;
	private Object data;
	private String propertyName;

	@SuppressWarnings("unchecked")
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
		throws CoreException {
		if (data instanceof String) {
			clazzName = (String) data;
		} else if (data instanceof Map) {
			clazzName = (String) ((Map)data).get("actualClass");
		}
		if (clazzName==null)
			throw new IllegalArgumentException("couldn't handle passed data : "+data);
		this.config = config;
		this.data = data;
		this.propertyName = propertyName;
	}
	
	public Object create() throws CoreException {
		EmfIndexUIPlugin instance = EmfIndexUIPlugin.getDefault();
		if (instance == null)
			throw new IllegalStateException("The bundle has not yet been activated. Make sure the Manifest.MF contains 'Bundle-ActivationPolicy: lazy'.");
		Bundle bundle = instance.getBundle();
		try {
			final Class<?> clazz = bundle.loadClass(clazzName);
			final Injector injector = instance.getInjector();
			final Object result = injector.getInstance(clazz);
			if (result instanceof IExecutableExtension)
				((IExecutableExtension) result).setInitializationData(config, propertyName, data);
			return result;
		}
		catch (Exception e) {
			EmfIndexUIPlugin.logError(e.getMessage(),e);
			throw new CoreException(new Status(Status.ERROR, bundle.getSymbolicName(), e.getMessage(),e));
		}
	}

}
