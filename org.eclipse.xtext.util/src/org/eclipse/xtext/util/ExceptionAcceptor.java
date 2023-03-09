/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.apache.log4j.Logger;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public enum ExceptionAcceptor implements IAcceptor<Exception> {
	LOGGING {
		private final Logger LOG = Logger.getLogger(ExceptionAcceptor.class);

		@Override
		public void accept(Exception t) {
			LOG.error(t.getMessage(), t);
		}
	},
	THROWING {
		@Override
		public void accept(Exception t) {
			Exceptions.throwUncheckedException(t);
		}
	},
	IGNORING {
		@Override
		public void accept(Exception t) {
		}
	};

}
