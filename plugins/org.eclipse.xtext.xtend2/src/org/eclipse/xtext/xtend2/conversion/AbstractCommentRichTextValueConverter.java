/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.conversion;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractCommentRichTextValueConverter extends AbstractRichTextValueConverter {

	@Override
	protected String getLeadingTerminal() {
		return "\u00AB\u00AB";
	}
	
	@Override
	protected String toEscapedString(String value) {
		return super.toEscapedString("\n" + value);
	}
	
	@Override
	protected String getWithoutLeadingTerminal(String string) {
		int lineBreak = string.indexOf('\n');
		if (lineBreak == -1 || lineBreak == string.length() - 1)
			return "";
		return string.substring(lineBreak + 1);
	}

}

