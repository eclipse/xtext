/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.common.types.xtext.ui.ide.contentassist.antlr.internal.InternalRefactoringTestLanguageParser;
import org.eclipse.xtext.common.types.xtext.ui.services.RefactoringTestLanguageGrammarAccess;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

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
			builder.put(grammarAccess.getReferenceHolderAccess().getGroup(), "rule__ReferenceHolder__Group__0");
			builder.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			builder.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			builder.put(grammarAccess.getFQNAccess().getGroup_2(), "rule__FQN__Group_2__0");
			builder.put(grammarAccess.getModelAccess().getReferenceHolderAssignment(), "rule__Model__ReferenceHolderAssignment");
			builder.put(grammarAccess.getReferenceHolderAccess().getNameAssignment_0(), "rule__ReferenceHolder__NameAssignment_0");
			builder.put(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1(), "rule__ReferenceHolder__DefaultReferenceAssignment_1");
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
