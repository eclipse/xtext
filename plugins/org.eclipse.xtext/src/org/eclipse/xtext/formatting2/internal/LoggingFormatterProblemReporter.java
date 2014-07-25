/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.apache.log4j.Logger;
import org.eclipse.xtext.util.IAcceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class LoggingFormatterProblemReporter implements IAcceptor<Exception> {

	private final Logger LOG = Logger.getLogger(LoggingFormatterProblemReporter.class);

	public void accept(Exception t) {
		LOG.error(t.getMessage(), t);
	}

}
