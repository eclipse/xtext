/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.internal.IFurtherParsable;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AlternativesToken extends CompoundParsedToken implements IFurtherParsable<AlternativesToken> {

	private int alternative;
	private final int totalAlternatives;

	public AlternativesToken(int offset, Alternatives alternatives, Source<AlternativesToken> origin, boolean optional, int totalAlternatives) {
		super(offset, alternatives, origin, optional);
		this.totalAlternatives = totalAlternatives;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitAlternativesToken(this);
	}

	@Override
	public Alternatives getGrammarElement() {
		return (Alternatives) super.getGrammarElement();
	}

	public void setAlternative(int alternative) {
		this.alternative = alternative;
	}

	public int getAlternative() {
		return alternative;
	}

	@Override
	public AlternativesToken getToken() {
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Source<AlternativesToken> getSource() {
		return (Source<AlternativesToken>) super.getSource();
	}

	@Override
	public boolean canParseFurther() {
		return alternative < totalAlternatives - 1;
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
