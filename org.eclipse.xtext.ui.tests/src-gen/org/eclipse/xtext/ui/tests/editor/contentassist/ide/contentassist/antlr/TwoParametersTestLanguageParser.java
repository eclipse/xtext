/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalTwoParametersTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.TwoParametersTestLanguageGrammarAccess;

public class TwoParametersTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(TwoParametersTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, TwoParametersTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getParserRuleParametersAccess().getAlternatives_1(), "rule__ParserRuleParameters__Alternatives_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getAlternatives_1_8_1(), "rule__ParserRuleParameters__Alternatives_1_8_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getAlternatives_1_9_1(), "rule__ParserRuleParameters__Alternatives_1_9_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getAlternatives_1_10_1(), "rule__ParserRuleParameters__Alternatives_1_10_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getAlternatives_1_11_1(), "rule__ParserRuleParameters__Alternatives_1_11_1");
			builder.put(grammarAccess.getScenario8Access().getAlternatives(), "rule__Scenario8__Alternatives");
			builder.put(grammarAccess.getScenario10Access().getAlternatives(), "rule__Scenario10__Alternatives");
			builder.put(grammarAccess.getIdOrKeyword2Access().getAlternatives(), "rule__IdOrKeyword2__Alternatives");
			builder.put(grammarAccess.getScenario3Access().getAlternatives(), "rule__Scenario3__Alternatives");
			builder.put(grammarAccess.getScenario5Access().getAlternatives(), "rule__Scenario5__Alternatives");
			builder.put(grammarAccess.getIdOrKeywordAccess().getAlternatives(), "rule__IdOrKeyword__Alternatives");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup(), "rule__ParserRuleParameters__Group__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_0(), "rule__ParserRuleParameters__Group_1_0__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_1(), "rule__ParserRuleParameters__Group_1_1__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_2(), "rule__ParserRuleParameters__Group_1_2__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_3(), "rule__ParserRuleParameters__Group_1_3__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_4(), "rule__ParserRuleParameters__Group_1_4__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_4_0(), "rule__ParserRuleParameters__Group_1_4_0__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_5(), "rule__ParserRuleParameters__Group_1_5__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_5_0(), "rule__ParserRuleParameters__Group_1_5_0__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_6(), "rule__ParserRuleParameters__Group_1_6__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_7(), "rule__ParserRuleParameters__Group_1_7__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_8(), "rule__ParserRuleParameters__Group_1_8__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_8_1_1(), "rule__ParserRuleParameters__Group_1_8_1_1__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_9(), "rule__ParserRuleParameters__Group_1_9__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_9_1_1(), "rule__ParserRuleParameters__Group_1_9_1_1__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_10(), "rule__ParserRuleParameters__Group_1_10__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_10_1_1(), "rule__ParserRuleParameters__Group_1_10_1_1__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_11(), "rule__ParserRuleParameters__Group_1_11__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_11_1_1(), "rule__ParserRuleParameters__Group_1_11_1_1__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_12(), "rule__ParserRuleParameters__Group_1_12__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getGroup_1_13(), "rule__ParserRuleParameters__Group_1_13__0");
			builder.put(grammarAccess.getScenario9Access().getGroup(), "rule__Scenario9__Group__0");
			builder.put(grammarAccess.getScenario10Access().getGroup_1(), "rule__Scenario10__Group_1__0");
			builder.put(grammarAccess.getScenario10Access().getGroup_2(), "rule__Scenario10__Group_2__0");
			builder.put(grammarAccess.getScenario10Access().getGroup_3(), "rule__Scenario10__Group_3__0");
			builder.put(grammarAccess.getScenario10Access().getGroup_0(), "rule__Scenario10__Group_0__0");
			builder.put(grammarAccess.getScenario4Access().getGroup(), "rule__Scenario4__Group__0");
			builder.put(grammarAccess.getScenario5Access().getGroup_1(), "rule__Scenario5__Group_1__0");
			builder.put(grammarAccess.getScenario5Access().getGroup_2(), "rule__Scenario5__Group_2__0");
			builder.put(grammarAccess.getScenario5Access().getGroup_3(), "rule__Scenario5__Group_3__0");
			builder.put(grammarAccess.getScenario5Access().getGroup_0(), "rule__Scenario5__Group_0__0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_0_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_0_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_1_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_1_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_2_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_2_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_3_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_3_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_4_0_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_4_0_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_5_0_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_5_0_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_6_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_6_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_7_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_7_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_8_1_0(), "rule__ParserRuleParameters__ScenarioAssignment_1_8_1_0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_8_1_1_0(), "rule__ParserRuleParameters__ScenarioAssignment_1_8_1_1_0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_9_1_0(), "rule__ParserRuleParameters__ScenarioAssignment_1_9_1_0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_9_1_1_0(), "rule__ParserRuleParameters__ScenarioAssignment_1_9_1_1_0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_10_1_0(), "rule__ParserRuleParameters__ScenarioAssignment_1_10_1_0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_10_1_1_0(), "rule__ParserRuleParameters__ScenarioAssignment_1_10_1_1_0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_11_1_0(), "rule__ParserRuleParameters__ScenarioAssignment_1_11_1_0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_11_1_1_0(), "rule__ParserRuleParameters__ScenarioAssignment_1_11_1_1_0");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_12_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_12_1");
			builder.put(grammarAccess.getParserRuleParametersAccess().getScenarioAssignment_1_13_1(), "rule__ParserRuleParameters__ScenarioAssignment_1_13_1");
			builder.put(grammarAccess.getScenario6Access().getSecondAssignment_1_0(), "rule__Scenario6__SecondAssignment_1_0");
			builder.put(grammarAccess.getScenario6Access().getFirstAssignment_0_0(), "rule__Scenario6__FirstAssignment_0_0");
			builder.put(grammarAccess.getScenario7Access().getFirstAssignment(), "rule__Scenario7__FirstAssignment");
			builder.put(grammarAccess.getScenario8Access().getFirstAssignment_0(), "rule__Scenario8__FirstAssignment_0");
			builder.put(grammarAccess.getScenario8Access().getSecondAssignment_1(), "rule__Scenario8__SecondAssignment_1");
			builder.put(grammarAccess.getScenario9Access().getSecondAssignment_0(), "rule__Scenario9__SecondAssignment_0");
			builder.put(grammarAccess.getScenario10Access().getFirstAssignment_2_3(), "rule__Scenario10__FirstAssignment_2_3");
			builder.put(grammarAccess.getScenario10Access().getSecondAssignment_2_4(), "rule__Scenario10__SecondAssignment_2_4");
			builder.put(grammarAccess.getScenario1Access().getSecondAssignment_1_0(), "rule__Scenario1__SecondAssignment_1_0");
			builder.put(grammarAccess.getScenario1Access().getFirstAssignment_0_0(), "rule__Scenario1__FirstAssignment_0_0");
			builder.put(grammarAccess.getScenario2Access().getFirstAssignment(), "rule__Scenario2__FirstAssignment");
			builder.put(grammarAccess.getScenario3Access().getFirstAssignment_0(), "rule__Scenario3__FirstAssignment_0");
			builder.put(grammarAccess.getScenario3Access().getSecondAssignment_1(), "rule__Scenario3__SecondAssignment_1");
			builder.put(grammarAccess.getScenario4Access().getSecondAssignment_0(), "rule__Scenario4__SecondAssignment_0");
			builder.put(grammarAccess.getScenario5Access().getFirstAssignment_2_3(), "rule__Scenario5__FirstAssignment_2_3");
			builder.put(grammarAccess.getScenario5Access().getSecondAssignment_2_4(), "rule__Scenario5__SecondAssignment_2_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private TwoParametersTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalTwoParametersTestLanguageParser createParser() {
		InternalTwoParametersTestLanguageParser result = new InternalTwoParametersTestLanguageParser(null);
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

	public TwoParametersTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TwoParametersTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
