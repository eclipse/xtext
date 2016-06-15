/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import org.antlr.runtime.Token;
import org.eclipse.xtext.AbstractElement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class LookAheadTerminal {

	private Token token;
	
	public abstract boolean matches(AbstractElement element);
	
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
