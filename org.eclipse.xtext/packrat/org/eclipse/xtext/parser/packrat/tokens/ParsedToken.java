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
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedToken extends AbstractParsedToken {

	private final IParsedTokenSource source;

	private final EObject grammarElement;

	private final boolean optional;

	public ParsedToken(int offset, int length, EObject grammarElement, IParsedTokenSource source, boolean optional) {
		super(offset, length);
		this.grammarElement = grammarElement;
		this.source = source;
		this.optional = optional;
	}

	public EObject getGrammarElement() {
		return grammarElement;
	}

	public IParsedTokenSource getSource() {
		return source;
	}

	public boolean isOptional() {
		return optional;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedToken(this);
	}

}
