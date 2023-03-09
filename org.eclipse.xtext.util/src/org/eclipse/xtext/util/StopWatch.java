/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.apache.log4j.Logger;

/**
 * @noextend This class is not intended to be subclassed by clients.
 */
public class StopWatch {
	private final static Logger logger = Logger.getLogger(StopWatch.class);

	private long start = System.currentTimeMillis();

	private final Logger myLogger;
	
	public StopWatch() {
		this(logger);
	}
	
	/**
	 * @since 2.0
	 */
	public StopWatch(Logger logger) {
		this.myLogger = logger;
	}
	
	public long reset() {
		long now = System.currentTimeMillis();
		try {
			return now - start;
		} finally {
			start = now;
		}
	}

	public void resetAndLog(String label) {
		if (myLogger.isInfoEnabled())
			myLogger.info(label + ": " + reset() + "ms");
	}
}
