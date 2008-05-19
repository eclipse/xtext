/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class CoreLog {

	public final static void logInfo(String msg, Throwable t) {
		log(IStatus.INFO, IStatus.OK, msg, t);
	}

	public final static void logInfo(String msg) {
		log(IStatus.INFO, IStatus.OK, msg, null);
	}

	public final static void logWarning(String msg) {
		log(IStatus.WARNING, IStatus.OK, msg, null);
	}

	public final static void logError(Throwable t) {
		logError(t.getMessage(), t);
	}

	public final static void logError(String msg, Throwable t) {
		log(IStatus.ERROR, IStatus.OK, msg, t);
	}

	public final static void log(IStatus status) {
		Activator.getDefault().getLog().log(status);
	}

	private final static void log(int severity, int code, String message,
			Throwable exception) {
		log(createStatus(severity, code, message, exception));
	}

	private final static IStatus createStatus(int severity, int code,
			String message, Throwable exception) {
		String symbolicName = Activator.getDefault().getBundle()
				.getSymbolicName();
		return new Status(severity, symbolicName, code,
				message != null ? message : "", exception);
	}

}
