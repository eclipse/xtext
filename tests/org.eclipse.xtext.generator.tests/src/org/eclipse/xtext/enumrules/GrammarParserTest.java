/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.enumrules;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.enumrules.enums.ExistingEnum;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarParserTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	public void testEnum_01() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest/TestEnum/1'\n" +
			"Model: enumValue=MyEnum;\n" +
			"enum MyEnum: Value1;";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest/TestEnum/1", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("MyEnum");
		assertNotNull(eEnum);
		assertEquals(1, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals("Value1", value.getName());
		assertEquals(0, value.getValue());
		assertEquals("Value1", value.getLiteral());
	}
	
	public void testEnum_02() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest/TestEnum/2'\n" +
			"Model: enumValue=MyEnumRule;\n" +
			"enum MyEnumRule returns MyEnum: Value1;";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest/TestEnum/2", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("MyEnum");
		assertNotNull(eEnum);
		assertEquals(1, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals("Value1", value.getName());
		assertEquals(0, value.getValue());
		assertEquals("Value1", value.getLiteral());
	}
	
	public void testEnum_03() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest/TestEnum/3'\n" +
			"Model: enumValue=MyEnumRule;\n" +
			"enum MyEnumRule returns MyEnum: Value1 = 'value';";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
		EPackage pack = grammar.getMetamodelDeclarations().get(0).getEPackage();
		assertEquals("http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest/TestEnum/3", pack.getNsURI());
		EEnum eEnum = (EEnum) pack.getEClassifier("MyEnum");
		assertNotNull(eEnum);
		assertEquals(1, eEnum.getELiterals().size());
		EEnumLiteral value = eEnum.getELiterals().get(0);
		assertEquals("Value1", value.getName());
		assertEquals(0, value.getValue());
		assertEquals("value", value.getLiteral());
	}
	
	public void testEnum_04() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest/TestEnum/4'\n" +
			"Model: enumValue=ExistingEnum;\n" +
			"enum ExistingEnum: SameName;";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
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
	
	public void testEnum_05() throws Exception {
		String modelAsString =
			"grammar TestLanguage with org.eclipse.xtext.common.Terminals\n" +
			"import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'\n" +
			"generate testLanguage 'http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest/TestEnum/5'\n" +
			"Model: enumValue=ExistingEnum;\n" +
			"enum ExistingEnum: SameName = 'value';";
		Grammar grammar = (Grammar) getModel(modelAsString);
		assertTrue(grammar.eResource().getErrors().toString(), grammar.eResource().getErrors().isEmpty());
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
}
