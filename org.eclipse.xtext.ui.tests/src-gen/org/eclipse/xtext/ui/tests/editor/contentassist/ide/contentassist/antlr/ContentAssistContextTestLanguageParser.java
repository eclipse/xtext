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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalContentAssistContextTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistContextTestLanguageGrammarAccess;

public class ContentAssistContextTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ContentAssistContextTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ContentAssistContextTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getFirstLevelAccess().getGroup(), "rule__FirstLevel__Group__0");
			builder.put(grammarAccess.getSecondLevelAAccess().getGroup(), "rule__SecondLevelA__Group__0");
			builder.put(grammarAccess.getSecondLevelBAccess().getGroup(), "rule__SecondLevelB__Group__0");
			builder.put(grammarAccess.getThirdLevelA1Access().getGroup(), "rule__ThirdLevelA1__Group__0");
			builder.put(grammarAccess.getThirdLevelA2Access().getGroup(), "rule__ThirdLevelA2__Group__0");
			builder.put(grammarAccess.getThirdLevelB1Access().getGroup(), "rule__ThirdLevelB1__Group__0");
			builder.put(grammarAccess.getThirdLevelB2Access().getGroup(), "rule__ThirdLevelB2__Group__0");
			builder.put(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0(), "rule__FirstLevel__SecondLevelAAssignment_0");
			builder.put(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1(), "rule__FirstLevel__SecondLevelBAssignment_1");
			builder.put(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0(), "rule__SecondLevelA__ThirdLevelA1Assignment_0");
			builder.put(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1(), "rule__SecondLevelA__ThirdLevelA2Assignment_1");
			builder.put(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0(), "rule__SecondLevelB__ThirdLevelB1Assignment_0");
			builder.put(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1(), "rule__SecondLevelB__ThirdLevelB2Assignment_1");
			builder.put(grammarAccess.getThirdLevelA1Access().getNameAssignment_2(), "rule__ThirdLevelA1__NameAssignment_2");
			builder.put(grammarAccess.getThirdLevelA2Access().getNameAssignment_2(), "rule__ThirdLevelA2__NameAssignment_2");
			builder.put(grammarAccess.getThirdLevelB1Access().getNameAssignment_2(), "rule__ThirdLevelB1__NameAssignment_2");
			builder.put(grammarAccess.getThirdLevelB2Access().getNameAssignment_2(), "rule__ThirdLevelB2__NameAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ContentAssistContextTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalContentAssistContextTestLanguageParser createParser() {
		InternalContentAssistContextTestLanguageParser result = new InternalContentAssistContextTestLanguageParser(null);
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

	public ContentAssistContextTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ContentAssistContextTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
