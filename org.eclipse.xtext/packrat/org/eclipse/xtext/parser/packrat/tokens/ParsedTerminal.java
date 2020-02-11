/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedTerminal extends ParsedToken {

	private final boolean hidden;

	public ParsedTerminal(int offset, int length, EObject grammarElement, boolean hidden, IParsedTokenSource origin, boolean optional) {
		super(offset, length, grammarElement, origin, optional);
		this.hidden = hidden;
	}

	public boolean isHidden() {
		return hidden;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedTerminal(this);
	}

	@Override
	public CharSequence getText(CharSequence input) {
		CharSequence result = super.getText(input);
		if (getGrammarElement() instanceof Keyword)
			return result.toString();
		return result;
	}

}
