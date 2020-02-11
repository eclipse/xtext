/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.Group;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GroupToken extends CompoundParsedToken {

	public GroupToken(int offset, Group group, IParsedTokenSource origin, boolean optional) {
		super(offset, group, origin, optional);
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitGroupToken(this);
	}

	@Override
	public Group getGrammarElement() {
		return (Group) super.getGrammarElement();
	}

	public static class End extends CompoundParsedToken.End {

		public End(int offset) {
			super(offset);
		}

		@Override
		public void accept(IParsedTokenVisitor visitor) {
			visitor.visitGroupTokenEnd(this);
		}

	}

}
