/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.nestedRefs.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.testlanguages.nestedRefs.ide.contentassist.antlr.internal.InternalNestedRefsTestLanguageParser;
import org.eclipse.xtext.testlanguages.nestedRefs.services.NestedRefsTestLanguageGrammarAccess;

public class NestedRefsTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(NestedRefsTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, NestedRefsTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getSelfReferingDeclAccess().getGroup(), "rule__SelfReferingDecl__Group__0");
			mappings.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			mappings.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			mappings.put(grammarAccess.getDocAccess().getDeclarationsAssignment(), "rule__Doc__DeclarationsAssignment");
			mappings.put(grammarAccess.getSelfReferingDeclAccess().getNameAssignment_1(), "rule__SelfReferingDecl__NameAssignment_1");
			mappings.put(grammarAccess.getSelfReferingDeclAccess().getSelfRefAssignment_3(), "rule__SelfReferingDecl__SelfRefAssignment_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private NestedRefsTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalNestedRefsTestLanguageParser createParser() {
		InternalNestedRefsTestLanguageParser result = new InternalNestedRefsTestLanguageParser(null);
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

	public NestedRefsTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(NestedRefsTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
