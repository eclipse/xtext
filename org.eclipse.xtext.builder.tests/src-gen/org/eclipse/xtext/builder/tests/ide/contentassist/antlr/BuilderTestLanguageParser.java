/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.tests.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
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
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, BuilderTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getNamedElementAccess().getAlternatives(), "rule__NamedElement__Alternatives");
			builder.put(grammarAccess.getNamespaceAccess().getGroup(), "rule__Namespace__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getElementAccess().getGroup(), "rule__Element__Group__0");
			builder.put(grammarAccess.getElementAccess().getGroup_2(), "rule__Element__Group_2__0");
			builder.put(grammarAccess.getElementAccess().getGroup_3(), "rule__Element__Group_3__0");
			builder.put(grammarAccess.getElementAccess().getGroup_3_2(), "rule__Element__Group_3_2__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getNamespaceAccess().getNameAssignment_1(), "rule__Namespace__NameAssignment_1");
			builder.put(grammarAccess.getNamespaceAccess().getImportsAssignment_3(), "rule__Namespace__ImportsAssignment_3");
			builder.put(grammarAccess.getNamespaceAccess().getElementsAssignment_4(), "rule__Namespace__ElementsAssignment_4");
			builder.put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
			builder.put(grammarAccess.getElementAccess().getNameAssignment_1(), "rule__Element__NameAssignment_1");
			builder.put(grammarAccess.getElementAccess().getReferencesAssignment_2_1(), "rule__Element__ReferencesAssignment_2_1");
			builder.put(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1(), "rule__Element__OtherRefsAssignment_3_1");
			builder.put(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1(), "rule__Element__OtherRefsAssignment_3_2_1");
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
