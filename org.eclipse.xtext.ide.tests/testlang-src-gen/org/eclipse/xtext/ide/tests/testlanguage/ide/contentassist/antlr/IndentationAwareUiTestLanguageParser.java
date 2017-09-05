/*
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal.InternalIndentationAwareUiTestLanguageParser;
import org.eclipse.xtext.ide.tests.testlanguage.services.IndentationAwareUiTestLanguageGrammarAccess;

public class IndentationAwareUiTestLanguageParser extends AbstractContentAssistParser {

	@Inject
	private IndentationAwareUiTestLanguageGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalIndentationAwareUiTestLanguageParser createParser() {
		InternalIndentationAwareUiTestLanguageParser result = new InternalIndentationAwareUiTestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected TokenSource createLexer(CharStream stream) {
		return new IndentationAwareUiTestLanguageTokenSource(super.createLexer(stream));
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getTreeAccess().getGroup(), "rule__Tree__Group__0");
					put(grammarAccess.getTreeNodeAccess().getGroup(), "rule__TreeNode__Group__0");
					put(grammarAccess.getTreeNodeAccess().getGroup_1(), "rule__TreeNode__Group_1__0");
					put(grammarAccess.getOtherTreeNodeAccess().getGroup(), "rule__OtherTreeNode__Group__0");
					put(grammarAccess.getChildListAccess().getGroup(), "rule__ChildList__Group__0");
					put(grammarAccess.getTreeAccess().getNodesAssignment_1(), "rule__Tree__NodesAssignment_1");
					put(grammarAccess.getTreeAccess().getMoreNodesAssignment_2(), "rule__Tree__MoreNodesAssignment_2");
					put(grammarAccess.getTreeNodeAccess().getNameAssignment_0(), "rule__TreeNode__NameAssignment_0");
					put(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_1(), "rule__TreeNode__ChildrenAssignment_1_1");
					put(grammarAccess.getOtherTreeNodeAccess().getNameAssignment_0(), "rule__OtherTreeNode__NameAssignment_0");
					put(grammarAccess.getOtherTreeNodeAccess().getChildListAssignment_1(), "rule__OtherTreeNode__ChildListAssignment_1");
					put(grammarAccess.getChildListAccess().getChildrenAssignment_2(), "rule__ChildList__ChildrenAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public IndentationAwareUiTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(IndentationAwareUiTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
