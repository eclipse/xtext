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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug348199TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug348199TestLanguageGrammarAccess;

public class Bug348199TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug348199TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug348199TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getTimeperiodAccess().getAlternatives_3(), "rule__Timeperiod__Alternatives_3");
			builder.put(grammarAccess.getTimeperiodAccess().getAlternatives_3_1_3(), "rule__Timeperiod__Alternatives_3_1_3");
			builder.put(grammarAccess.getTimeperiodAccess().getAlternatives_3_2_3(), "rule__Timeperiod__Alternatives_3_2_3");
			builder.put(grammarAccess.getTimeperiodAccess().getAlternatives_3_3_3(), "rule__Timeperiod__Alternatives_3_3_3");
			builder.put(grammarAccess.getTimeperiodAccess().getAlternatives_3_5_4(), "rule__Timeperiod__Alternatives_3_5_4");
			builder.put(grammarAccess.getTimeperiodAccess().getAlternatives_3_6_4(), "rule__Timeperiod__Alternatives_3_6_4");
			builder.put(grammarAccess.getTimeperiodAccess().getAlternatives_3_7_4(), "rule__Timeperiod__Alternatives_3_7_4");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup(), "rule__Timeperiod__Group__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_0(), "rule__Timeperiod__Group_3_0__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_0_2(), "rule__Timeperiod__Group_3_0_2__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0(), "rule__Timeperiod__Group_3_0_3_0__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_0_3(), "rule__Timeperiod__Group_3_0_3_0_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1(), "rule__Timeperiod__Group_3_0_3_1__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_0_3_1_3(), "rule__Timeperiod__Group_3_0_3_1_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_1(), "rule__Timeperiod__Group_3_1__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_1_2(), "rule__Timeperiod__Group_3_1_2__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0(), "rule__Timeperiod__Group_3_1_3_0__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_0_3(), "rule__Timeperiod__Group_3_1_3_0_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1(), "rule__Timeperiod__Group_3_1_3_1__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_1_3_1_3(), "rule__Timeperiod__Group_3_1_3_1_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_2(), "rule__Timeperiod__Group_3_2__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_2_2(), "rule__Timeperiod__Group_3_2_2__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0(), "rule__Timeperiod__Group_3_2_3_0__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_0_3(), "rule__Timeperiod__Group_3_2_3_0_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1(), "rule__Timeperiod__Group_3_2_3_1__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_2_3_1_3(), "rule__Timeperiod__Group_3_2_3_1_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_3(), "rule__Timeperiod__Group_3_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_3_2(), "rule__Timeperiod__Group_3_3_2__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0(), "rule__Timeperiod__Group_3_3_3_0__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_0_3(), "rule__Timeperiod__Group_3_3_3_0_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1(), "rule__Timeperiod__Group_3_3_3_1__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_3_3_1_3(), "rule__Timeperiod__Group_3_3_3_1_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_4(), "rule__Timeperiod__Group_3_4__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_4_3(), "rule__Timeperiod__Group_3_4_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0(), "rule__Timeperiod__Group_3_4_4_0__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_0_3(), "rule__Timeperiod__Group_3_4_4_0_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1(), "rule__Timeperiod__Group_3_4_4_1__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_4_4_1_3(), "rule__Timeperiod__Group_3_4_4_1_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_5(), "rule__Timeperiod__Group_3_5__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_5_3(), "rule__Timeperiod__Group_3_5_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0(), "rule__Timeperiod__Group_3_5_4_0__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_0_3(), "rule__Timeperiod__Group_3_5_4_0_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1(), "rule__Timeperiod__Group_3_5_4_1__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_5_4_1_3(), "rule__Timeperiod__Group_3_5_4_1_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_6(), "rule__Timeperiod__Group_3_6__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_6_3(), "rule__Timeperiod__Group_3_6_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0(), "rule__Timeperiod__Group_3_6_4_0__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_0_3(), "rule__Timeperiod__Group_3_6_4_0_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1(), "rule__Timeperiod__Group_3_6_4_1__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_6_4_1_3(), "rule__Timeperiod__Group_3_6_4_1_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_7(), "rule__Timeperiod__Group_3_7__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_7_3(), "rule__Timeperiod__Group_3_7_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0(), "rule__Timeperiod__Group_3_7_4_0__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_0_3(), "rule__Timeperiod__Group_3_7_4_0_3__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1(), "rule__Timeperiod__Group_3_7_4_1__0");
			builder.put(grammarAccess.getTimeperiodAccess().getGroup_3_7_4_1_3(), "rule__Timeperiod__Group_3_7_4_1_3__0");
			builder.put(grammarAccess.getTimeDef1Access().getGroup(), "rule__TimeDef1__Group__0");
			builder.put(grammarAccess.getTimeDef2Access().getGroup(), "rule__TimeDef2__Group__0");
			builder.put(grammarAccess.getTimeDef3Access().getGroup(), "rule__TimeDef3__Group__0");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_2_1(), "rule__Timeperiod__TimeAssignment_3_0_2_1");
			builder.put(grammarAccess.getTimeperiodAccess().getNameAssignment_3_0_3_0_2(), "rule__Timeperiod__NameAssignment_3_0_3_0_2");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_0_3_1(), "rule__Timeperiod__TimeAssignment_3_0_3_0_3_1");
			builder.put(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_0_3_1_2(), "rule__Timeperiod__AliasAssignment_3_0_3_1_2");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_0_3_1_3_1(), "rule__Timeperiod__TimeAssignment_3_0_3_1_3_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_2_1(), "rule__Timeperiod__TimeAssignment_3_1_2_1");
			builder.put(grammarAccess.getTimeperiodAccess().getNameAssignment_3_1_3_0_2(), "rule__Timeperiod__NameAssignment_3_1_3_0_2");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_0_3_1(), "rule__Timeperiod__TimeAssignment_3_1_3_0_3_1");
			builder.put(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_1_3_1_2(), "rule__Timeperiod__AliasAssignment_3_1_3_1_2");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_1_3_1_3_1(), "rule__Timeperiod__TimeAssignment_3_1_3_1_3_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_2_1(), "rule__Timeperiod__TimeAssignment_3_2_2_1");
			builder.put(grammarAccess.getTimeperiodAccess().getNameAssignment_3_2_3_0_2(), "rule__Timeperiod__NameAssignment_3_2_3_0_2");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_0_3_1(), "rule__Timeperiod__TimeAssignment_3_2_3_0_3_1");
			builder.put(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_2_3_1_2(), "rule__Timeperiod__AliasAssignment_3_2_3_1_2");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_2_3_1_3_1(), "rule__Timeperiod__TimeAssignment_3_2_3_1_3_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_2_1(), "rule__Timeperiod__TimeAssignment_3_3_2_1");
			builder.put(grammarAccess.getTimeperiodAccess().getNameAssignment_3_3_3_0_2(), "rule__Timeperiod__NameAssignment_3_3_3_0_2");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_0_3_1(), "rule__Timeperiod__TimeAssignment_3_3_3_0_3_1");
			builder.put(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_3_3_1_2(), "rule__Timeperiod__AliasAssignment_3_3_3_1_2");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_3_3_1_3_1(), "rule__Timeperiod__TimeAssignment_3_3_3_1_3_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_3_0(), "rule__Timeperiod__TimeAssignment_3_4_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getNameAssignment_3_4_4_0_1(), "rule__Timeperiod__NameAssignment_3_4_4_0_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_0_3_0(), "rule__Timeperiod__TimeAssignment_3_4_4_0_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_4_4_1_1(), "rule__Timeperiod__AliasAssignment_3_4_4_1_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_4_4_1_3_0(), "rule__Timeperiod__TimeAssignment_3_4_4_1_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_3_0(), "rule__Timeperiod__TimeAssignment_3_5_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getNameAssignment_3_5_4_0_1(), "rule__Timeperiod__NameAssignment_3_5_4_0_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_0_3_0(), "rule__Timeperiod__TimeAssignment_3_5_4_0_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_5_4_1_1(), "rule__Timeperiod__AliasAssignment_3_5_4_1_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_5_4_1_3_0(), "rule__Timeperiod__TimeAssignment_3_5_4_1_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_3_0(), "rule__Timeperiod__TimeAssignment_3_6_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getNameAssignment_3_6_4_0_1(), "rule__Timeperiod__NameAssignment_3_6_4_0_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_0_3_0(), "rule__Timeperiod__TimeAssignment_3_6_4_0_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_6_4_1_1(), "rule__Timeperiod__AliasAssignment_3_6_4_1_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_6_4_1_3_0(), "rule__Timeperiod__TimeAssignment_3_6_4_1_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_3_0(), "rule__Timeperiod__TimeAssignment_3_7_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getNameAssignment_3_7_4_0_1(), "rule__Timeperiod__NameAssignment_3_7_4_0_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_0_3_0(), "rule__Timeperiod__TimeAssignment_3_7_4_0_3_0");
			builder.put(grammarAccess.getTimeperiodAccess().getAliasAssignment_3_7_4_1_1(), "rule__Timeperiod__AliasAssignment_3_7_4_1_1");
			builder.put(grammarAccess.getTimeperiodAccess().getTimeAssignment_3_7_4_1_3_0(), "rule__Timeperiod__TimeAssignment_3_7_4_1_3_0");
			builder.put(grammarAccess.getTimeDef1Access().getDayAssignment_1(), "rule__TimeDef1__DayAssignment_1");
			builder.put(grammarAccess.getTimeDef2Access().getDayAssignment_1(), "rule__TimeDef2__DayAssignment_1");
			builder.put(grammarAccess.getTimeDef3Access().getDayAssignment_1(), "rule__TimeDef3__DayAssignment_1");
			builder.put(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), "rule__Timeperiod__UnorderedGroup_3_0_3");
			builder.put(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), "rule__Timeperiod__UnorderedGroup_3_4_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug348199TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug348199TestLanguageParser createParser() {
		InternalBug348199TestLanguageParser result = new InternalBug348199TestLanguageParser(null);
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

	public Bug348199TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug348199TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
