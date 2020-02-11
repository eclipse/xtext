/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedAction extends ParsedToken {

	private final boolean isMany;

	public ParsedAction(int offset, Action action, boolean isMany, IParsedTokenSource source) {
		super(offset, 0, action, source, false);
		this.isMany = isMany;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitParsedAction(this);
	}

	@Override
	public Action getGrammarElement() {
		return (Action) super.getGrammarElement();
	}

	public EClassifier getType() {
		return getGrammarElement().getType().getClassifier();
	}

	public String getFeature() {
		return getGrammarElement().getFeature();
	}

	public boolean isMany() {
		return isMany;
	}

}
