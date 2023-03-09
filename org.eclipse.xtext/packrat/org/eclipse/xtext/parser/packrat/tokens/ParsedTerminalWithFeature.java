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
public class ParsedTerminalWithFeature extends ParsedTerminalWithFeatureInfo {

	private final boolean isMany;
	private final boolean isBoolean;
	private final String ruleName;

	public ParsedTerminalWithFeature(int offset, int length, EObject grammarElement,
			boolean hidden, String feature, boolean isMany, boolean isBoolean, String ruleName,
			IParsedTokenSource origin, boolean optional) {
		super(offset, length, grammarElement, hidden, feature, origin, optional);
		this.isMany = isMany;
		this.isBoolean = isBoolean;
		this.ruleName = ruleName;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedTerminalWithFeature(this);
	}

	public boolean isMany() {
		return isMany;
	}

	public boolean isBoolean() {
		return isBoolean;
	}

	public String getRuleName() {
		return ruleName;
	}

}
