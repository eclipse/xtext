/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.fileAware.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.testlanguages.fileAware.ide.contentassist.antlr.internal.InternalFileAwareTestLanguageParser;
import org.eclipse.xtext.testlanguages.fileAware.services.FileAwareTestLanguageGrammarAccess;

public class FileAwareTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(FileAwareTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, FileAwareTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getElementAccess().getAlternatives_3(), "rule__Element__Alternatives_3");
			mappings.put(grammarAccess.getPackageDeclarationAccess().getGroup(), "rule__PackageDeclaration__Group__0");
			mappings.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			mappings.put(grammarAccess.getElementAccess().getGroup(), "rule__Element__Group__0");
			mappings.put(grammarAccess.getElementAccess().getGroup_3_1(), "rule__Element__Group_3_1__0");
			mappings.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			mappings.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			mappings.put(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1(), "rule__PackageDeclaration__NameAssignment_1");
			mappings.put(grammarAccess.getPackageDeclarationAccess().getImportsAssignment_2(), "rule__PackageDeclaration__ImportsAssignment_2");
			mappings.put(grammarAccess.getPackageDeclarationAccess().getContentsAssignment_3(), "rule__PackageDeclaration__ContentsAssignment_3");
			mappings.put(grammarAccess.getImportAccess().getElementAssignment_1(), "rule__Import__ElementAssignment_1");
			mappings.put(grammarAccess.getElementAccess().getNameAssignment_1(), "rule__Element__NameAssignment_1");
			mappings.put(grammarAccess.getElementAccess().getContentsAssignment_3_0(), "rule__Element__ContentsAssignment_3_0");
			mappings.put(grammarAccess.getElementAccess().getRefAssignment_3_1_1(), "rule__Element__RefAssignment_3_1_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private FileAwareTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalFileAwareTestLanguageParser createParser() {
		InternalFileAwareTestLanguageParser result = new InternalFileAwareTestLanguageParser(null);
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

	public FileAwareTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(FileAwareTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
