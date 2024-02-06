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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug286935TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug286935TestLanguageGrammarAccess;

public class Bug286935TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug286935TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug286935TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getStateAccess().getAlternatives_1(), "rule__State__Alternatives_1");
			builder.put(grammarAccess.getStateTypeAccess().getAlternatives(), "rule__StateType__Alternatives");
			builder.put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
			builder.put(grammarAccess.getStateAccess().getGroup_1_3(), "rule__State__Group_1_3__0");
			builder.put(grammarAccess.getStateAccess().getGroup_1_4(), "rule__State__Group_1_4__0");
			builder.put(grammarAccess.getStateAccess().getIsInitialAssignment_1_0(), "rule__State__IsInitialAssignment_1_0");
			builder.put(grammarAccess.getStateAccess().getIsFinalAssignment_1_1(), "rule__State__IsFinalAssignment_1_1");
			builder.put(grammarAccess.getStateAccess().getStateKindAssignment_1_2(), "rule__State__StateKindAssignment_1_2");
			builder.put(grammarAccess.getStateAccess().getIsInitialAssignment_1_3_0(), "rule__State__IsInitialAssignment_1_3_0");
			builder.put(grammarAccess.getStateAccess().getStateKindAssignment_1_3_1(), "rule__State__StateKindAssignment_1_3_1");
			builder.put(grammarAccess.getStateAccess().getIsInitialAssignment_1_4_0(), "rule__State__IsInitialAssignment_1_4_0");
			builder.put(grammarAccess.getStateAccess().getStateKindAssignment_1_4_1(), "rule__State__StateKindAssignment_1_4_1");
			builder.put(grammarAccess.getStateAccess().getIsFinalAssignment_1_4_2(), "rule__State__IsFinalAssignment_1_4_2");
			builder.put(grammarAccess.getStateAccess().getStateNameAssignment_3(), "rule__State__StateNameAssignment_3");
			builder.put(grammarAccess.getStateAccess().getLabelAssignment_4(), "rule__State__LabelAssignment_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug286935TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug286935TestLanguageParser createParser() {
		InternalBug286935TestLanguageParser result = new InternalBug286935TestLanguageParser(null);
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

	public Bug286935TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug286935TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
