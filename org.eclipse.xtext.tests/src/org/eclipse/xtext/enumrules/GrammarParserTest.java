/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.enumrules;

import java.util.List;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.enumrules.enums.ExistingEnum;
import org.eclipse.xtext.xtext.ecoreInference.TransformationDiagnostic;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarParserTest extends AbstractEnumRulesTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	private void checkEnums(Grammar grammar) {
		List<EnumLiteralDeclaration> decls = EcoreUtil2.getAllContentsOfType(grammar, EnumLiteralDeclaration.class);
		for(EnumLiteralDeclaration decl: decls) {
			assertNotNull(decl.getLiteral());
		}
	}
	
	@Test public void testEnum_01() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/1'\n" +
			"Model: enumValue=MyEnum;\n" +
			"enum MyEnum: Value1;";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		checkEnums(grammar);
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/1", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("MyEnum");
		assertNotNull(eEnum);
		assertEquals(1, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals("Value1", value.getName());
		assertEquals(0, value.getValue());
		assertEquals("Value1", value.getLiteral());
	}
	
	@Test public void testEnum_02() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/2'\n" +
			"Model: enumValue=MyEnumRule;\n" +
			"enum MyEnumRule returns MyEnum: Value1;";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		checkEnums(grammar);
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/2", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("MyEnum");
		assertNotNull(eEnum);
		assertEquals(1, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals("Value1", value.getName());
		assertEquals(0, value.getValue());
		assertEquals("Value1", value.getLiteral());
	}
	
	@Test public void testEnum_03() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/3'\n" +
			"Model: enumValue=MyEnumRule;\n" +
			"enum MyEnumRule returns MyEnum: Value1 = 'value';";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		checkEnums(grammar);
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/3", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("MyEnum");
		assertNotNull(eEnum);
		assertEquals(1, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals("Value1", value.getName());
		assertEquals(0, value.getValue());
		assertEquals("value", value.getLiteral());
	}
	
	@Test public void testEnum_04() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/4'\n" +
			"Model: enumValue=ExistingEnum;\n" +
			"enum ExistingEnum: SameName;";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		checkEnums(grammar);
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/EnumRulesTestLanguage/imported", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("ExistingEnum");
		assertNotNull(eEnum);
		assertEquals(3, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals(ExistingEnum.SAME_NAME.getName(), value.getName());
		assertEquals(ExistingEnum.SAME_NAME.getValue(), value.getValue());
		assertEquals(ExistingEnum.SAME_NAME.getLiteral(), value.getLiteral());
		
		EnumRule rule = (EnumRule) grammar.getRules().get(1);
		assertEquals(eEnum, rule.getType().getClassifier());
		EnumLiteralDeclaration decl = (EnumLiteralDeclaration) rule.getAlternatives();
		assertEquals(value, decl.getEnumLiteral());
		assertNotNull(decl.getLiteral());
		assertEquals(value.getLiteral(), decl.getLiteral().getValue());
	}
	
	@Test public void testEnum_05() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/5'\n" +
			"Model: enumValue=ExistingEnum;\n" +
			"enum ExistingEnum: SameName = 'value';";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		checkEnums(grammar);
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/EnumRulesTestLanguage/imported", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("ExistingEnum");
		assertNotNull(eEnum);
		assertEquals(3, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals(ExistingEnum.SAME_NAME.getName(), value.getName());
		assertEquals(ExistingEnum.SAME_NAME.getValue(), value.getValue());
		assertEquals(ExistingEnum.SAME_NAME.getLiteral(), value.getLiteral());
		
		EnumRule rule = (EnumRule) grammar.getRules().get(1);
		assertEquals(eEnum, rule.getType().getClassifier());
		EnumLiteralDeclaration decl = (EnumLiteralDeclaration) rule.getAlternatives();
		assertEquals(value, decl.getEnumLiteral());
		assertNotNull(decl.getLiteral());
		assertEquals("value", decl.getLiteral().getValue());
	}
	
	@Test public void testEnum_06() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/6'\n" +
			"Model: enumValue=MyEnum;\n" +
			"enum MyEnum: Value1 | Value2='value' | Value3;";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		checkEnums(grammar);
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/6", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("MyEnum");
		assertNotNull(eEnum);
		assertEquals(3, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals("Value1", value.getName());
		assertEquals(0, value.getValue());
		assertEquals("Value1", value.getLiteral());
		
		value = eEnum.getELiterals().get(1);
		assertEquals("Value2", value.getName());
		assertEquals(1, value.getValue());
		assertEquals("value", value.getLiteral());
		
		value = eEnum.getELiterals().get(2);
		assertEquals("Value3", value.getName());
		assertEquals(2, value.getValue());
		assertEquals("Value3", value.getLiteral());
	}
	
	@Test public void testEnum_07() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/7'\n" +
			"Model: enumValue=MyEnum;\n" +
			"enum MyEnum: Value | Value;";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		checkEnums(grammar);
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/7", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("MyEnum");
		assertNotNull(eEnum);
		assertEquals(1, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals("Value", value.getName());
		assertEquals(0, value.getValue());
		assertEquals("Value", value.getLiteral());
	}
	
	@Test public void testEnum_08() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/8'\n" +
			"Model: enumValue=MyEnum;\n" +
			"enum MyEnum: Value | Value = 'foo';";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		checkEnums(grammar);
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/8", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("MyEnum");
		assertNotNull(eEnum);
		assertEquals(1, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals("Value", value.getName());
		assertEquals(0, value.getValue());
		assertEquals("Value", value.getLiteral());
	}
	
	@Test public void testEnum_09() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/9'\n" +
			"Model: enumValue=ExistingEnum;\n" +
			"enum ExistingEnum: SameName | Absent | SameName;";
		Grammar grammar = (Grammar) getModelAndExpect(modelAsString, 1);
		assertEquals(grammar.eResource().getErrors().toString(), 1, grammar.eResource().getErrors().size());
		TransformationDiagnostic diag = (TransformationDiagnostic) grammar.eResource().getErrors().get(0);
		int offset = diag.getOffset();
		assertEquals(modelAsString.lastIndexOf("Absent"), offset);
	}
	
	@Test public void testEnum_10() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
			"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/10'\n" +
			"Model: enumValue=ExistingEnum;\n" +
			"enum ExistingEnum: SameName;";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		checkEnums(grammar);
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/EnumRulesTestLanguage/imported", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("ExistingEnum");
		assertNotNull(eEnum);
		assertEquals(3, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals(ExistingEnum.SAME_NAME.getName(), value.getName());
		assertEquals(ExistingEnum.SAME_NAME.getValue(), value.getValue());
		assertEquals(ExistingEnum.SAME_NAME.getLiteral(), value.getLiteral());
		
		EnumRule rule = (EnumRule) grammar.getRules().get(1);
		assertEquals(eEnum, rule.getType().getClassifier());
		EnumLiteralDeclaration decl = (EnumLiteralDeclaration) rule.getAlternatives();
		assertEquals(value, decl.getEnumLiteral());
		assertNotNull(decl.getLiteral());
		assertEquals("SameName", decl.getLiteral().getValue());
	}
	
	@Test public void testEnum_11() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.enumrules.EnumRulesTestLanguage\n" +
			"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore' as existing\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/AbstractEnumRulesTest/TestEnum/11'\n" +
			"Model: enumValue=ExistingEnum;\n" +
			"enum ExistingEnum: SameName;";
		Grammar grammar = (Grammar) getModelAndExpect(modelAsString, 1);
		assertEquals(grammar.eResource().getErrors().toString(), 1, grammar.eResource().getErrors().size());
		TransformationDiagnostic diag = (TransformationDiagnostic) grammar.eResource().getErrors().get(0);
		int offset = diag.getOffset();
		assertEquals(modelAsString.lastIndexOf("ExistingEnum"), offset);
	}
}
