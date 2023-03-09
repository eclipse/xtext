/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedNonTerminalEnd extends AbstractParsedToken.End {

	private final String feature;
	private final boolean isMany;
	private final boolean isDatatype;
	private final boolean isBoolean;

	public ParsedNonTerminalEnd(int offset, String feature, boolean isMany, boolean isDatatype, boolean isBoolean) {
		super(offset);
		this.feature = feature;
		this.isMany = isMany;
		this.isDatatype = isDatatype;
		this.isBoolean = isBoolean;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedNonTerminalEnd(this);
	}

	public String getFeature() {
		return feature;
	}

	public boolean isMany() {
		return isMany;
	}

	public boolean isDatatype() {
		return isDatatype;
	}

	public boolean isBoolean() {
		return isBoolean;
	}

}
