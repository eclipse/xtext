/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.lang.reflect.Field;

import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.core.runtime.ILog;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.osgi.framework.ServiceReference;

/**
 * 
 * HACK for making JDT shut up about AbortCompilation errors.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class ShutUpAboutCompilationErrorsJdtLogger implements Logger {
	
	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ShutUpAboutCompilationErrorsJdtLogger.class);
	
	private Logger original;
	private Field field;
	private ILog logInstance;
	private boolean installed = false;

	public ShutUpAboutCompilationErrorsJdtLogger() {
		logInstance = InternalPlatform.getDefault().getLog(JavaCore.getPlugin().getBundle());
		try {
			field = logInstance.getClass().getDeclaredField("logger");
			field.setAccessible(true);
			original = (Logger)field.get(logInstance);
			field.set(logInstance, this);
			installed = true;
		} catch (Exception e) {
			// no logging
		}
	}
	
	public void uninstall() {
		if (installed) {
			try {
				field.set(logInstance, original);
				installed = false;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public void log(int level, String message) {
		original.log(level, message);
	}

	public void log(int level, String message, Throwable exception) {
		if (isSurpressed(exception))
			return;
		original.log(level, message, exception);
	}

	public void log(ServiceReference<?> sr, int level, String message) {
		original.log(sr, level, message);
	}

	public void log(ServiceReference<?> sr, int level, String message, Throwable exception) {
		if (isSurpressed(exception))
			return;
		original.log(sr, level, message, exception);
	}

	public void log(Object context, int level, String message) {
		original.log(context, level, message);
	}

	public void log(Object context, int level, String message, Throwable exception) {
		if (isSurpressed(exception))
			return;
		original.log(null, level, message, exception);
	}

	protected boolean isSurpressed(Throwable exception) {
		return exception instanceof AbortCompilation;
	}

	public boolean isLoggable(int level) {
		return original.isLoggable(level);
	}

	public String getName() {
		return original.getName();
	}

}
