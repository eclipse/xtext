/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.logging;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 */
public class EclipseLogAppender extends AppenderSkeleton {

	private static final String ORG_APACHE_LOG4J = "org.apache.log4j";
	private ILog log = null;

	private synchronized ILog getLog(String loggerName) {
		if (log == null) {
			Bundle[] bundles = Platform.getBundles(ORG_APACHE_LOG4J,"1.2.15");
			if (bundles.length==0)
				throw new IllegalStateException("Host bundle not found!");
			log = Platform.getLog(bundles[0]);
		}
		return log;
	}

	@Override
	protected void append(LoggingEvent event) {
		if (isDoLog(event.getLevel())) {
			String logString = layout.format(event);
			String loggerName = event.getLoggerName();

			ILog myLog = getLog(loggerName);
			if (myLog != null) {
				int severity = mapLevel(event.getLevel());
				IStatus status = createStatus(severity, loggerName, logString);
				myLog.log(status);
			}
			else {
				System.out
						.println("No Eclipse Log configured (you need to add a org.eclipse.xtext.logging.loggermap extension to your plugin.xml). Log message was: "
								+ logString);
			}
		}
	}

	private boolean isDoLog(Level level) {
		return (level.toInt() >= Priority.WARN_INT);
	}

	private int mapLevel(Level level) {
		switch (level.toInt()) {
			case Priority.DEBUG_INT:
				return IStatus.INFO;

			case Priority.INFO_INT:
				return IStatus.INFO;

			case Priority.WARN_INT:
				return IStatus.WARNING;

			case Priority.ERROR_INT:
				return IStatus.ERROR;

			case Priority.FATAL_INT:
				return IStatus.ERROR;

			default:
				return IStatus.INFO;
		}
	}

	private IStatus createStatus(int severity, String loggerName, String message) {
		return createStatus(severity, loggerName, message, null);
	}

	private IStatus createStatus(int severity, String loggerName, String message, Throwable throwable) {
		return new Status(severity, ORG_APACHE_LOG4J, message, throwable);
	}

	public void close() {
	}

	public boolean requiresLayout() {
		return true;
	}

}
