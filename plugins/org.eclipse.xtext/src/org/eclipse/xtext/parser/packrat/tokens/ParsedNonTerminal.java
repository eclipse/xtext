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
public class ParsedNonTerminal extends ParsedToken {

	private final String typeName;

	public ParsedNonTerminal(int offset, EObject grammarElement, String typeName) {
		super(offset, 0, grammarElement);
		this.typeName = typeName;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedNonTerminal(this);
	}

	public String getTypeName() {
		return typeName;
	}

}
