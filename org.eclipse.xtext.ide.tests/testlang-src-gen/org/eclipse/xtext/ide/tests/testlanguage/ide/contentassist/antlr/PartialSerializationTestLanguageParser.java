/*
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractPartialContentAssistParser;
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal.InternalPartialSerializationTestLanguageParser;
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialSerializationTestLanguageGrammarAccess;

public class PartialSerializationTestLanguageParser extends AbstractPartialContentAssistParser {

	@Inject
	private PartialSerializationTestLanguageGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalPartialSerializationTestLanguageParser createParser() {
		InternalPartialSerializationTestLanguageParser result = new InternalPartialSerializationTestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
					put(grammarAccess.getNodeAccess().getAlternatives_4(), "rule__Node__Alternatives_4");
					put(grammarAccess.getModelAccess().getGroup_0(), "rule__Model__Group_0__0");
					put(grammarAccess.getModelAccess().getGroup_1(), "rule__Model__Group_1__0");
					put(grammarAccess.getModelAccess().getGroup_2(), "rule__Model__Group_2__0");
					put(grammarAccess.getModelAccess().getGroup_3(), "rule__Model__Group_3__0");
					put(grammarAccess.getModelAccess().getGroup_4(), "rule__Model__Group_4__0");
					put(grammarAccess.getModelAccess().getGroup_5(), "rule__Model__Group_5__0");
					put(grammarAccess.getModelAccess().getGroup_6(), "rule__Model__Group_6__0");
					put(grammarAccess.getModelAccess().getGroup_7(), "rule__Model__Group_7__0");
					put(grammarAccess.getModelAccess().getGroup_8(), "rule__Model__Group_8__0");
					put(grammarAccess.getModelAccess().getGroup_9(), "rule__Model__Group_9__0");
					put(grammarAccess.getModelAccess().getGroup_10(), "rule__Model__Group_10__0");
					put(grammarAccess.getOptionalValueAccess().getGroup(), "rule__OptionalValue__Group__0");
					put(grammarAccess.getManyOptionalValuesAccess().getGroup(), "rule__ManyOptionalValues__Group__0");
					put(grammarAccess.getOptionalChildAccess().getGroup(), "rule__OptionalChild__Group__0");
					put(grammarAccess.getOptionalChildListAccess().getGroup(), "rule__OptionalChildList__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getNodeAccess().getGroup(), "rule__Node__Group__0");
					put(grammarAccess.getNodeAccess().getGroup_3(), "rule__Node__Group_3__0");
					put(grammarAccess.getNodeAccess().getGroup_4_0(), "rule__Node__Group_4_0__0");
					put(grammarAccess.getNodeAccess().getGroup_4_0_2(), "rule__Node__Group_4_0_2__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getModelAccess().getClazzAssignment_9_1(), "rule__Model__ClazzAssignment_9_1");
					put(grammarAccess.getMandatoryValueAccess().getNameAssignment(), "rule__MandatoryValue__NameAssignment");
					put(grammarAccess.getOptionalValueAccess().getNameAssignment_2(), "rule__OptionalValue__NameAssignment_2");
					put(grammarAccess.getManyOptionalValuesAccess().getNameAssignment_1(), "rule__ManyOptionalValues__NameAssignment_1");
					put(grammarAccess.getManyMandatoryValuesAccess().getNameAssignment(), "rule__ManyMandatoryValues__NameAssignment");
					put(grammarAccess.getMandatoryChildAccess().getChildAssignment(), "rule__MandatoryChild__ChildAssignment");
					put(grammarAccess.getOptionalChildAccess().getChildAssignment_1(), "rule__OptionalChild__ChildAssignment_1");
					put(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment(), "rule__MandatoryChildList__ChildrenAssignment");
					put(grammarAccess.getOptionalChildListAccess().getChildrenAssignment_1(), "rule__OptionalChildList__ChildrenAssignment_1");
					put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
					put(grammarAccess.getNodeAccess().getImportsAssignment_1(), "rule__Node__ImportsAssignment_1");
					put(grammarAccess.getNodeAccess().getNameAssignment_2(), "rule__Node__NameAssignment_2");
					put(grammarAccess.getNodeAccess().getRefsAssignment_3_1(), "rule__Node__RefsAssignment_3_1");
					put(grammarAccess.getNodeAccess().getChildrenAssignment_4_0_1(), "rule__Node__ChildrenAssignment_4_0_1");
					put(grammarAccess.getNodeAccess().getRefAssignment_4_0_2_1(), "rule__Node__RefAssignment_4_0_2_1");
					put(grammarAccess.getEClassDeclAccess().getNameAssignment(), "rule__EClassDecl__NameAssignment");
					put(grammarAccess.getEClassRefAccess().getRefAssignment(), "rule__EClassRef__RefAssignment");
				}
			};
		}
		return nameMappings.get(element);
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
}
