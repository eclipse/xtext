/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.enumrules.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.enumrules.ide.contentassist.antlr.internal.InternalEnumRulesUiTestLanguageParser;
import org.eclipse.xtext.ui.tests.enumrules.services.EnumRulesUiTestLanguageGrammarAccess;

public class EnumRulesUiTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(EnumRulesUiTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, EnumRulesUiTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			mappings.put(grammarAccess.getExistingEnumAccess().getAlternatives(), "rule__ExistingEnum__Alternatives");
			mappings.put(grammarAccess.getGeneratedEnumAccess().getAlternatives(), "rule__GeneratedEnum__Alternatives");
			mappings.put(grammarAccess.getModelAccess().getGroup_0(), "rule__Model__Group_0__0");
			mappings.put(grammarAccess.getModelAccess().getGroup_0_2(), "rule__Model__Group_0_2__0");
			mappings.put(grammarAccess.getModelAccess().getGroup_1(), "rule__Model__Group_1__0");
			mappings.put(grammarAccess.getModelAccess().getExistingAssignment_0_1(), "rule__Model__ExistingAssignment_0_1");
			mappings.put(grammarAccess.getModelAccess().getGeneratedAssignment_0_2_1(), "rule__Model__GeneratedAssignment_0_2_1");
			mappings.put(grammarAccess.getModelAccess().getGeneratedAssignment_1_1(), "rule__Model__GeneratedAssignment_1_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private EnumRulesUiTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalEnumRulesUiTestLanguageParser createParser() {
		InternalEnumRulesUiTestLanguageParser result = new InternalEnumRulesUiTestLanguageParser(null);
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

	public EnumRulesUiTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(EnumRulesUiTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
