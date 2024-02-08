/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug360834TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug360834TestLanguageGrammarAccess;

public class Bug360834TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug360834TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug360834TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			builder.put(grammarAccess.getAlternativeClassModifiersAccess().getAlternatives_1(), "rule__AlternativeClassModifiers__Alternatives_1");
			builder.put(grammarAccess.getVisibilityAccess().getAlternatives(), "rule__Visibility__Alternatives");
			builder.put(grammarAccess.getModelAccess().getGroup_0(), "rule__Model__Group_0__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1(), "rule__Model__Group_1__0");
			builder.put(grammarAccess.getAlternativeAccess().getGroup(), "rule__Alternative__Group__0");
			builder.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			builder.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			builder.put(grammarAccess.getRecursiveClassDeclarationAccess().getGroup(), "rule__RecursiveClassDeclaration__Group__0");
			builder.put(grammarAccess.getAlternativeClassModifiersAccess().getGroup(), "rule__AlternativeClassModifiers__Group__0");
			builder.put(grammarAccess.getUnorderedAccess().getGroup(), "rule__Unordered__Group__0");
			builder.put(grammarAccess.getSimpleClassDeclarationAccess().getGroup(), "rule__SimpleClassDeclaration__Group__0");
			builder.put(grammarAccess.getClassMemberAccess().getGroup(), "rule__ClassMember__Group__0");
			builder.put(grammarAccess.getUnorderedModifiersAccess().getGroup(), "rule__UnorderedModifiers__Group__0");
			builder.put(grammarAccess.getModelAccess().getElementAssignment_0_1(), "rule__Model__ElementAssignment_0_1");
			builder.put(grammarAccess.getModelAccess().getElementAssignment_1_1(), "rule__Model__ElementAssignment_1_1");
			builder.put(grammarAccess.getAlternativeAccess().getNameAssignment_1(), "rule__Alternative__NameAssignment_1");
			builder.put(grammarAccess.getAlternativeAccess().getRootDeclarationAssignment_3(), "rule__Alternative__RootDeclarationAssignment_3");
			builder.put(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAssignment_0(), "rule__RecursiveClassDeclaration__ModifiersAssignment_0");
			builder.put(grammarAccess.getRecursiveClassDeclarationAccess().getNameAssignment_2(), "rule__RecursiveClassDeclaration__NameAssignment_2");
			builder.put(grammarAccess.getRecursiveClassDeclarationAccess().getMembersAssignment_4(), "rule__RecursiveClassDeclaration__MembersAssignment_4");
			builder.put(grammarAccess.getAlternativeClassModifiersAccess().getFinalAssignment_1_0(), "rule__AlternativeClassModifiers__FinalAssignment_1_0");
			builder.put(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAssignment_1_1(), "rule__AlternativeClassModifiers__AbstractAssignment_1_1");
			builder.put(grammarAccess.getAlternativeClassModifiersAccess().getExternAssignment_1_2(), "rule__AlternativeClassModifiers__ExternAssignment_1_2");
			builder.put(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityAssignment_1_3(), "rule__AlternativeClassModifiers__VisibilityAssignment_1_3");
			builder.put(grammarAccess.getUnorderedAccess().getNameAssignment_1(), "rule__Unordered__NameAssignment_1");
			builder.put(grammarAccess.getUnorderedAccess().getRootDeclarationAssignment_3(), "rule__Unordered__RootDeclarationAssignment_3");
			builder.put(grammarAccess.getSimpleClassDeclarationAccess().getModifiersAssignment_0(), "rule__SimpleClassDeclaration__ModifiersAssignment_0");
			builder.put(grammarAccess.getSimpleClassDeclarationAccess().getNameAssignment_2(), "rule__SimpleClassDeclaration__NameAssignment_2");
			builder.put(grammarAccess.getSimpleClassDeclarationAccess().getMembersAssignment_4(), "rule__SimpleClassDeclaration__MembersAssignment_4");
			builder.put(grammarAccess.getClassMemberAccess().getModifiersAssignment_0(), "rule__ClassMember__ModifiersAssignment_0");
			builder.put(grammarAccess.getClassMemberAccess().getNameAssignment_2(), "rule__ClassMember__NameAssignment_2");
			builder.put(grammarAccess.getUnorderedModifiersAccess().getFinalAssignment_1_0(), "rule__UnorderedModifiers__FinalAssignment_1_0");
			builder.put(grammarAccess.getUnorderedModifiersAccess().getAbstractAssignment_1_1(), "rule__UnorderedModifiers__AbstractAssignment_1_1");
			builder.put(grammarAccess.getUnorderedModifiersAccess().getExternAssignment_1_2(), "rule__UnorderedModifiers__ExternAssignment_1_2");
			builder.put(grammarAccess.getUnorderedModifiersAccess().getVisibilityAssignment_1_3(), "rule__UnorderedModifiers__VisibilityAssignment_1_3");
			builder.put(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), "rule__UnorderedModifiers__UnorderedGroup_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug360834TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug360834TestLanguageParser createParser() {
		InternalBug360834TestLanguageParser result = new InternalBug360834TestLanguageParser(null);
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

	public Bug360834TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug360834TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
