/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedAction extends AbstractParsedToken {

	private final String typeName;

	private final String feature;

	private final boolean isMany;

	public ParsedAction(CharSequence input, int offset, String typeName, String feature, boolean isMany) {
		super(input, offset, 0);
		this.typeName = typeName;
		this.feature = feature;
		this.isMany = isMany;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedAction(this);
	}
	
	public String getTypeName() {
		return typeName;
	}

	public String getFeature() {
		return feature;
	}

	public boolean isMany() {
		return isMany;
	}
	
}
