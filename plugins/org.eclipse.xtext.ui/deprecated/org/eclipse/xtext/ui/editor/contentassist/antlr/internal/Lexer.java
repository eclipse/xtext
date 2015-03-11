/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr.internal;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognizerSharedState;
import org.apache.log4j.Logger;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class Lexer extends org.antlr.runtime.Lexer {

	private static final Logger logger = Logger.getLogger(Lexer.class);
	
	protected Lexer(CharStream input) {
		super(input);
	}

	protected Lexer() {
		super();
	}
	
	protected Lexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
	}
	
	@Override
	public void emitErrorMessage(String msg) {
		// don't call super, since it would do a plain vanilla
		// System.err.println(msg);
		if (logger.isTraceEnabled())
			logger.trace(msg);
	}
	
}
