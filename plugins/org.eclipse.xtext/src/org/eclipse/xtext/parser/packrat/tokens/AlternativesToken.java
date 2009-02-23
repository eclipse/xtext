/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AlternativesToken extends CompoundParsedToken {

	public AlternativesToken(int offset, Alternatives alternatives) {
		super(offset, alternatives);
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitAlternativesToken(this);
	}

	@Override
	public Alternatives getGrammarElement() {
		return (Alternatives) super.getGrammarElement();
	}

	public static class End extends CompoundParsedToken.End {
		private final int alternative;

		public End(int offset, int alternative) {
			super(offset);
			this.alternative = alternative;
		}

		public int getAlternative() {
			return alternative;
		}

		@Override
		public void accept(IParsedTokenVisitor visitor) {
			visitor.visitAlternativesTokenEnd(this);
		}
	}

}
