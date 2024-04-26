/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.tests.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.builder.tests.ide.contentassist.antlr.internal.InternalBuilderTestLanguageParser;
import org.eclipse.xtext.builder.tests.services.BuilderTestLanguageGrammarAccess;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class BuilderTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(BuilderTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, BuilderTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getNamedElementAccess().getAlternatives(), "rule__NamedElement__Alternatives");
			mappings.put(grammarAccess.getNamespaceAccess().getGroup(), "rule__Namespace__Group__0");
			mappings.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			mappings.put(grammarAccess.getElementAccess().getGroup(), "rule__Element__Group__0");
			mappings.put(grammarAccess.getElementAccess().getGroup_2(), "rule__Element__Group_2__0");
			mappings.put(grammarAccess.getElementAccess().getGroup_3(), "rule__Element__Group_3__0");
			mappings.put(grammarAccess.getElementAccess().getGroup_3_2(), "rule__Element__Group_3_2__0");
			mappings.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			mappings.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			mappings.put(grammarAccess.getNamespaceAccess().getNameAssignment_1(), "rule__Namespace__NameAssignment_1");
			mappings.put(grammarAccess.getNamespaceAccess().getImportsAssignment_3(), "rule__Namespace__ImportsAssignment_3");
			mappings.put(grammarAccess.getNamespaceAccess().getElementsAssignment_4(), "rule__Namespace__ElementsAssignment_4");
			mappings.put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
			mappings.put(grammarAccess.getElementAccess().getNameAssignment_1(), "rule__Element__NameAssignment_1");
			mappings.put(grammarAccess.getElementAccess().getReferencesAssignment_2_1(), "rule__Element__ReferencesAssignment_2_1");
			mappings.put(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1(), "rule__Element__OtherRefsAssignment_3_1");
			mappings.put(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1(), "rule__Element__OtherRefsAssignment_3_2_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private BuilderTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBuilderTestLanguageParser createParser() {
		InternalBuilderTestLanguageParser result = new InternalBuilderTestLanguageParser(null);
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

	public BuilderTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(BuilderTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
