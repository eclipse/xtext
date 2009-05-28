/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr;

import java.util.regex.Pattern;

import org.eclipse.xtext.ui.common.editor.syntaxcoloring.CommonTokenStyles;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ITokenStyle;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AbstractAntlrTokenColorer;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class CommonAntlrTokenColorer extends AbstractAntlrTokenColorer {

	private static final Pattern QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
	
	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
	
	@Override
	protected ITokenStyle deriveTokenStyle(String antlrTokenId) {
		if(PUNCTUATION.matcher(antlrTokenId).matches()) {
			return CommonTokenStyles.PUNCTUATION;
		} 
		if(QUOTED.matcher(antlrTokenId).matches()) {
			return CommonTokenStyles.KEYWORD;
		}
		if("RULE_STRING".equals(antlrTokenId)) {
			return CommonTokenStyles.STRING;
		} 
		if("RULE_INT".equals(antlrTokenId)) {
			return CommonTokenStyles.NUMBER;
		}
		if("RULE_ML_COMMENT".equals(antlrTokenId) | "RULE_SL_COMMENT".equals(antlrTokenId)) {
			return CommonTokenStyles.COMMENT;
		}
		return CommonTokenStyles.DEFAULT;
	}

}
