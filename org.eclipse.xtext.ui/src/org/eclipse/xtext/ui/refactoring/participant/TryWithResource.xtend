/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.participant

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