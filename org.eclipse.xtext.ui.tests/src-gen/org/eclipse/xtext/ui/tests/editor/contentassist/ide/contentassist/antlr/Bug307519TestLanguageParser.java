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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug307519TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug307519TestLanguageGrammarAccess;

public class Bug307519TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug307519TestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, Bug307519TestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			mappings.put(grammarAccess.getEnumTAccess().getAlternatives(), "rule__EnumT__Alternatives");
			mappings.put(grammarAccess.getElem2Access().getGroup(), "rule__Elem2__Group__0");
			mappings.put(grammarAccess.getModelAccess().getE1Assignment_0(), "rule__Model__E1Assignment_0");
			mappings.put(grammarAccess.getModelAccess().getE2Assignment_1(), "rule__Model__E2Assignment_1");
			mappings.put(grammarAccess.getElem1Access().getValueAssignment(), "rule__Elem1__ValueAssignment");
			mappings.put(grammarAccess.getElem2Access().getValueAssignment_0(), "rule__Elem2__ValueAssignment_0");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug307519TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug307519TestLanguageParser createParser() {
		InternalBug307519TestLanguageParser result = new InternalBug307519TestLanguageParser(null);
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

	public Bug307519TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug307519TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
