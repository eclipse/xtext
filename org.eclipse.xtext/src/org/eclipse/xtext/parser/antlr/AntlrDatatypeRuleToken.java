/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
		if (token != null)
			internalMerge(token.getText(), TokenTool.getOffset(token));
	}
	
}
