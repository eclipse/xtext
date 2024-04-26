/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal.InternalTestLanguageParser;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;

public class TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(TestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, TestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getAbstractElementAccess().getAlternatives(), "rule__AbstractElement__Alternatives");
			mappings.put(grammarAccess.getMemberAccess().getAlternatives(), "rule__Member__Alternatives");
			mappings.put(grammarAccess.getTypeAccess().getAlternatives_0(), "rule__Type__Alternatives_0");
			mappings.put(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_0(), "rule__PrimitiveType__NameAlternatives_0");
			mappings.put(grammarAccess.getPackageDeclarationAccess().getGroup(), "rule__PackageDeclaration__Group__0");
			mappings.put(grammarAccess.getTypeDeclarationAccess().getGroup(), "rule__TypeDeclaration__Group__0");
			mappings.put(grammarAccess.getTypeDeclarationAccess().getGroup_2(), "rule__TypeDeclaration__Group_2__0");
			mappings.put(grammarAccess.getPropertyAccess().getGroup(), "rule__Property__Group__0");
			mappings.put(grammarAccess.getTypeAccess().getGroup(), "rule__Type__Group__0");
			mappings.put(grammarAccess.getTypeAccess().getGroup_1(), "rule__Type__Group_1__0");
			mappings.put(grammarAccess.getOperationAccess().getGroup(), "rule__Operation__Group__0");
			mappings.put(grammarAccess.getOperationAccess().getGroup_4(), "rule__Operation__Group_4__0");
			mappings.put(grammarAccess.getOperationAccess().getGroup_4_1(), "rule__Operation__Group_4_1__0");
			mappings.put(grammarAccess.getOperationAccess().getGroup_6(), "rule__Operation__Group_6__0");
			mappings.put(grammarAccess.getOperationCallAccess().getGroup(), "rule__OperationCall__Group__0");
			mappings.put(grammarAccess.getOperationCallAccess().getGroup_2(), "rule__OperationCall__Group_2__0");
			mappings.put(grammarAccess.getOperationCallAccess().getGroup_2_1(), "rule__OperationCall__Group_2_1__0");
			mappings.put(grammarAccess.getParameterAccess().getGroup(), "rule__Parameter__Group__0");
			mappings.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			mappings.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			mappings.put(grammarAccess.getModelAccess().getElementsAssignment(), "rule__Model__ElementsAssignment");
			mappings.put(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1(), "rule__PackageDeclaration__NameAssignment_1");
			mappings.put(grammarAccess.getPackageDeclarationAccess().getElementsAssignment_3(), "rule__PackageDeclaration__ElementsAssignment_3");
			mappings.put(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1(), "rule__TypeDeclaration__NameAssignment_1");
			mappings.put(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1(), "rule__TypeDeclaration__SuperTypeAssignment_2_1");
			mappings.put(grammarAccess.getTypeDeclarationAccess().getMembersAssignment_4(), "rule__TypeDeclaration__MembersAssignment_4");
			mappings.put(grammarAccess.getPropertyAccess().getTypeAssignment_0(), "rule__Property__TypeAssignment_0");
			mappings.put(grammarAccess.getPropertyAccess().getNameAssignment_1(), "rule__Property__NameAssignment_1");
			mappings.put(grammarAccess.getTypeAccess().getArrayDiemensionsAssignment_1_0(), "rule__Type__ArrayDiemensionsAssignment_1_0");
			mappings.put(grammarAccess.getOperationAccess().getNameAssignment_2(), "rule__Operation__NameAssignment_2");
			mappings.put(grammarAccess.getOperationAccess().getParamsAssignment_4_0(), "rule__Operation__ParamsAssignment_4_0");
			mappings.put(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1(), "rule__Operation__ParamsAssignment_4_1_1");
			mappings.put(grammarAccess.getOperationAccess().getReturnTypeAssignment_6_1(), "rule__Operation__ReturnTypeAssignment_6_1");
			mappings.put(grammarAccess.getOperationAccess().getOperationCallAssignment_8(), "rule__Operation__OperationCallAssignment_8");
			mappings.put(grammarAccess.getOperationCallAccess().getOperationAssignment_0(), "rule__OperationCall__OperationAssignment_0");
			mappings.put(grammarAccess.getOperationCallAccess().getParamsAssignment_2_0(), "rule__OperationCall__ParamsAssignment_2_0");
			mappings.put(grammarAccess.getOperationCallAccess().getParamsAssignment_2_1_1(), "rule__OperationCall__ParamsAssignment_2_1_1");
			mappings.put(grammarAccess.getParameterAccess().getNameAssignment_1(), "rule__Parameter__NameAssignment_1");
			mappings.put(grammarAccess.getParameterAccess().getTypeAssignment_3(), "rule__Parameter__TypeAssignment_3");
			mappings.put(grammarAccess.getTypeReferenceAccess().getTypeRefAssignment(), "rule__TypeReference__TypeRefAssignment");
			mappings.put(grammarAccess.getPrimitiveTypeAccess().getNameAssignment(), "rule__PrimitiveType__NameAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalTestLanguageParser createParser() {
		InternalTestLanguageParser result = new InternalTestLanguageParser(null);
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

	public TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
