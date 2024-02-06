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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalGH341TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.GH341TestLanguageGrammarAccess;

public class GH341TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(GH341TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, GH341TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getElementsAlternatives_0(), "rule__Model__ElementsAlternatives_0");
			builder.put(grammarAccess.getElementAccess().getAlternatives(), "rule__Element__Alternatives");
			builder.put(grammarAccess.getWorksAccess().getGroup(), "rule__Works__Group__0");
			builder.put(grammarAccess.getWorksAccess().getGroup_2(), "rule__Works__Group_2__0");
			builder.put(grammarAccess.getWorksAccess().getGroup_2_1(), "rule__Works__Group_2_1__0");
			builder.put(grammarAccess.getWorksAccess().getGroup_3(), "rule__Works__Group_3__0");
			builder.put(grammarAccess.getWorksAccess().getGroup_3_1(), "rule__Works__Group_3_1__0");
			builder.put(grammarAccess.getBrokenAccess().getGroup(), "rule__Broken__Group__0");
			builder.put(grammarAccess.getBrokenAccess().getGroup_3(), "rule__Broken__Group_3__0");
			builder.put(grammarAccess.getBrokenAccess().getGroup_3_1(), "rule__Broken__Group_3_1__0");
			builder.put(grammarAccess.getThirdAccess().getGroup(), "rule__Third__Group__0");
			builder.put(grammarAccess.getFragmentAccess().getGroup(), "rule__Fragment__Group__0");
			builder.put(grammarAccess.getFragmentAccess().getGroup_1(), "rule__Fragment__Group_1__0");
			builder.put(grammarAccess.getModelAccess().getElementsAssignment(), "rule__Model__ElementsAssignment");
			builder.put(grammarAccess.getWorksAccess().getNameAssignment_1(), "rule__Works__NameAssignment_1");
			builder.put(grammarAccess.getWorksAccess().getIdsAssignment_2_0(), "rule__Works__IdsAssignment_2_0");
			builder.put(grammarAccess.getWorksAccess().getIdsAssignment_2_1_1(), "rule__Works__IdsAssignment_2_1_1");
			builder.put(grammarAccess.getWorksAccess().getRefsAssignment_3_0(), "rule__Works__RefsAssignment_3_0");
			builder.put(grammarAccess.getWorksAccess().getRefsAssignment_3_1_1(), "rule__Works__RefsAssignment_3_1_1");
			builder.put(grammarAccess.getBrokenAccess().getNameAssignment_1(), "rule__Broken__NameAssignment_1");
			builder.put(grammarAccess.getBrokenAccess().getRefsAssignment_3_0(), "rule__Broken__RefsAssignment_3_0");
			builder.put(grammarAccess.getBrokenAccess().getRefsAssignment_3_1_1(), "rule__Broken__RefsAssignment_3_1_1");
			builder.put(grammarAccess.getThirdAccess().getNameAssignment_2(), "rule__Third__NameAssignment_2");
			builder.put(grammarAccess.getFragmentAccess().getIdsAssignment_0(), "rule__Fragment__IdsAssignment_0");
			builder.put(grammarAccess.getFragmentAccess().getIdsAssignment_1_1(), "rule__Fragment__IdsAssignment_1_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private GH341TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalGH341TestLanguageParser createParser() {
		InternalGH341TestLanguageParser result = new InternalGH341TestLanguageParser(null);
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

	public GH341TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(GH341TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
