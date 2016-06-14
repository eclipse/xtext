/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.common.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {
	
	static val RICH_TEXT_TERMINAL_RULE_NAMES = #{
		'RULE_RICH_TEXT',
		'RULE_RICH_TEXT_START',
		'RULE_RICH_TEXT_END',
		'RULE_RICH_TEXT_INBETWEEN'
	} 
	
	override protected calculateId(String tokenName, int tokenType) {
		if(RICH_TEXT_TERMINAL_RULE_NAMES.contains(tokenName))
			XtendHighlightingStyles.RICH_TEXT_ID
		else
		 	super.calculateId(tokenName, tokenType)
	}
}
