/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class CompoundParsedToken extends ParsedToken {

	protected CompoundParsedToken(int offset, AbstractElement grammarElement, IParsedTokenSource origin, boolean optional) {
		super(offset, 0, grammarElement, origin, optional);
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitCompoundParsedToken(this);
	}

	@Override
	public AbstractElement getGrammarElement() {
		return (AbstractElement) super.getGrammarElement();
	}

	public static class End extends AbstractParsedToken.End {

		public End(int offset) {
			super(offset);
		}

		@Override
		public void accept(IParsedTokenVisitor visitor) {
			visitor.visitCompoundParsedTokenEnd(this);
		}
	}


}
