/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.common.types.xtext.ui.ide.contentassist.antlr.internal.InternalContentAssistTestLanguageParser;
import org.eclipse.xtext.common.types.xtext.ui.services.ContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class ContentAssistTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ContentAssistTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, ContentAssistTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getReferenceHolderAccess().getAlternatives(), "rule__ReferenceHolder__Alternatives");
			mappings.put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
			mappings.put(grammarAccess.getReferenceHolderAccess().getGroup_0(), "rule__ReferenceHolder__Group_0__0");
			mappings.put(grammarAccess.getReferenceHolderAccess().getGroup_1(), "rule__ReferenceHolder__Group_1__0");
			mappings.put(grammarAccess.getReferenceHolderAccess().getGroup_2(), "rule__ReferenceHolder__Group_2__0");
			mappings.put(grammarAccess.getGenerateDirectiveAccess().getGroup(), "rule__GenerateDirective__Group__0");
			mappings.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			mappings.put(grammarAccess.getImportedFQNAccess().getGroup(), "rule__ImportedFQN__Group__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			mappings.put(grammarAccess.getQNAccess().getGroup(), "rule__QN__Group__0");
			mappings.put(grammarAccess.getQNAccess().getGroup_1(), "rule__QN__Group_1__0");
			mappings.put(grammarAccess.getModelAccess().getImportsAssignment_0(), "rule__Model__ImportsAssignment_0");
			mappings.put(grammarAccess.getModelAccess().getGenerateDirectiveAssignment_1(), "rule__Model__GenerateDirectiveAssignment_1");
			mappings.put(grammarAccess.getModelAccess().getReferenceHolderAssignment_2(), "rule__Model__ReferenceHolderAssignment_2");
			mappings.put(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_0_1(), "rule__ReferenceHolder__DefaultReferenceAssignment_0_1");
			mappings.put(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceAssignment_1_1(), "rule__ReferenceHolder__CustomizedReferenceAssignment_1_1");
			mappings.put(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceAssignment_2_1(), "rule__ReferenceHolder__SubtypeReferenceAssignment_2_1");
			mappings.put(grammarAccess.getGenerateDirectiveAccess().getTypeNameAssignment_1(), "rule__GenerateDirective__TypeNameAssignment_1");
			mappings.put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ContentAssistTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalContentAssistTestLanguageParser createParser() {
		InternalContentAssistTestLanguageParser result = new InternalContentAssistTestLanguageParser(null);
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

	public ContentAssistTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ContentAssistTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
