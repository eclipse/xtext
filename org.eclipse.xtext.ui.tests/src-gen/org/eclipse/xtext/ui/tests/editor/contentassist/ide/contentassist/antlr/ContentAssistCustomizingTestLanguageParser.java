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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalContentAssistCustomizingTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistCustomizingTestLanguageGrammarAccess;

public class ContentAssistCustomizingTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getTypeAccess().getAlternatives_0(), "rule__Type__Alternatives_0");
			mappings.put(grammarAccess.getTypeAccess().getGroup(), "rule__Type__Group__0");
			mappings.put(grammarAccess.getTypeAccess().getGroup_1(), "rule__Type__Group_1__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			mappings.put(grammarAccess.getModelAccess().getTypesAssignment(), "rule__Model__TypesAssignment");
			mappings.put(grammarAccess.getTypeAccess().getNameAssignment_0_0(), "rule__Type__NameAssignment_0_0");
			mappings.put(grammarAccess.getTypeAccess().getNameAssignment_0_1(), "rule__Type__NameAssignment_0_1");
			mappings.put(grammarAccess.getTypeAccess().getSuperTypeAssignment_1_1(), "rule__Type__SuperTypeAssignment_1_1");
			mappings.put(grammarAccess.getTypeRefAccess().getTypeAssignment(), "rule__TypeRef__TypeAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalContentAssistCustomizingTestLanguageParser createParser() {
		InternalContentAssistCustomizingTestLanguageParser result = new InternalContentAssistCustomizingTestLanguageParser(null);
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

	public ContentAssistCustomizingTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
