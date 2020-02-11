/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
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
public class PlaceholderToken extends ParsedToken {

	public PlaceholderToken(int offset, EObject grammarElement, IParsedTokenSource origin, boolean optional) {
		super(offset, 0, grammarElement, origin, optional);
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitPlaceholder(this);
	}

}
