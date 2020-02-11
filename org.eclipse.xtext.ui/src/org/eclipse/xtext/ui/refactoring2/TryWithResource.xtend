/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring2

import java.io.Closeable
import org.apache.log4j.Logger

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class TryWithResource {
	
	static val LOG = Logger.getLogger(TryWithResource)
	
	static def <T> T tryWith(Closeable closeable, ()=>T action) {
		try {
			action.apply()
		} finally {
			try {
				closeable.close
			} catch (Throwable t) {
				LOG.error('Error closing stream', t)
			}
		}
	}

	static def void tryWith(Closeable closeable, ()=>void action) {
		try {
			action.apply()
		} finally {
			try {
				closeable.close
			} catch (Throwable t) {
				LOG.error('Error closing stream', t)
			}
		}
	}
}
