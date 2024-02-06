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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalLookAheadContentAssistTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.LookAheadContentAssistTestLanguageGrammarAccess;

public class LookAheadContentAssistTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(LookAheadContentAssistTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, LookAheadContentAssistTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives_1(), "rule__Model__Alternatives_1");
			builder.put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_0(), "rule__Model__Group_1_0__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_1(), "rule__Model__Group_1_1__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_2(), "rule__Model__Group_1_2__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_3(), "rule__Model__Group_1_3__0");
			builder.put(grammarAccess.getPairAccess().getGroup(), "rule__Pair__Group__0");
			builder.put(grammarAccess.getModelAccess().getAttributeAssignment_1_0_1(), "rule__Model__AttributeAssignment_1_0_1");
			builder.put(grammarAccess.getModelAccess().getAttributeAssignment_1_0_2(), "rule__Model__AttributeAssignment_1_0_2");
			builder.put(grammarAccess.getModelAccess().getAttributeAssignment_1_1_1(), "rule__Model__AttributeAssignment_1_1_1");
			builder.put(grammarAccess.getModelAccess().getAttributeAssignment_1_1_2(), "rule__Model__AttributeAssignment_1_1_2");
			builder.put(grammarAccess.getModelAccess().getAttributeAssignment_1_2_1(), "rule__Model__AttributeAssignment_1_2_1");
			builder.put(grammarAccess.getModelAccess().getAttributeAssignment_1_2_2(), "rule__Model__AttributeAssignment_1_2_2");
			builder.put(grammarAccess.getModelAccess().getAttributeAssignment_1_3_1(), "rule__Model__AttributeAssignment_1_3_1");
			builder.put(grammarAccess.getModelAccess().getAttributeAssignment_1_3_2(), "rule__Model__AttributeAssignment_1_3_2");
			builder.put(grammarAccess.getAttributeAccess().getValueAssignment(), "rule__Attribute__ValueAssignment");
			builder.put(grammarAccess.getPairAccess().getNameAssignment_0(), "rule__Pair__NameAssignment_0");
			builder.put(grammarAccess.getPairAccess().getValueAssignment_2(), "rule__Pair__ValueAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private LookAheadContentAssistTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalLookAheadContentAssistTestLanguageParser createParser() {
		InternalLookAheadContentAssistTestLanguageParser result = new InternalLookAheadContentAssistTestLanguageParser(null);
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

	public LookAheadContentAssistTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(LookAheadContentAssistTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
