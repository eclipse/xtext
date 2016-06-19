/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MetamodelTransformationTest extends AbstractXtextTests {

	private String model;
	private Grammar grammar;
	private EPackage pack;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		model = "grammar datatypetests with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"generate metamodel 'http://fooo'\n" +
				"Start:\n" +
				"  id=StartId id2=RecursiveId id3=CalledId value=Value;\n" +
				"StartId returns ecore::EInt: ID '.' (ID|INT);\n" +
				"RecursiveId: ID ('/' RecursiveId)?;\n" +
				"CalledId: StartId '-' ID;\n" +
				"Value: name=StartId;\n" +
				"OnlyKeywords: 'foo';\n" +
				"AssignmentWithAlternative: foo=('1'|'2');\n" +
				"Farbe :\n" + 
				"	 wert=(\"ROT\" | \"BLAU\" | \"GELB\" | \"GRÜN\");\n" +
				"UnorderedGroupDataType: ID & STRING & CalledId & 'keyword';\n" +
				"UnorderedGroupClass: ID & name=STRING & CalledId & 'keyword';\n";
		grammar = (Grammar) getModel(model);
		pack = grammar.getMetamodelDeclarations().get(1).getEPackage();
	}

	@Test public void testSetUp() {
		assertEquals(2, grammar.getMetamodelDeclarations().size());
		assertEquals(10, grammar.getRules().size());
		assertNotNull(pack);
	}

	@Test public void testRuleStartId() {
		ParserRule rule = (ParserRule) grammar.getRules().get(1);
		assertNotNull(rule);
		assertEquals("StartId", rule.getName());
		assertEquals(EcorePackage.Literals.EINT, rule.getType().getClassifier());
	}

	@Test public void testRuleRecursiveId() {
		ParserRule rule = (ParserRule) grammar.getRules().get(2);
		assertNotNull(rule);
		assertEquals("RecursiveId", rule.getName());
		assertEquals(EcorePackage.Literals.ESTRING, rule.getType().getClassifier());
	}

	@Test public void testRuleCalledId() {
		ParserRule rule = (ParserRule) grammar.getRules().get(3);
		assertNotNull(rule);
		assertEquals("CalledId", rule.getName());
		assertEquals(EcorePackage.Literals.ESTRING, rule.getType().getClassifier());
	}

	@Test public void testRuleValue() {
		ParserRule rule = (ParserRule) grammar.getRules().get(4);
		assertNotNull(rule);
		assertEquals("Value", rule.getName());
		assertEquals(pack.getEClassifier("Value"), rule.getType().getClassifier());
	}
	
	@Test public void testOnlyKeywords() {
		ParserRule rule = (ParserRule) grammar.getRules().get(5);
		assertNotNull(rule);
		assertEquals("OnlyKeywords", rule.getName());
		assertEquals(EcorePackage.Literals.ESTRING, rule.getType().getClassifier());
	}
	
	@Test public void testAssignmentWithAlternative() {
		ParserRule rule = (ParserRule) grammar.getRules().get(6);
		assertNotNull(rule);
		assertEquals("AssignmentWithAlternative", rule.getName());
		assertEquals(pack.getEClassifier("AssignmentWithAlternative"), rule.getType().getClassifier());
	}
	
	@Test public void testFarbe() {
		ParserRule rule = (ParserRule) grammar.getRules().get(7);
		assertNotNull(rule);
		assertEquals("Farbe", rule.getName());
		assertEquals(pack.getEClassifier("Farbe"), rule.getType().getClassifier());
	}

	@Test public void testUnorderedGroupDataType() {
		ParserRule rule = (ParserRule) grammar.getRules().get(8);
		assertNotNull(rule);
		assertEquals("UnorderedGroupDataType", rule.getName());
		assertEquals(EcorePackage.Literals.ESTRING, rule.getType().getClassifier());
	}
	
	@Test public void testUnorderedGroupClass() {
		ParserRule rule = (ParserRule) grammar.getRules().get(9);
		assertNotNull(rule);
		assertEquals("UnorderedGroupClass", rule.getName());
		assertEquals(pack.getEClassifier("UnorderedGroupClass"), rule.getType().getClassifier());
	}
}
