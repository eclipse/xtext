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
public class ParsedTerminalWithFeatureInfo extends ParsedTerminal {

	private final String feature;

	public ParsedTerminalWithFeatureInfo(int offset, int length, EObject grammarElement,
			boolean hidden, String feature, IParsedTokenSource origin, boolean optional) {
		super(offset, length, grammarElement, hidden, origin, optional);
		this.feature = feature;
	}

	public String getFeature() {
		return feature;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedTerminalWithFeatureInfo(this);
	}

}
