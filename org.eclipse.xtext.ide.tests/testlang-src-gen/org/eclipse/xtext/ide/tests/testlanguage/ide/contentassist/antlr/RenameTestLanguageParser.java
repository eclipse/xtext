/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal.InternalRenameTestLanguageParser;
import org.eclipse.xtext.ide.tests.testlanguage.services.RenameTestLanguageGrammarAccess;

public class RenameTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(RenameTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, RenameTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getTypeDeclarationAccess().getGroup(), "rule__TypeDeclaration__Group__0");
			mappings.put(grammarAccess.getTypeDeclarationAccess().getGroup_2(), "rule__TypeDeclaration__Group_2__0");
			mappings.put(grammarAccess.getTypeDeclarationAccess().getGroup_3(), "rule__TypeDeclaration__Group_3__0");
			mappings.put(grammarAccess.getModelAccess().getTypesAssignment(), "rule__Model__TypesAssignment");
			mappings.put(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1(), "rule__TypeDeclaration__NameAssignment_1");
			mappings.put(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1(), "rule__TypeDeclaration__SuperTypeAssignment_2_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private RenameTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalRenameTestLanguageParser createParser() {
		InternalRenameTestLanguageParser result = new InternalRenameTestLanguageParser(null);
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

	public RenameTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RenameTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
