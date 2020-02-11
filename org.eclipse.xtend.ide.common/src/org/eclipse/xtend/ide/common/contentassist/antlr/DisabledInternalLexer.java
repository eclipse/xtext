/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.contentassist.antlr;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendLexer;

/**
 * Just to make sure that we do not miss a call path.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DisabledInternalLexer extends InternalXtendLexer {

	public DisabledInternalLexer() {
	}

	public DisabledInternalLexer(CharStream input) {
		super(input);
	}
	
	public DisabledInternalLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
	}
	
	@Override
	public Token nextToken() {
		throw new IllegalStateException("Unexpected binding used");
	}

}
