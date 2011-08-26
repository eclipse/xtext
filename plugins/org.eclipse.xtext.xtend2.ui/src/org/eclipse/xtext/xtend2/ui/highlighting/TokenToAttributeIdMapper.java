/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.highlighting;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class TokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if(
			"RULE_RICH_TEXT".equals(tokenName) || 
			"RULE_RICH_TEXT_START".equals(tokenName) ||
			"RULE_RICH_TEXT_END".equals(tokenName) ||
			"RULE_RICH_TEXT_INBETWEEN".equals(tokenName) ||
			"RULE_COMMENT_RICH_TEXT_END".equals(tokenName) ||
			"RULE_COMMENT_RICH_TEXT_INBETWEEN".equals(tokenName)) {
			return HighlightingConfiguration.RICH_TEXT_ID;
		}
		return super.calculateId(tokenName, tokenType);
	}
}
