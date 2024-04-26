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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalCrossReferenceProposalTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;

public class CrossReferenceProposalTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getClassAccess().getAlternatives_0_0(), "rule__Class__Alternatives_0_0");
			mappings.put(grammarAccess.getClassAccess().getNameAlternatives_1_0(), "rule__Class__NameAlternatives_1_0");
			mappings.put(grammarAccess.getClassAccess().getGroup(), "rule__Class__Group__0");
			mappings.put(grammarAccess.getClassAccess().getGroup_0(), "rule__Class__Group_0__0");
			mappings.put(grammarAccess.getComplexNameAccess().getGroup(), "rule__ComplexName__Group__0");
			mappings.put(grammarAccess.getModelAccess().getElementsAssignment(), "rule__Model__ElementsAssignment");
			mappings.put(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_0(), "rule__Class__SuperClassAssignment_0_0_0");
			mappings.put(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_1(), "rule__Class__SuperClassAssignment_0_0_1");
			mappings.put(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_2(), "rule__Class__SuperClassAssignment_0_0_2");
			mappings.put(grammarAccess.getClassAccess().getNameAssignment_1(), "rule__Class__NameAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private CrossReferenceProposalTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalCrossReferenceProposalTestLanguageParser createParser() {
		InternalCrossReferenceProposalTestLanguageParser result = new InternalCrossReferenceProposalTestLanguageParser(null);
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

	public CrossReferenceProposalTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
