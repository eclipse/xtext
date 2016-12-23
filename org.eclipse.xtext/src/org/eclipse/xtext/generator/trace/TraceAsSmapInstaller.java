/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TraceAsSmapInstaller implements ITraceToBytecodeInstaller {
	
	private static final Logger LOG = Logger.getLogger(TraceAsSmapInstaller.class);
	private static final String DELEGATE_CLASS = "org.eclipse.xtext.smap.TraceAsSmapInstaller";
	Object delegate;
	
	@Inject
	protected void setInjector(Injector injector) {
		try {
			Class<?> loadClass = getClass().getClassLoader().loadClass(DELEGATE_CLASS);
			delegate = injector.getInstance(loadClass);
		} catch (ClassNotFoundException e) {
			LOG.warn("Cannot install debug information into bytecode, because 'org.eclipse.xtext.smap' is missing on the classpath. Please add 'org.eclipse.xtext.smap' to your plugin classpath.");
		}
	}

	@Override
	public byte[] installTrace(byte[] javaClassBytecode) throws IOException {
		if (delegate == null) {
			return javaClassBytecode;
		}
		try {
			Method method = delegate.getClass().getMethod("installTrace", javaClassBytecode.getClass());
			Object result = method.invoke(delegate, javaClassBytecode);
			return (byte[]) result;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOG.error("Error installing trace information.", e);
		}
		return javaClassBytecode;
	}

	@Override
	public void setTrace(String javaFileName, AbstractTraceRegion trace) {
		if (delegate == null) {
			return;
		}
		try {
			Method method = delegate.getClass().getMethod("setTrace", String.class, AbstractTraceRegion.class);
			method.invoke(delegate, javaFileName, trace);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOG.error("Error setting trace information.", e);
		}
	}
}
