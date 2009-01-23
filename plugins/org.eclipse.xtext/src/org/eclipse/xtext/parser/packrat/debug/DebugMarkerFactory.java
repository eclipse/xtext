/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import org.apache.log4j.Logger;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugMarkerFactory implements IMarkerFactory {

	private static final Logger log = Logger.getLogger(DebugMarkerFactory.class);
	
	private final IMarkerFactory delegate;
	
	public DebugMarkerFactory(IMarkerFactory delegate) {
		this.delegate = delegate;
	}
	
	public IMarker mark() {
		if (log.isDebugEnabled()) {
			log.debug("mark()");
		}
		IMarker result = delegate.mark();
		if (log.isDebugEnabled()) {
			log.debug("mark() = " + result);
		}
		return new DebuggingMarker(result);
	}
	
	private static class DebuggingMarker implements IMarker {
		
		private final IMarker delegate;
		
		public DebuggingMarker(IMarker delegate) {
			this.delegate = delegate;
		}

		public void rollback() {
			if (log.isDebugEnabled()) {
				log.debug("rollback(" + delegate + ")");
			}
			delegate.rollback();
		}

		public void release() {
			if (log.isDebugEnabled()) {
				log.debug("release(" + delegate + ")");
			}
			delegate.release();
		}

		public IMarker copy() {
			if (log.isDebugEnabled()) {
				log.debug("copy(" + delegate + ")");
			}
			return new DebuggingMarker(delegate.copy());
		}

		public void discard() {
			if (log.isDebugEnabled()) {
				log.debug("discard(" + delegate + ")");
			}
			delegate.discard();
		}

		public void activate() {
			if (log.isDebugEnabled()) {
				log.debug("activate(" + delegate + ")");
			}
			delegate.activate();
		}
		
	}

}
