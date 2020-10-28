/*******************************************************************************
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.logging;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Knut Wannheden - Refactored handling when used in non OSGi environment
 */
public class EclipseLogAppender extends AppenderSkeleton {

	private static final String LOG4J_BUNDLE_NAME = "org.apache.log4j";

	// this logger will NOT log to this appender (see log4j.properties)
	private static final Logger LOGGER = Logger.getLogger(EclipseLogAppender.class);

	private boolean initialized;
	private ILog log;

	private synchronized void ensureInitialized() {
		if (!initialized) {
			if (!Platform.isRunning()) {
				LOGGER.warn("You appear to be running outside Eclipse; you might want to remove the jar org.eclipse.xtext.logging*.jar from your classpath and supply your own log4j.properties.");
			} else {
				log = Platform.getLog(FrameworkUtil.getBundle(Logger.class));
			}
			initialized = true;
		}
	}

	private ILog getLog() {
		ensureInitialized();
		return log;
	}

	@Override
	protected void append(LoggingEvent event) {
		if (isDoLog(event.getLevel())) {
			String logString = layout.format(event);

			ILog myLog = getLog();
			if (myLog != null) {
				String loggerName = event.getLoggerName();
				int severity = mapLevel(event.getLevel());
				final Throwable throwable = event.getThrowableInformation() != null ? event.getThrowableInformation()
						.getThrowable() : null;
				IStatus status = createStatus(severity, loggerName, logString, throwable);
				getLog().log(status);
			} else {
				// nothing to do (message should be logged to stdout by default appender)
			}
		}
	}

	private boolean isDoLog(Level level) {
		return level.toInt() >= Priority.WARN_INT;
	}

	private int mapLevel(Level level) {
		switch (level.toInt()) {
			case Priority.DEBUG_INT:
			case Priority.INFO_INT:
				return IStatus.INFO;

			case Priority.WARN_INT:
				return IStatus.WARNING;

			case Priority.ERROR_INT:
			case Priority.FATAL_INT:
				return IStatus.ERROR;

			default:
				return IStatus.INFO;
		}
	}

	private IStatus createStatus(int severity, String loggerName, String message, Throwable throwable) {
		return new Status(severity, LOG4J_BUNDLE_NAME, message, throwable);
	}

	@Override
	public void close() {
	}

	@Override
	public boolean requiresLayout() {
		return true;
	}

}
