/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedTerminal extends ParsedToken {

	private final boolean hidden;
	private final String feature;
	private final boolean isMany;
	private final boolean isBoolean;
	private final String lexerRule;

	public ParsedTerminal(CharSequence input, int offset, int length, EObject grammarElement, 
			String feature, boolean hidden, boolean isMany, boolean isBoolean, String lexerRule) {
		super(input, offset, length, grammarElement);
		this.feature = feature;
		this.hidden = hidden;
		this.isMany = isMany;
		this.isBoolean = isBoolean;
		this.lexerRule = lexerRule;
	}

	public boolean isHidden() {
		return hidden;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedTerminal(this);
	}

	public String getFeature() {
		return feature;
	}

	public boolean isMany() {
		return isMany;
	}

	public boolean isBoolean() {
		return isBoolean;
	}

	public String getLexerRule() {
		return lexerRule;
	}

}
