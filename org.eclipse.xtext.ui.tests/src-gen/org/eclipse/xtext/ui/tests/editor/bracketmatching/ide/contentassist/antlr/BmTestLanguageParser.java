/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.bracketmatching.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.editor.bracketmatching.ide.contentassist.antlr.internal.InternalBmTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.bracketmatching.services.BmTestLanguageGrammarAccess;

public class BmTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(BmTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, BmTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
			builder.put(grammarAccess.getSExpressionAccess().getAlternatives_1(), "rule__SExpression__Alternatives_1");
			builder.put(grammarAccess.getVALUEAccess().getAlternatives(), "rule__VALUE__Alternatives");
			builder.put(grammarAccess.getExpressionAccess().getGroup_2(), "rule__Expression__Group_2__0");
			builder.put(grammarAccess.getSExpressionAccess().getGroup(), "rule__SExpression__Group__0");
			builder.put(grammarAccess.getSExpressionAccess().getGroup_1_0(), "rule__SExpression__Group_1_0__0");
			builder.put(grammarAccess.getSExpressionAccess().getGroup_1_1(), "rule__SExpression__Group_1_1__0");
			builder.put(grammarAccess.getFileAccess().getExpressionAssignment(), "rule__File__ExpressionAssignment");
			builder.put(grammarAccess.getSExpressionAccess().getElementAssignment_1_0_1(), "rule__SExpression__ElementAssignment_1_0_1");
			builder.put(grammarAccess.getSExpressionAccess().getElementAssignment_1_1_1(), "rule__SExpression__ElementAssignment_1_1_1");
			builder.put(grammarAccess.getAtomAccess().getValueAssignment(), "rule__Atom__ValueAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private BmTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBmTestLanguageParser createParser() {
		InternalBmTestLanguageParser result = new InternalBmTestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public BmTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(BmTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
