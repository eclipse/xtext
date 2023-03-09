/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import org.antlr.runtime.Token;
import org.eclipse.xtext.AbstractElement;

/**
 * @since 2.9
 */
public abstract class LookAheadTerminal implements ILookAheadTerminal {

	private Token token;
	
	public abstract boolean matches(AbstractElement element);
	
	@Override
	public Token getToken() {
		return token;
	}
	
	public void setToken(Token token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "LookAheadTerminal: " + token.toString();
	}
}
