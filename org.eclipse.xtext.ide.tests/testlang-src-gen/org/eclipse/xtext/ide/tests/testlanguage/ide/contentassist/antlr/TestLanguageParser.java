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
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal.InternalTestLanguageParser;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;

public class TestLanguageParser extends AbstractContentAssistParser {

	@Inject
	private TestLanguageGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalTestLanguageParser createParser() {
		InternalTestLanguageParser result = new InternalTestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getMemberAccess().getAlternatives(), "rule__Member__Alternatives");
					put(grammarAccess.getTypeAccess().getAlternatives_0(), "rule__Type__Alternatives_0");
					put(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_0(), "rule__PrimitiveType__NameAlternatives_0");
					put(grammarAccess.getTypeDeclarationAccess().getGroup(), "rule__TypeDeclaration__Group__0");
					put(grammarAccess.getTypeDeclarationAccess().getGroup_2(), "rule__TypeDeclaration__Group_2__0");
					put(grammarAccess.getPropertyAccess().getGroup(), "rule__Property__Group__0");
					put(grammarAccess.getTypeAccess().getGroup(), "rule__Type__Group__0");
					put(grammarAccess.getTypeAccess().getGroup_1(), "rule__Type__Group_1__0");
					put(grammarAccess.getOperationAccess().getGroup(), "rule__Operation__Group__0");
					put(grammarAccess.getOperationAccess().getGroup_4(), "rule__Operation__Group_4__0");
					put(grammarAccess.getOperationAccess().getGroup_4_1(), "rule__Operation__Group_4_1__0");
					put(grammarAccess.getOperationAccess().getGroup_6(), "rule__Operation__Group_6__0");
					put(grammarAccess.getOperationCallAccess().getGroup(), "rule__OperationCall__Group__0");
					put(grammarAccess.getOperationCallAccess().getGroup_2(), "rule__OperationCall__Group_2__0");
					put(grammarAccess.getOperationCallAccess().getGroup_2_1(), "rule__OperationCall__Group_2_1__0");
					put(grammarAccess.getParameterAccess().getGroup(), "rule__Parameter__Group__0");
					put(grammarAccess.getModelAccess().getTypesAssignment(), "rule__Model__TypesAssignment");
					put(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1(), "rule__TypeDeclaration__NameAssignment_1");
					put(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1(), "rule__TypeDeclaration__SuperTypeAssignment_2_1");
					put(grammarAccess.getTypeDeclarationAccess().getMembersAssignment_4(), "rule__TypeDeclaration__MembersAssignment_4");
					put(grammarAccess.getPropertyAccess().getTypeAssignment_0(), "rule__Property__TypeAssignment_0");
					put(grammarAccess.getPropertyAccess().getNameAssignment_1(), "rule__Property__NameAssignment_1");
					put(grammarAccess.getTypeAccess().getArrayDiemensionsAssignment_1_0(), "rule__Type__ArrayDiemensionsAssignment_1_0");
					put(grammarAccess.getOperationAccess().getNameAssignment_2(), "rule__Operation__NameAssignment_2");
					put(grammarAccess.getOperationAccess().getParamsAssignment_4_0(), "rule__Operation__ParamsAssignment_4_0");
					put(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1(), "rule__Operation__ParamsAssignment_4_1_1");
					put(grammarAccess.getOperationAccess().getReturnTypeAssignment_6_1(), "rule__Operation__ReturnTypeAssignment_6_1");
					put(grammarAccess.getOperationAccess().getOperationCallAssignment_8(), "rule__Operation__OperationCallAssignment_8");
					put(grammarAccess.getOperationCallAccess().getOperationAssignment_0(), "rule__OperationCall__OperationAssignment_0");
					put(grammarAccess.getOperationCallAccess().getParamsAssignment_2_0(), "rule__OperationCall__ParamsAssignment_2_0");
					put(grammarAccess.getOperationCallAccess().getParamsAssignment_2_1_1(), "rule__OperationCall__ParamsAssignment_2_1_1");
					put(grammarAccess.getParameterAccess().getNameAssignment_1(), "rule__Parameter__NameAssignment_1");
					put(grammarAccess.getParameterAccess().getTypeAssignment_3(), "rule__Parameter__TypeAssignment_3");
					put(grammarAccess.getTypeReferenceAccess().getTypeRefAssignment(), "rule__TypeReference__TypeRefAssignment");
					put(grammarAccess.getPrimitiveTypeAccess().getNameAssignment(), "rule__PrimitiveType__NameAssignment");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
