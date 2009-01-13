/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.impl.DatatypeRuleToken;

/**
 * <p>Return value of data type rules of the antlr parser.</p>
 * <p>In addition to DatatypeRuleTokens AntlrDatatypeRuleToken can be merged 
 * with {@link org.antlr.runtime.Token}s.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrDatatypeRuleToken extends DatatypeRuleToken {

	public AntlrDatatypeRuleToken() {
		super();
	}
	
	public void merge(Token token) {
		internalMerge(token.getText(), TokenTool.getOffset(token));
	}
	
}
