/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.parser.keywords.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.parser.keywords.ide.contentassist.antlr.internal.InternalKeywordsUiTestLanguageParser;
import org.eclipse.xtext.ui.tests.parser.keywords.services.KeywordsUiTestLanguageGrammarAccess;

public class KeywordsUiTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(KeywordsUiTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, KeywordsUiTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			mappings.put(grammarAccess.getModelAccess().getFirstAssignment_0(), "rule__Model__FirstAssignment_0");
			mappings.put(grammarAccess.getModelAccess().getSecondAssignment_1(), "rule__Model__SecondAssignment_1");
			mappings.put(grammarAccess.getModelAccess().getThirdAssignment_2(), "rule__Model__ThirdAssignment_2");
			mappings.put(grammarAccess.getModelAccess().getForthAssignment_3(), "rule__Model__ForthAssignment_3");
			mappings.put(grammarAccess.getModelAccess().getFifthAssignment_4(), "rule__Model__FifthAssignment_4");
			mappings.put(grammarAccess.getModelAccess().getSixthAssignment_5(), "rule__Model__SixthAssignment_5");
			mappings.put(grammarAccess.getModelAccess().getSeventhAssignment_6(), "rule__Model__SeventhAssignment_6");
			mappings.put(grammarAccess.getModelAccess().getEighthAssignment_7(), "rule__Model__EighthAssignment_7");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private KeywordsUiTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalKeywordsUiTestLanguageParser createParser() {
		InternalKeywordsUiTestLanguageParser result = new InternalKeywordsUiTestLanguageParser(null);
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

	public KeywordsUiTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(KeywordsUiTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
