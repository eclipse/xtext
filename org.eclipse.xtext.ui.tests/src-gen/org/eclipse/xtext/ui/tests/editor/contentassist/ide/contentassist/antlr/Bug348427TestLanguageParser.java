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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug348427TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug348427TestLanguageGrammarAccess;

public class Bug348427TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug348427TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug348427TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			builder.put(grammarAccess.getScenario1_1Access().getAlternatives_1(), "rule__Scenario1_1__Alternatives_1");
			builder.put(grammarAccess.getScenario1_2Access().getAlternatives_1(), "rule__Scenario1_2__Alternatives_1");
			builder.put(grammarAccess.getScenario1_3Access().getAlternatives_2(), "rule__Scenario1_3__Alternatives_2");
			builder.put(grammarAccess.getScenario1_4Access().getAlternatives_2(), "rule__Scenario1_4__Alternatives_2");
			builder.put(grammarAccess.getScenario2_1Access().getAlternatives_1(), "rule__Scenario2_1__Alternatives_1");
			builder.put(grammarAccess.getScenario2_2Access().getAlternatives_1(), "rule__Scenario2_2__Alternatives_1");
			builder.put(grammarAccess.getScenario2_3Access().getAlternatives_1(), "rule__Scenario2_3__Alternatives_1");
			builder.put(grammarAccess.getScenario2_4Access().getAlternatives_1(), "rule__Scenario2_4__Alternatives_1");
			builder.put(grammarAccess.getScenario2_5Access().getAlternatives_2(), "rule__Scenario2_5__Alternatives_2");
			builder.put(grammarAccess.getScenario2_6Access().getAlternatives_2(), "rule__Scenario2_6__Alternatives_2");
			builder.put(grammarAccess.getScenario2_7Access().getAlternatives_2(), "rule__Scenario2_7__Alternatives_2");
			builder.put(grammarAccess.getScenario2_8Access().getAlternatives_2(), "rule__Scenario2_8__Alternatives_2");
			builder.put(grammarAccess.getChild2_1Access().getStringAlternatives_3_0(), "rule__Child2_1__StringAlternatives_3_0");
			builder.put(grammarAccess.getChild2_2Access().getStringAlternatives_3_0(), "rule__Child2_2__StringAlternatives_3_0");
			builder.put(grammarAccess.getChild2_3Access().getStringAlternatives_3_0(), "rule__Child2_3__StringAlternatives_3_0");
			builder.put(grammarAccess.getChild2_4Access().getAlternatives_3(), "rule__Child2_4__Alternatives_3");
			builder.put(grammarAccess.getChild2_5Access().getAlternatives_3(), "rule__Child2_5__Alternatives_3");
			builder.put(grammarAccess.getChild2_6Access().getAlternatives_3(), "rule__Child2_6__Alternatives_3");
			builder.put(grammarAccess.getEnumTypeAccess().getAlternatives(), "rule__EnumType__Alternatives");
			builder.put(grammarAccess.getScenario1_1Access().getGroup(), "rule__Scenario1_1__Group__0");
			builder.put(grammarAccess.getScenario1_2Access().getGroup(), "rule__Scenario1_2__Group__0");
			builder.put(grammarAccess.getScenario1_3Access().getGroup(), "rule__Scenario1_3__Group__0");
			builder.put(grammarAccess.getScenario1_4Access().getGroup(), "rule__Scenario1_4__Group__0");
			builder.put(grammarAccess.getChild1_1Access().getGroup(), "rule__Child1_1__Group__0");
			builder.put(grammarAccess.getChild1_1Access().getGroup_2(), "rule__Child1_1__Group_2__0");
			builder.put(grammarAccess.getChild1_2Access().getGroup(), "rule__Child1_2__Group__0");
			builder.put(grammarAccess.getChild1_2Access().getGroup_2(), "rule__Child1_2__Group_2__0");
			builder.put(grammarAccess.getChild1_3Access().getGroup(), "rule__Child1_3__Group__0");
			builder.put(grammarAccess.getChild1_3Access().getGroup_2(), "rule__Child1_3__Group_2__0");
			builder.put(grammarAccess.getScenario2_1Access().getGroup(), "rule__Scenario2_1__Group__0");
			builder.put(grammarAccess.getScenario2_2Access().getGroup(), "rule__Scenario2_2__Group__0");
			builder.put(grammarAccess.getScenario2_3Access().getGroup(), "rule__Scenario2_3__Group__0");
			builder.put(grammarAccess.getScenario2_4Access().getGroup(), "rule__Scenario2_4__Group__0");
			builder.put(grammarAccess.getScenario2_5Access().getGroup(), "rule__Scenario2_5__Group__0");
			builder.put(grammarAccess.getScenario2_6Access().getGroup(), "rule__Scenario2_6__Group__0");
			builder.put(grammarAccess.getScenario2_7Access().getGroup(), "rule__Scenario2_7__Group__0");
			builder.put(grammarAccess.getScenario2_8Access().getGroup(), "rule__Scenario2_8__Group__0");
			builder.put(grammarAccess.getChild2_1Access().getGroup(), "rule__Child2_1__Group__0");
			builder.put(grammarAccess.getChild2_1Access().getGroup_2(), "rule__Child2_1__Group_2__0");
			builder.put(grammarAccess.getChild2_2Access().getGroup(), "rule__Child2_2__Group__0");
			builder.put(grammarAccess.getChild2_2Access().getGroup_2(), "rule__Child2_2__Group_2__0");
			builder.put(grammarAccess.getChild2_3Access().getGroup(), "rule__Child2_3__Group__0");
			builder.put(grammarAccess.getChild2_3Access().getGroup_2(), "rule__Child2_3__Group_2__0");
			builder.put(grammarAccess.getChild2_4Access().getGroup(), "rule__Child2_4__Group__0");
			builder.put(grammarAccess.getChild2_4Access().getGroup_2(), "rule__Child2_4__Group_2__0");
			builder.put(grammarAccess.getChild2_5Access().getGroup(), "rule__Child2_5__Group__0");
			builder.put(grammarAccess.getChild2_5Access().getGroup_2(), "rule__Child2_5__Group_2__0");
			builder.put(grammarAccess.getChild2_6Access().getGroup(), "rule__Child2_6__Group__0");
			builder.put(grammarAccess.getChild2_6Access().getGroup_2(), "rule__Child2_6__Group_2__0");
			builder.put(grammarAccess.getModelAccess().getElement1Assignment_0(), "rule__Model__Element1Assignment_0");
			builder.put(grammarAccess.getModelAccess().getElement1Assignment_1(), "rule__Model__Element1Assignment_1");
			builder.put(grammarAccess.getModelAccess().getElement1Assignment_2(), "rule__Model__Element1Assignment_2");
			builder.put(grammarAccess.getModelAccess().getElement1Assignment_3(), "rule__Model__Element1Assignment_3");
			builder.put(grammarAccess.getModelAccess().getElement2Assignment_4(), "rule__Model__Element2Assignment_4");
			builder.put(grammarAccess.getModelAccess().getElement2Assignment_5(), "rule__Model__Element2Assignment_5");
			builder.put(grammarAccess.getModelAccess().getElement2Assignment_6(), "rule__Model__Element2Assignment_6");
			builder.put(grammarAccess.getModelAccess().getElement2Assignment_7(), "rule__Model__Element2Assignment_7");
			builder.put(grammarAccess.getModelAccess().getElement2Assignment_8(), "rule__Model__Element2Assignment_8");
			builder.put(grammarAccess.getModelAccess().getElement2Assignment_9(), "rule__Model__Element2Assignment_9");
			builder.put(grammarAccess.getModelAccess().getElement2Assignment_10(), "rule__Model__Element2Assignment_10");
			builder.put(grammarAccess.getModelAccess().getElement2Assignment_11(), "rule__Model__Element2Assignment_11");
			builder.put(grammarAccess.getScenario1_1Access().getChildAssignment_1_0(), "rule__Scenario1_1__ChildAssignment_1_0");
			builder.put(grammarAccess.getScenario1_1Access().getChildAssignment_1_1(), "rule__Scenario1_1__ChildAssignment_1_1");
			builder.put(grammarAccess.getScenario1_1Access().getChildAssignment_1_2(), "rule__Scenario1_1__ChildAssignment_1_2");
			builder.put(grammarAccess.getScenario1_2Access().getChildAssignment_1_0(), "rule__Scenario1_2__ChildAssignment_1_0");
			builder.put(grammarAccess.getScenario1_2Access().getChildAssignment_1_1(), "rule__Scenario1_2__ChildAssignment_1_1");
			builder.put(grammarAccess.getScenario1_2Access().getChildAssignment_1_2(), "rule__Scenario1_2__ChildAssignment_1_2");
			builder.put(grammarAccess.getScenario1_3Access().getChildAssignment_2_0(), "rule__Scenario1_3__ChildAssignment_2_0");
			builder.put(grammarAccess.getScenario1_3Access().getChildAssignment_2_1(), "rule__Scenario1_3__ChildAssignment_2_1");
			builder.put(grammarAccess.getScenario1_3Access().getChildAssignment_2_2(), "rule__Scenario1_3__ChildAssignment_2_2");
			builder.put(grammarAccess.getScenario1_4Access().getChildAssignment_2_0(), "rule__Scenario1_4__ChildAssignment_2_0");
			builder.put(grammarAccess.getScenario1_4Access().getChildAssignment_2_1(), "rule__Scenario1_4__ChildAssignment_2_1");
			builder.put(grammarAccess.getScenario1_4Access().getChildAssignment_2_2(), "rule__Scenario1_4__ChildAssignment_2_2");
			builder.put(grammarAccess.getChild1_1Access().getNameAssignment_0(), "rule__Child1_1__NameAssignment_0");
			builder.put(grammarAccess.getChild1_1Access().getBoolAssignment_2_0(), "rule__Child1_1__BoolAssignment_2_0");
			builder.put(grammarAccess.getChild1_1Access().getEnumTypeAssignment_3(), "rule__Child1_1__EnumTypeAssignment_3");
			builder.put(grammarAccess.getChild1_2Access().getNameAssignment_0(), "rule__Child1_2__NameAssignment_0");
			builder.put(grammarAccess.getChild1_2Access().getBoolAssignment_2_0(), "rule__Child1_2__BoolAssignment_2_0");
			builder.put(grammarAccess.getChild1_2Access().getEnumTypeAssignment_3(), "rule__Child1_2__EnumTypeAssignment_3");
			builder.put(grammarAccess.getChild1_3Access().getNameAssignment_0(), "rule__Child1_3__NameAssignment_0");
			builder.put(grammarAccess.getChild1_3Access().getBoolAssignment_2_0(), "rule__Child1_3__BoolAssignment_2_0");
			builder.put(grammarAccess.getChild1_3Access().getEnumTypeAssignment_3(), "rule__Child1_3__EnumTypeAssignment_3");
			builder.put(grammarAccess.getScenario2_1Access().getChildAssignment_1_0(), "rule__Scenario2_1__ChildAssignment_1_0");
			builder.put(grammarAccess.getScenario2_1Access().getChildAssignment_1_1(), "rule__Scenario2_1__ChildAssignment_1_1");
			builder.put(grammarAccess.getScenario2_1Access().getChildAssignment_1_2(), "rule__Scenario2_1__ChildAssignment_1_2");
			builder.put(grammarAccess.getScenario2_2Access().getChildAssignment_1_0(), "rule__Scenario2_2__ChildAssignment_1_0");
			builder.put(grammarAccess.getScenario2_2Access().getChildAssignment_1_1(), "rule__Scenario2_2__ChildAssignment_1_1");
			builder.put(grammarAccess.getScenario2_2Access().getChildAssignment_1_2(), "rule__Scenario2_2__ChildAssignment_1_2");
			builder.put(grammarAccess.getScenario2_3Access().getChildAssignment_1_0(), "rule__Scenario2_3__ChildAssignment_1_0");
			builder.put(grammarAccess.getScenario2_3Access().getChildAssignment_1_1(), "rule__Scenario2_3__ChildAssignment_1_1");
			builder.put(grammarAccess.getScenario2_3Access().getChildAssignment_1_2(), "rule__Scenario2_3__ChildAssignment_1_2");
			builder.put(grammarAccess.getScenario2_4Access().getChildAssignment_1_0(), "rule__Scenario2_4__ChildAssignment_1_0");
			builder.put(grammarAccess.getScenario2_4Access().getChildAssignment_1_1(), "rule__Scenario2_4__ChildAssignment_1_1");
			builder.put(grammarAccess.getScenario2_4Access().getChildAssignment_1_2(), "rule__Scenario2_4__ChildAssignment_1_2");
			builder.put(grammarAccess.getScenario2_5Access().getChildAssignment_2_0(), "rule__Scenario2_5__ChildAssignment_2_0");
			builder.put(grammarAccess.getScenario2_5Access().getChildAssignment_2_1(), "rule__Scenario2_5__ChildAssignment_2_1");
			builder.put(grammarAccess.getScenario2_5Access().getChildAssignment_2_2(), "rule__Scenario2_5__ChildAssignment_2_2");
			builder.put(grammarAccess.getScenario2_6Access().getChildAssignment_2_0(), "rule__Scenario2_6__ChildAssignment_2_0");
			builder.put(grammarAccess.getScenario2_6Access().getChildAssignment_2_1(), "rule__Scenario2_6__ChildAssignment_2_1");
			builder.put(grammarAccess.getScenario2_6Access().getChildAssignment_2_2(), "rule__Scenario2_6__ChildAssignment_2_2");
			builder.put(grammarAccess.getScenario2_7Access().getChildAssignment_2_0(), "rule__Scenario2_7__ChildAssignment_2_0");
			builder.put(grammarAccess.getScenario2_7Access().getChildAssignment_2_1(), "rule__Scenario2_7__ChildAssignment_2_1");
			builder.put(grammarAccess.getScenario2_7Access().getChildAssignment_2_2(), "rule__Scenario2_7__ChildAssignment_2_2");
			builder.put(grammarAccess.getScenario2_8Access().getChildAssignment_2_0(), "rule__Scenario2_8__ChildAssignment_2_0");
			builder.put(grammarAccess.getScenario2_8Access().getChildAssignment_2_1(), "rule__Scenario2_8__ChildAssignment_2_1");
			builder.put(grammarAccess.getScenario2_8Access().getChildAssignment_2_2(), "rule__Scenario2_8__ChildAssignment_2_2");
			builder.put(grammarAccess.getChild2_1Access().getNameAssignment_0(), "rule__Child2_1__NameAssignment_0");
			builder.put(grammarAccess.getChild2_1Access().getBoolAssignment_2_0(), "rule__Child2_1__BoolAssignment_2_0");
			builder.put(grammarAccess.getChild2_1Access().getStringAssignment_3(), "rule__Child2_1__StringAssignment_3");
			builder.put(grammarAccess.getChild2_2Access().getNameAssignment_0(), "rule__Child2_2__NameAssignment_0");
			builder.put(grammarAccess.getChild2_2Access().getBoolAssignment_2_0(), "rule__Child2_2__BoolAssignment_2_0");
			builder.put(grammarAccess.getChild2_2Access().getStringAssignment_3(), "rule__Child2_2__StringAssignment_3");
			builder.put(grammarAccess.getChild2_3Access().getNameAssignment_0(), "rule__Child2_3__NameAssignment_0");
			builder.put(grammarAccess.getChild2_3Access().getBoolAssignment_2_0(), "rule__Child2_3__BoolAssignment_2_0");
			builder.put(grammarAccess.getChild2_3Access().getStringAssignment_3(), "rule__Child2_3__StringAssignment_3");
			builder.put(grammarAccess.getChild2_4Access().getNameAssignment_0(), "rule__Child2_4__NameAssignment_0");
			builder.put(grammarAccess.getChild2_4Access().getBoolAssignment_2_0(), "rule__Child2_4__BoolAssignment_2_0");
			builder.put(grammarAccess.getChild2_4Access().getStringAssignment_3_0(), "rule__Child2_4__StringAssignment_3_0");
			builder.put(grammarAccess.getChild2_4Access().getStringAssignment_3_1(), "rule__Child2_4__StringAssignment_3_1");
			builder.put(grammarAccess.getChild2_5Access().getNameAssignment_0(), "rule__Child2_5__NameAssignment_0");
			builder.put(grammarAccess.getChild2_5Access().getBoolAssignment_2_0(), "rule__Child2_5__BoolAssignment_2_0");
			builder.put(grammarAccess.getChild2_5Access().getStringAssignment_3_0(), "rule__Child2_5__StringAssignment_3_0");
			builder.put(grammarAccess.getChild2_5Access().getStringAssignment_3_1(), "rule__Child2_5__StringAssignment_3_1");
			builder.put(grammarAccess.getChild2_6Access().getNameAssignment_0(), "rule__Child2_6__NameAssignment_0");
			builder.put(grammarAccess.getChild2_6Access().getBoolAssignment_2_0(), "rule__Child2_6__BoolAssignment_2_0");
			builder.put(grammarAccess.getChild2_6Access().getStringAssignment_3_0(), "rule__Child2_6__StringAssignment_3_0");
			builder.put(grammarAccess.getChild2_6Access().getStringAssignment_3_1(), "rule__Child2_6__StringAssignment_3_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug348427TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug348427TestLanguageParser createParser() {
		InternalBug348427TestLanguageParser result = new InternalBug348427TestLanguageParser(null);
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

	public Bug348427TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug348427TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
