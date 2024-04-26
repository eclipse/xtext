/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalParametersTestLanguageExParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ParametersTestLanguageExGrammarAccess;

public class ParametersTestLanguageExParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ParametersTestLanguageExGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, ParametersTestLanguageExGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1(), "superParserRuleParameters__Alternatives_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_8_1(), "superParserRuleParameters__Alternatives_1_8_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_9_1(), "superParserRuleParameters__Alternatives_1_9_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_10_1(), "superParserRuleParameters__Alternatives_1_10_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_11_1(), "superParserRuleParameters__Alternatives_1_11_1");
			mappings.put(grammarAccess.getScenario3Access().getAlternatives(), "rule__Scenario3__Alternatives");
			mappings.put(grammarAccess.getScenario5Access().getAlternatives(), "rule__Scenario5__Alternatives");
			mappings.put(grammarAccess.getIdOrKeywordAccess().getAlternatives(), "rule__IdOrKeyword__Alternatives");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup(), "superParserRuleParameters__Group__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_0(), "superParserRuleParameters__Group_1_0__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_1(), "superParserRuleParameters__Group_1_1__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_2(), "superParserRuleParameters__Group_1_2__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_3(), "superParserRuleParameters__Group_1_3__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_4(), "superParserRuleParameters__Group_1_4__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_4_0(), "superParserRuleParameters__Group_1_4_0__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_5(), "superParserRuleParameters__Group_1_5__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_5_0(), "superParserRuleParameters__Group_1_5_0__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_6(), "superParserRuleParameters__Group_1_6__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_7(), "superParserRuleParameters__Group_1_7__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_8(), "superParserRuleParameters__Group_1_8__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_8_1_1(), "superParserRuleParameters__Group_1_8_1_1__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_9(), "superParserRuleParameters__Group_1_9__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_9_1_1(), "superParserRuleParameters__Group_1_9_1_1__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_10(), "superParserRuleParameters__Group_1_10__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_10_1_1(), "superParserRuleParameters__Group_1_10_1_1__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_11(), "superParserRuleParameters__Group_1_11__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_11_1_1(), "superParserRuleParameters__Group_1_11_1_1__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_12(), "superParserRuleParameters__Group_1_12__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_13(), "superParserRuleParameters__Group_1_13__0");
			mappings.put(grammarAccess.getScenario4Access().getGroup(), "rule__Scenario4__Group__0");
			mappings.put(grammarAccess.getScenario5Access().getGroup_1(), "rule__Scenario5__Group_1__0");
			mappings.put(grammarAccess.getScenario5Access().getGroup_2(), "rule__Scenario5__Group_2__0");
			mappings.put(grammarAccess.getScenario5Access().getGroup_3(), "rule__Scenario5__Group_3__0");
			mappings.put(grammarAccess.getScenario5Access().getGroup_0(), "rule__Scenario5__Group_0__0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_0_1(), "superParserRuleParameters__ScenarioAssignment_1_0_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_1_1(), "superParserRuleParameters__ScenarioAssignment_1_1_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_2_1(), "superParserRuleParameters__ScenarioAssignment_1_2_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_3_1(), "superParserRuleParameters__ScenarioAssignment_1_3_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_4_0_1(), "superParserRuleParameters__ScenarioAssignment_1_4_0_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_5_0_1(), "superParserRuleParameters__ScenarioAssignment_1_5_0_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_6_1(), "superParserRuleParameters__ScenarioAssignment_1_6_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_7_1(), "superParserRuleParameters__ScenarioAssignment_1_7_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_8_1_0(), "superParserRuleParameters__ScenarioAssignment_1_8_1_0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_8_1_1_0(), "superParserRuleParameters__ScenarioAssignment_1_8_1_1_0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_9_1_0(), "superParserRuleParameters__ScenarioAssignment_1_9_1_0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_9_1_1_0(), "superParserRuleParameters__ScenarioAssignment_1_9_1_1_0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_10_1_0(), "superParserRuleParameters__ScenarioAssignment_1_10_1_0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_10_1_1_0(), "superParserRuleParameters__ScenarioAssignment_1_10_1_1_0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_11_1_0(), "superParserRuleParameters__ScenarioAssignment_1_11_1_0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_11_1_1_0(), "superParserRuleParameters__ScenarioAssignment_1_11_1_1_0");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_12_1(), "superParserRuleParameters__ScenarioAssignment_1_12_1");
			mappings.put(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_13_1(), "superParserRuleParameters__ScenarioAssignment_1_13_1");
			mappings.put(grammarAccess.getParametersTestLanguageScenario1Access().getSecondAssignment_1_0(), "superScenario1__SecondAssignment_1_0");
			mappings.put(grammarAccess.getParametersTestLanguageScenario1Access().getFirstAssignment_0_0(), "superScenario1__FirstAssignment_0_0");
			mappings.put(grammarAccess.getScenario2Access().getFirstAssignment(), "rule__Scenario2__FirstAssignment");
			mappings.put(grammarAccess.getScenario3Access().getFirstAssignment_0(), "rule__Scenario3__FirstAssignment_0");
			mappings.put(grammarAccess.getScenario3Access().getSecondAssignment_1(), "rule__Scenario3__SecondAssignment_1");
			mappings.put(grammarAccess.getScenario4Access().getSecondAssignment_0(), "rule__Scenario4__SecondAssignment_0");
			mappings.put(grammarAccess.getScenario5Access().getFirstAssignment_2_3(), "rule__Scenario5__FirstAssignment_2_3");
			mappings.put(grammarAccess.getScenario5Access().getSecondAssignment_2_4(), "rule__Scenario5__SecondAssignment_2_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ParametersTestLanguageExGrammarAccess grammarAccess;

	@Override
	protected InternalParametersTestLanguageExParser createParser() {
		InternalParametersTestLanguageExParser result = new InternalParametersTestLanguageExParser(null);
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

	public ParametersTestLanguageExGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ParametersTestLanguageExGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
