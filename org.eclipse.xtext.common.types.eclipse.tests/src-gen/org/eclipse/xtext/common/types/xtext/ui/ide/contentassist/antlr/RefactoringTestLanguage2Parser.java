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
import org.eclipse.xtext.common.types.xtext.ui.ide.contentassist.antlr.internal.InternalRefactoringTestLanguage2Parser;
import org.eclipse.xtext.common.types.xtext.ui.services.RefactoringTestLanguage2GrammarAccess;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class RefactoringTestLanguage2Parser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(RefactoringTestLanguage2GrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, RefactoringTestLanguage2GrammarAccess grammarAccess) {
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
	private RefactoringTestLanguage2GrammarAccess grammarAccess;

	@Override
	protected InternalRefactoringTestLanguage2Parser createParser() {
		InternalRefactoringTestLanguage2Parser result = new InternalRefactoringTestLanguage2Parser(null);
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

	public RefactoringTestLanguage2GrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RefactoringTestLanguage2GrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
