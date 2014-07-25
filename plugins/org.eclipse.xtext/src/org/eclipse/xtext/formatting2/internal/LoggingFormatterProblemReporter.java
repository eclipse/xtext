/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.apache.log4j.Logger;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class LoggingFormatterProblemReporter extends VerboseFormatterProblemReporter {

	private final Logger LOG = Logger.getLogger(LoggingFormatterProblemReporter.class);

	@Override
	protected void report(String message, Throwable cause) {
		if (cause == null)
			LOG.error(message);
		else
			LOG.error(message, cause);
	}

}
