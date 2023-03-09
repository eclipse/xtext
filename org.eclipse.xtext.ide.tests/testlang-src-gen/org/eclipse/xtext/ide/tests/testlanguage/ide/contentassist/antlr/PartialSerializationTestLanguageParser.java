/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractPartialContentAssistParser;
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal.InternalPartialSerializationTestLanguageParser;
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialSerializationTestLanguageGrammarAccess;

public class PartialSerializationTestLanguageParser extends AbstractPartialContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(PartialSerializationTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, PartialSerializationTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			builder.put(grammarAccess.getNodeAccess().getAlternatives_4(), "rule__Node__Alternatives_4");
			builder.put(grammarAccess.getModelAccess().getGroup_0(), "rule__Model__Group_0__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1(), "rule__Model__Group_1__0");
			builder.put(grammarAccess.getModelAccess().getGroup_2(), "rule__Model__Group_2__0");
			builder.put(grammarAccess.getModelAccess().getGroup_3(), "rule__Model__Group_3__0");
			builder.put(grammarAccess.getModelAccess().getGroup_4(), "rule__Model__Group_4__0");
			builder.put(grammarAccess.getModelAccess().getGroup_5(), "rule__Model__Group_5__0");
			builder.put(grammarAccess.getModelAccess().getGroup_6(), "rule__Model__Group_6__0");
			builder.put(grammarAccess.getModelAccess().getGroup_7(), "rule__Model__Group_7__0");
			builder.put(grammarAccess.getModelAccess().getGroup_8(), "rule__Model__Group_8__0");
			builder.put(grammarAccess.getModelAccess().getGroup_9(), "rule__Model__Group_9__0");
			builder.put(grammarAccess.getModelAccess().getGroup_10(), "rule__Model__Group_10__0");
			builder.put(grammarAccess.getModelAccess().getGroup_11(), "rule__Model__Group_11__0");
			builder.put(grammarAccess.getModelAccess().getGroup_12(), "rule__Model__Group_12__0");
			builder.put(grammarAccess.getModelAccess().getGroup_13(), "rule__Model__Group_13__0");
			builder.put(grammarAccess.getModelAccess().getGroup_14(), "rule__Model__Group_14__0");
			builder.put(grammarAccess.getOptionalValueAccess().getGroup(), "rule__OptionalValue__Group__0");
			builder.put(grammarAccess.getManyOptionalValuesAccess().getGroup(), "rule__ManyOptionalValues__Group__0");
			builder.put(grammarAccess.getOptionalChildAccess().getGroup(), "rule__OptionalChild__Group__0");
			builder.put(grammarAccess.getTwoChildListsAccess().getGroup(), "rule__TwoChildLists__Group__0");
			builder.put(grammarAccess.getTwoChildsAccess().getGroup(), "rule__TwoChilds__Group__0");
			builder.put(grammarAccess.getChildWithSubChildsAccess().getGroup(), "rule__ChildWithSubChilds__Group__0");
			builder.put(grammarAccess.getChildWithSubChildAccess().getGroup(), "rule__ChildWithSubChild__Group__0");
			builder.put(grammarAccess.getOptionalChildListAccess().getGroup(), "rule__OptionalChildList__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getNodeAccess().getGroup(), "rule__Node__Group__0");
			builder.put(grammarAccess.getNodeAccess().getGroup_3(), "rule__Node__Group_3__0");
			builder.put(grammarAccess.getNodeAccess().getGroup_4_0(), "rule__Node__Group_4_0__0");
			builder.put(grammarAccess.getNodeAccess().getGroup_4_0_2(), "rule__Node__Group_4_0_2__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getModelAccess().getClazzAssignment_9_1(), "rule__Model__ClazzAssignment_9_1");
			builder.put(grammarAccess.getMandatoryValueAccess().getNameAssignment(), "rule__MandatoryValue__NameAssignment");
			builder.put(grammarAccess.getOptionalValueAccess().getNameAssignment_2(), "rule__OptionalValue__NameAssignment_2");
			builder.put(grammarAccess.getManyOptionalValuesAccess().getNameAssignment_1(), "rule__ManyOptionalValues__NameAssignment_1");
			builder.put(grammarAccess.getManyMandatoryValuesAccess().getNameAssignment(), "rule__ManyMandatoryValues__NameAssignment");
			builder.put(grammarAccess.getMandatoryChildAccess().getChildAssignment(), "rule__MandatoryChild__ChildAssignment");
			builder.put(grammarAccess.getOptionalChildAccess().getChildAssignment_1(), "rule__OptionalChild__ChildAssignment_1");
			builder.put(grammarAccess.getTwoChildListsAccess().getDirectChildrenAssignment_1(), "rule__TwoChildLists__DirectChildrenAssignment_1");
			builder.put(grammarAccess.getTwoChildListsAccess().getChildsListAssignment_4(), "rule__TwoChildLists__ChildsListAssignment_4");
			builder.put(grammarAccess.getTwoChildsAccess().getDirectChildAssignment_3(), "rule__TwoChilds__DirectChildAssignment_3");
			builder.put(grammarAccess.getTwoChildsAccess().getOptChildAssignment_6(), "rule__TwoChilds__OptChildAssignment_6");
			builder.put(grammarAccess.getChildWithSubChildsAccess().getChildrenAssignment_1(), "rule__ChildWithSubChilds__ChildrenAssignment_1");
			builder.put(grammarAccess.getChildWithSubChildAccess().getSubChildsAssignment_2(), "rule__ChildWithSubChild__SubChildsAssignment_2");
			builder.put(grammarAccess.getSubChildAccess().getNameAssignment(), "rule__SubChild__NameAssignment");
			builder.put(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment(), "rule__MandatoryChildList__ChildrenAssignment");
			builder.put(grammarAccess.getOptionalChildListAccess().getChildrenAssignment_1(), "rule__OptionalChildList__ChildrenAssignment_1");
			builder.put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
			builder.put(grammarAccess.getNodeAccess().getImportsAssignment_1(), "rule__Node__ImportsAssignment_1");
			builder.put(grammarAccess.getNodeAccess().getNameAssignment_2(), "rule__Node__NameAssignment_2");
			builder.put(grammarAccess.getNodeAccess().getRefsAssignment_3_1(), "rule__Node__RefsAssignment_3_1");
			builder.put(grammarAccess.getNodeAccess().getChildrenAssignment_4_0_1(), "rule__Node__ChildrenAssignment_4_0_1");
			builder.put(grammarAccess.getNodeAccess().getRefAssignment_4_0_2_1(), "rule__Node__RefAssignment_4_0_2_1");
			builder.put(grammarAccess.getEClassDeclAccess().getNameAssignment(), "rule__EClassDecl__NameAssignment");
			builder.put(grammarAccess.getEClassRefAccess().getRefAssignment(), "rule__EClassRef__RefAssignment");
			builder.put(grammarAccess.getWithTransientContainerAccess().getChildAssignment(), "rule__WithTransientContainer__ChildAssignment");
			builder.put(grammarAccess.getWithTransientAccess().getNameAssignment(), "rule__WithTransient__NameAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private PartialSerializationTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalPartialSerializationTestLanguageParser createParser() {
		InternalPartialSerializationTestLanguageParser result = new InternalPartialSerializationTestLanguageParser(null);
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

	public PartialSerializationTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(PartialSerializationTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
