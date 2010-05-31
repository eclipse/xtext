/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sven Efftinge
 * @author Sebastian Zarnekow
 */
public abstract class AbstractGenericModule implements Module {

	private static Logger LOGGER = Logger.getLogger(AbstractGenericModule.class);

	public void configure(Binder binder) {
		Module compound = getBindings();
		compound.configure(binder);
	}

	public final CompoundModule getBindings() {
		Method[] methods = this.getClass().getMethods();
		CompoundModule result = new CompoundModule();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("bind")) {
					result.add(new BindModule(method, this));
				} else if (method.getName().startsWith("provide")) {
					result.add(new ProviderModule(method, this));
				} else if (method.getName().startsWith("configure")) {
					if (!method.getName().equals("configure") && method.getParameterTypes().length == 1
							&& method.getParameterTypes()[0].equals(Binder.class)) {
						result.add(new FreeModule(method, this));

					}
				}
			} catch (Exception e) {
				LOGGER.warn("Trying to use method " + method.toGenericString() + " for configuration failed", e);
			}
		}
		return result;
	}

	protected void bindProperties(Binder binder, String propertyFilePath) {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(propertyFilePath);
			if (in != null) {
				Properties properties = new Properties();
				properties.load(in);
				Names.bindProperties(binder, properties);
			} else {
				throw new IllegalStateException("Couldn't find property file : " + propertyFilePath);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected Properties tryBindProperties(Binder binder, String propertyFilePath) {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(propertyFilePath);
			if (in != null) {
				Properties properties = new Properties();
				properties.load(in);
				Names.bindProperties(binder, properties);
				return properties;
			} else
				return null;
		} catch (IOException e) {
			return null;
		}
	}

}
