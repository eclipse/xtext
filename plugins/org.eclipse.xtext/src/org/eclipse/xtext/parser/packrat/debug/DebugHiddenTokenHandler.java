/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugHiddenTokenHandler implements IHiddenTokenHandler {

	private static final Logger log = Logger.getLogger(DebugHiddenTokenHandler.class);
	
	private final IHiddenTokenHandler delegate;

	public DebugHiddenTokenHandler(IHiddenTokenHandler delegate) {
		this.delegate = delegate;
	}
	
	public IHiddenTokenState replaceHiddenTokens(ITerminalConsumer... consumers) {
		if (log.isDebugEnabled()) {
			log.debug("replaceHiddenTokens(" + Arrays.toString(consumers) + ")");
		}
		IHiddenTokenState result = delegate.replaceHiddenTokens(consumers);
		if (log.isDebugEnabled()) {
			log.debug("replaceHiddenTokens(..) = " + result);
		}
		return new DebuggingHiddenTokenState(result);
	}
	
	private static class DebuggingHiddenTokenState implements IHiddenTokenState {

		private final IHiddenTokenState delegate;

		public DebuggingHiddenTokenState(IHiddenTokenState delegate) {
			this.delegate = delegate;
		}
		
		public void restore() {
			if (log.isDebugEnabled()) {
				log.debug("restore(" + delegate + ")");
			}
			delegate.restore();
		}
		
	}

}
