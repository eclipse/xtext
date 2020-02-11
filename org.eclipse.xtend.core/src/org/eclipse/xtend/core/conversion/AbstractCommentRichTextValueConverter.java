/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.conversion;

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
		// TODO: Is this the correct line separator? 
		return super.toEscapedString("\n" + value);
	}
	
	@Override
	protected String getWithoutLeadingTerminal(String string) {
		int lineBreak = Math.max(string.indexOf('\n'), string.indexOf('\r'));
		if (lineBreak == -1 || lineBreak == string.length() - 1)
			return "";
		return string.substring(lineBreak + 1);
	}

}

