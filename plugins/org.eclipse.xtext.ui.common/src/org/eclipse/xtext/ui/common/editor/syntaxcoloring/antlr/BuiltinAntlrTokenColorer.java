/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr;

import java.util.regex.Pattern;

import org.eclipse.xtext.ui.common.editor.syntaxcoloring.BuiltinTokenStyles;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ITokenStyle;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AbstractAntlrTokenColorer;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class BuiltinAntlrTokenColorer extends AbstractAntlrTokenColorer {

	private static final Pattern QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
	
	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
	
	@Override
	protected ITokenStyle deriveTokenStyle(String antlrTokenId) {
		if(PUNCTUATION.matcher(antlrTokenId).matches()) {
			return BuiltinTokenStyles.PUNCTUATION;
		} 
		if(QUOTED.matcher(antlrTokenId).matches()) {
			return BuiltinTokenStyles.KEYWORD;
		}
		if("RULE_STRING".equals(antlrTokenId)) {
			return BuiltinTokenStyles.STRING;
		} 
		if("RULE_INT".equals(antlrTokenId)) {
			return BuiltinTokenStyles.NUMBER;
		}
		if("RULE_ML_COMMENT".equals(antlrTokenId) | "RULE_SL_COMMENT".equals(antlrTokenId)) {
			return BuiltinTokenStyles.COMMENT;
		}
		return BuiltinTokenStyles.DEFAULT;
	}

}
