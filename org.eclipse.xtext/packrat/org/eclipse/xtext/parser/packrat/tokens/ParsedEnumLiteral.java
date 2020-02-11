/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedEnumLiteral extends ParsedToken {

	public ParsedEnumLiteral(int offset, int length, EnumLiteralDeclaration literal, IParsedTokenSource source, boolean optional) {
		super(offset, length, literal, source, optional);
	}

	@Override
	public EnumLiteralDeclaration getGrammarElement() {
		return (EnumLiteralDeclaration) super.getGrammarElement();
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedEnumLiteral(this);
	}

}
