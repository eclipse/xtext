/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokens;

import java.util.regex.Pattern;

import org.eclipse.xtext.ui.common.editor.syntaxcoloring.AbstractAntlrTokenColorer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ITokenStyle;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class BuiltinTokenColorer extends AbstractAntlrTokenColorer {

	private static final Pattern QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
	
	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype.AbstractTokenTypeResolver#deriveTokenType(java.lang.String)
	 */
	@Override
	protected ITokenStyle deriveTokenStyle(String antlrTokenDef) {
		if(PUNCTUATION.matcher(antlrTokenDef).matches()) {
			return BuiltinTokenStyles.PUNCTUATION;
		} 
		if(QUOTED.matcher(antlrTokenDef).matches()) {
			return BuiltinTokenStyles.KEYWORD;
		}
		if("RULE_STRING".equals(antlrTokenDef) || "RULE_ID".equals(antlrTokenDef)) {
			return BuiltinTokenStyles.STRING;
		} 
		if("RULE_INT".equals(antlrTokenDef)) {
			return BuiltinTokenStyles.NUMBER;
		}
		if("RULE_ML_COMMENT".equals(antlrTokenDef) | "RULE_SL_COMMENT".equals(antlrTokenDef)) {
			return BuiltinTokenStyles.COMMENT;
		}
		return BuiltinTokenStyles.DEFAULT;
	}

}
