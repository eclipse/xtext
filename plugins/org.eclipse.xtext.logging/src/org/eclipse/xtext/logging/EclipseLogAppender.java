/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.logging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class EclipseLogAppender extends AppenderSkeleton {

	private ArrayList<LoggerMapEntry> mappings = new ArrayList<LoggerMapEntry>();
	private Map<String, Bundle> bundleMap = new HashMap<String, Bundle>();
	private Map<String, ILog> loggerMap = new HashMap<String, ILog>();

	{
		initializeMappings();
	}

	@Override
	protected void append(LoggingEvent event) {
		if (doLog(event.getLevel())) {
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

	private boolean doLog(Level level) {
		// TODO: later, we might decide to allow users to specify the allowed
		// log levels via an extension point attribute
		return (level.toInt() >= Level.WARN_INT);
	}

	private int mapLevel(Level level) {
		switch (level.toInt()) {
			case Level.DEBUG_INT:
				return IStatus.INFO;

			case Level.INFO_INT:
				return IStatus.INFO;

			case Level.WARN_INT:
				return IStatus.WARNING;

			case Level.ERROR_INT:
				return IStatus.ERROR;

			case Level.FATAL_INT:
				return IStatus.ERROR;

			default:
				return IStatus.INFO;
		}
	}

	private ILog getLog(String loggerName) {
		ILog log = loggerMap.get(loggerName);
		if (log == null) {
			Bundle myBundle = getBundle(loggerName);
			if (myBundle != null) {
				log = Platform.getLog(myBundle);
				loggerMap.put(loggerName, log);
			}
		}
		return log;
	}

	public void initializeMappings() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElementsFor = extensionRegistry
				.getConfigurationElementsFor("org.eclipse.xtext.logging.loggermap");
		for (IConfigurationElement configurationElement : configurationElementsFor) {
			String bundleID = configurationElement.getAttribute("bundleId");
			String loggername = configurationElement.getAttribute("loggername");

			mappings.add(new LoggerMapEntry(bundleID, loggername));
		}
	}

	private Bundle getBundle(String loggerName) {
		Bundle bundle = bundleMap.get(loggerName);
		if (bundle == null) {
			for (LoggerMapEntry loggerMapEntry : mappings) {
				if (loggerMapEntry.matches(loggerName)) {
					String bundleName = loggerMapEntry.getBundleId();
					bundle = Platform.getBundle(bundleName);
					if (bundle != null) {
						bundleMap.put(loggerName, bundle);
					}
				}
			}
		}
		return bundle;
	}

	private IStatus createStatus(int severity, String loggerName, String message) {
		return createStatus(severity, loggerName, message, null);
	}

	private IStatus createStatus(int severity, String loggerName, String message, Throwable throwable) {
		return new Status(severity, getBundle(loggerName).getSymbolicName(), message, throwable);
	}

	public void close() {
	}

	public boolean requiresLayout() {
		return true;
	}

}
