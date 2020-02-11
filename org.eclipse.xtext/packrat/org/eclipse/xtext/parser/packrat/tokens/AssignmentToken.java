/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AssignmentToken extends CompoundParsedToken {

	public AssignmentToken(int offset, Assignment grammarElement, IParsedTokenSource origin, boolean optional) {
		super(offset, grammarElement, origin, optional);
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitAssignmentToken(this);
	}

	@Override
	public Assignment getGrammarElement() {
		return (Assignment) super.getGrammarElement();
	}

	public static class End extends CompoundParsedToken.End {
		public End(int offset) {
			super(offset);
		}

		@Override
		public void accept(IParsedTokenVisitor visitor) {
			visitor.visitAssignmentTokenEnd(this);
		}
	}

}
