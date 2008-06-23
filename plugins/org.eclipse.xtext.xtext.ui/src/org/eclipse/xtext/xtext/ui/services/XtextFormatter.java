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
import org.eclipse.xtext.ui.service.IFormatterService;
import org.eclipse.xtext.ui.service.impl.BuildInFormatterService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextFormatter extends BuildInFormatterService implements IFormatterService {

	private static final String TAB = "\t";
	private static final String WRAPPER = System.getProperty("line.separator");

	@Override
	public boolean shouldIndent(AbstractNode node) {
		return super.shouldIndent(node);
	}

	@Override
	public String before(LeafNode leafNode) {
		if ("?=".equals(leafNode.getText()) || ".".equals(leafNode.getText()))
			return new String();
		if ("language".equals(leafNode.getText()) || "generate".equals(leafNode.getText())
				|| "ParserRule".equals(getGrammarRuleName(leafNode.getParent()))
				&& "ID".equals(getGrammarRuleName(leafNode))) {
			return WRAPPER;
		}
		LeafNode previous = previousNode(leafNode, false);
		if (previous != null) {
			if (":".equals(previous.getText())) {
				return WRAPPER + TAB;
			}
			else if (".".equals(previous.getText())) {
				return new String();
			}
		}

		return " ";
	}

	private String getGrammarRuleName(AbstractNode leafNode) {
		EObject grammarElement = leafNode.getGrammarElement();
		if (grammarElement instanceof RuleCall) {
			return ((RuleCall) grammarElement).getName();
		}
		return "";
	}
}
