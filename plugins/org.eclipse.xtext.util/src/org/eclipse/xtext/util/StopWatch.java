/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.apache.log4j.Logger;

public class StopWatch {
	private final static Logger logger = Logger.getLogger(StopWatch.class);

	private long start = System.currentTimeMillis();

	public long reset() {
		long now = System.currentTimeMillis();
		try {
			return now - start;
		} finally {
			start = now;
		}
	}

	public void resetAndLog(String label) {
		if (logger.isInfoEnabled())
			logger.info(label + ": " + reset() + "ms");
	}
}
