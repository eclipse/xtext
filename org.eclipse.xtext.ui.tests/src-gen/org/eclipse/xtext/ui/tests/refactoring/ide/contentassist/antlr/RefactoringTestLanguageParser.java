/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.refactoring.ide.contentassist.antlr.internal.InternalRefactoringTestLanguageParser;
import org.eclipse.xtext.ui.tests.refactoring.services.RefactoringTestLanguageGrammarAccess;

public class RefactoringTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(RefactoringTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, RefactoringTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getAbstractElementAccess().getAlternatives(), "rule__AbstractElement__Alternatives");
			builder.put(grammarAccess.getElementAccess().getAlternatives_1_1(), "rule__Element__Alternatives_1_1");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getElementAccess().getGroup(), "rule__Element__Group__0");
			builder.put(grammarAccess.getElementAccess().getGroup_1(), "rule__Element__Group_1__0");
			builder.put(grammarAccess.getElementAccess().getGroup_1_1_1(), "rule__Element__Group_1_1_1__0");
			builder.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			builder.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			builder.put(grammarAccess.getFQNWithWCAccess().getGroup(), "rule__FQNWithWC__Group__0");
			builder.put(grammarAccess.getMainAccess().getElementsAssignment(), "rule__Main__ElementsAssignment");
			builder.put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
			builder.put(grammarAccess.getElementAccess().getNameAssignment_0(), "rule__Element__NameAssignment_0");
			builder.put(grammarAccess.getElementAccess().getContainedAssignment_1_1_0(), "rule__Element__ContainedAssignment_1_1_0");
			builder.put(grammarAccess.getElementAccess().getReferencedAssignment_1_1_1_1(), "rule__Element__ReferencedAssignment_1_1_1_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private RefactoringTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalRefactoringTestLanguageParser createParser() {
		InternalRefactoringTestLanguageParser result = new InternalRefactoringTestLanguageParser(null);
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

	public RefactoringTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RefactoringTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
