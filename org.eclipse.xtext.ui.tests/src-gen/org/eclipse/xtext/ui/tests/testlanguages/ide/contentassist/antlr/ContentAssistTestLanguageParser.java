/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.testlanguages.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.testlanguages.ide.contentassist.antlr.internal.InternalContentAssistTestLanguageParser;
import org.eclipse.xtext.ui.tests.testlanguages.services.ContentAssistTestLanguageGrammarAccess;

public class ContentAssistTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ContentAssistTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ContentAssistTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getAbstractRuleAccess().getAlternatives(), "rule__AbstractRule__Alternatives");
			builder.put(grammarAccess.getStartAccess().getGroup(), "rule__Start__Group__0");
			builder.put(grammarAccess.getFirstAbstractRuleChildAccess().getGroup(), "rule__FirstAbstractRuleChild__Group__0");
			builder.put(grammarAccess.getSecondAbstractRuleChildAccess().getGroup(), "rule__SecondAbstractRuleChild__Group__0");
			builder.put(grammarAccess.getStartAccess().getRulesAssignment_1(), "rule__Start__RulesAssignment_1");
			builder.put(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0(), "rule__FirstAbstractRuleChild__NameAssignment_0");
			builder.put(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2(), "rule__FirstAbstractRuleChild__ElementsAssignment_2");
			builder.put(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0(), "rule__SecondAbstractRuleChild__NameAssignment_0");
			builder.put(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3(), "rule__SecondAbstractRuleChild__RuleAssignment_3");
			builder.put(grammarAccess.getAbstractRuleCallAccess().getRuleAssignment(), "rule__AbstractRuleCall__RuleAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ContentAssistTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalContentAssistTestLanguageParser createParser() {
		InternalContentAssistTestLanguageParser result = new InternalContentAssistTestLanguageParser(null);
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

	public ContentAssistTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ContentAssistTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
