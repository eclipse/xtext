/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.quickfix.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.quickfix.ide.contentassist.antlr.internal.InternalQuickfixCrossrefTestLanguageParser;
import org.eclipse.xtext.ui.tests.quickfix.services.QuickfixCrossrefTestLanguageGrammarAccess;

public class QuickfixCrossrefTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(QuickfixCrossrefTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, QuickfixCrossrefTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getElementAccess().getGroup(), "rule__Element__Group__0");
			mappings.put(grammarAccess.getElementAccess().getGroup_4(), "rule__Element__Group_4__0");
			mappings.put(grammarAccess.getMainAccess().getElementsAssignment(), "rule__Main__ElementsAssignment");
			mappings.put(grammarAccess.getElementAccess().getDocAssignment_0(), "rule__Element__DocAssignment_0");
			mappings.put(grammarAccess.getElementAccess().getNameAssignment_1(), "rule__Element__NameAssignment_1");
			mappings.put(grammarAccess.getElementAccess().getContainedAssignment_3(), "rule__Element__ContainedAssignment_3");
			mappings.put(grammarAccess.getElementAccess().getReferencedAssignment_4_1(), "rule__Element__ReferencedAssignment_4_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private QuickfixCrossrefTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalQuickfixCrossrefTestLanguageParser createParser() {
		InternalQuickfixCrossrefTestLanguageParser result = new InternalQuickfixCrossrefTestLanguageParser(null);
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

	public QuickfixCrossrefTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(QuickfixCrossrefTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
