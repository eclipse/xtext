/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal.InternalIndentationAwareUiTestLanguageParser;
import org.eclipse.xtext.ide.tests.testlanguage.services.IndentationAwareUiTestLanguageGrammarAccess;

public class IndentationAwareUiTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(IndentationAwareUiTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, IndentationAwareUiTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getTreeAccess().getGroup(), "rule__Tree__Group__0");
			builder.put(grammarAccess.getTreeNodeAccess().getGroup(), "rule__TreeNode__Group__0");
			builder.put(grammarAccess.getTreeNodeAccess().getGroup_1(), "rule__TreeNode__Group_1__0");
			builder.put(grammarAccess.getOtherTreeNodeAccess().getGroup(), "rule__OtherTreeNode__Group__0");
			builder.put(grammarAccess.getChildListAccess().getGroup(), "rule__ChildList__Group__0");
			builder.put(grammarAccess.getTreeAccess().getNodesAssignment_1(), "rule__Tree__NodesAssignment_1");
			builder.put(grammarAccess.getTreeAccess().getMoreNodesAssignment_2(), "rule__Tree__MoreNodesAssignment_2");
			builder.put(grammarAccess.getTreeNodeAccess().getNameAssignment_0(), "rule__TreeNode__NameAssignment_0");
			builder.put(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_1(), "rule__TreeNode__ChildrenAssignment_1_1");
			builder.put(grammarAccess.getOtherTreeNodeAccess().getNameAssignment_0(), "rule__OtherTreeNode__NameAssignment_0");
			builder.put(grammarAccess.getOtherTreeNodeAccess().getChildListAssignment_1(), "rule__OtherTreeNode__ChildListAssignment_1");
			builder.put(grammarAccess.getChildListAccess().getChildrenAssignment_2(), "rule__ChildList__ChildrenAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private IndentationAwareUiTestLanguageGrammarAccess grammarAccess;

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
		return nameMappings.getRuleName(element);
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
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
