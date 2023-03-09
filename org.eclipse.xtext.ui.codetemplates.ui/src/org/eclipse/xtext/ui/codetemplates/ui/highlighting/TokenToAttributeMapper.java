/*******************************************************************************
 * Copyright (c) 2008,2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.highlighting;

import java.util.Set;

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

import com.google.common.collect.ImmutableSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TokenToAttributeMapper extends DefaultAntlrTokenToAttributeIdMapper {

	private final Set<String> keywords = ImmutableSet.of(
			"KEYWORD_TEMPLATES",
			"KEYWORD_FOR");

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if (keywords.contains(tokenName)) {
			return HighlightingStyles.KEYWORD_ID;
		}
		if (tokenName.startsWith("KEYWORD_"))
			return HighlightingStyles.PUNCTUATION_ID;
		if (tokenName.equals("RULE_BODY"))
			return TemplatesHighlightingConfiguration.TEMPLATE_BODY;
		return super.calculateId(tokenName, tokenType);
	}

}
