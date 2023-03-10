/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.maven;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.maven.plugin.logging.Log;

/**
 * @author Michael Clay
 * @author Moritz Eysholdt
 */
public class MavenLog4JConfigurator {

	protected final static Level LOG4J_DEFAULT_LOG_LEVEL = Level.INFO;

	public void configureLog4j(Log log) {
		if (!Logger.getRootLogger().getAllAppenders().hasMoreElements()) {
			try {
				Logger.getRootLogger().setLevel(LOG4J_DEFAULT_LOG_LEVEL);
			} catch (NoSuchMethodError e) {
				// see http://bugzilla.slf4j.org/show_bug.cgi?id=279
			}
			Logger.getRootLogger().addAppender(createMojoLogAppender(log));
		} else {
			configureLog4j(log, "org.eclipse.xtext");
			configureLog4j(log, "org.eclipse.xtend");
		}
	}

	protected void configureLog4j(Log log, String name) {
		Logger logger = Logger.getLogger(name);
		logger.setAdditivity(false);
		try {
			logger.setLevel(LOG4J_DEFAULT_LOG_LEVEL);
		} catch (NoSuchMethodError e) {
			// see http://bugzilla.slf4j.org/show_bug.cgi?id=279
		}
		logger.removeAllAppenders();
		logger.addAppender(createMojoLogAppender(log));
	}

	protected AppenderSkeleton createMojoLogAppender(final Log log) {
		return new AppenderSkeleton() {

			@Override
			protected void append(LoggingEvent event) {
				if (event.getMessage() == null) {
					return;
				}
				Throwable throwable = getThrowable(event);
				CharSequence message = String.valueOf(event.getMessage());
				if (throwable != null) {
					// Loggers like org.apache.maven.plugin.logging.SystemStreamLog
					// (used by Maven Testing Harness)
					// throw a NullPointerException if throwable is null
					if (Level.DEBUG == event.getLevel()) {
						log.debug(message, throwable);
					} else if (Level.INFO == event.getLevel()) {
						log.info(message, throwable);
					} else if (Level.WARN == event.getLevel()) {
						log.warn(message, throwable);
					} else if (Level.ERROR == event.getLevel()) {
						log.error(message, throwable);
					}
				} else {
					if (Level.DEBUG == event.getLevel()) {
						log.debug(message);
					} else if (Level.INFO == event.getLevel()) {
						log.info(message);
					} else if (Level.WARN == event.getLevel()) {
						log.warn(message);
					} else if (Level.ERROR == event.getLevel()) {
						log.error(message);
					}
				}
			}

			public void close() {
			}

			private Throwable getThrowable(LoggingEvent event) {
				if (event.getThrowableInformation() != null) {
					return event.getThrowableInformation().getThrowable();
				}
				return null;
			}

			public boolean requiresLayout() {
				return false;
			}
		};
	}
}
