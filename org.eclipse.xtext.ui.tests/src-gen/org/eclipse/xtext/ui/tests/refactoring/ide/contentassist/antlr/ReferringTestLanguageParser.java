/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.refactoring.ide.contentassist.antlr.internal.InternalReferringTestLanguageParser;
import org.eclipse.xtext.ui.tests.refactoring.services.ReferringTestLanguageGrammarAccess;

public class ReferringTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ReferringTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, ReferringTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getAbstractReferenceAccess().getAlternatives(), "rule__AbstractReference__Alternatives");
			mappings.put(grammarAccess.getReferenceAccess().getGroup(), "rule__Reference__Group__0");
			mappings.put(grammarAccess.getReference2Access().getGroup(), "rule__Reference2__Group__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			mappings.put(grammarAccess.getMainAccess().getReferencedAssignment(), "rule__Main__ReferencedAssignment");
			mappings.put(grammarAccess.getReferenceAccess().getReferencedAssignment_1(), "rule__Reference__ReferencedAssignment_1");
			mappings.put(grammarAccess.getReference2Access().getReferencedAssignment_2(), "rule__Reference2__ReferencedAssignment_2");
			mappings.put(grammarAccess.getNamedAccess().getNameAssignment(), "rule__Named__NameAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ReferringTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalReferringTestLanguageParser createParser() {
		InternalReferringTestLanguageParser result = new InternalReferringTestLanguageParser(null);
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

	public ReferringTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ReferringTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
