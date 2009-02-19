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
public class AlternativesToken extends ParsedToken {

	public AlternativesToken(int offset, Alternatives alternatives) {
		super(offset, 0, alternatives);
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		// nothing to do so far
	}

	public static class End extends AbstractParsedToken.End {
		public End(int offset) {
			super(offset);
		}
	}

}
