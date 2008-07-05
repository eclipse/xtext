/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.service.IFormatter;
import org.eclipse.xtext.ui.service.impl.BuiltInFormatter;
import org.eclipse.xtext.ui.service.impl.BuiltInTokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextFormatter extends BuiltInFormatter implements IFormatter {
	@Override
	protected boolean shouldIndent(AbstractNode node) {
		return super.shouldIndent(node);
	}

	@Override
	protected String before(LeafNode leafNode) {
		if (")".equals(leafNode.getText()) || "?=".equals(leafNode.getText()) || ".".equals(leafNode.getText()))
			return EMPTY_STRING;
		else if ("ParserRule".equals(getGrammarRuleName(leafNode.getParent()))
				&& "ID".equals(getGrammarRuleName(leafNode)))
			return NEW_LINE + NEW_LINE;
		else if (new BuiltInTokenTypeDef().mlCommentTokenType().match(leafNode)
				|| "language".equals(leafNode.getText()) || "generate".equals(leafNode.getText()))
			return NEW_LINE;

		LeafNode pLeafNode = previousNode();
		if (pLeafNode != null) {
			if ("(".equals(pLeafNode.getText()) || ".".equals(pLeafNode.getText())) {
				return EMPTY_STRING;
			}
		}
		return SPACE;
	}

	@Override
	protected String after(LeafNode leafNode) {
		if (":".equals(leafNode.getText()))
			return NEW_LINE + TAB;
		return super.after(leafNode);
	}

	private String getGrammarRuleName(AbstractNode leafNode) {
		EObject grammarElement = leafNode.getGrammarElement();
		if (grammarElement instanceof RuleCall) {
			return ((RuleCall) grammarElement).getName();
		}
		return EMPTY_STRING;
	}
}
