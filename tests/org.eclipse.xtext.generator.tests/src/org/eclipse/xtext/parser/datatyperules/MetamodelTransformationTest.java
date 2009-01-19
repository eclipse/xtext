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
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MetamodelTransformationTest extends AbstractGeneratorTest {
	
	private String model;
	private Grammar grammar;
	private EPackage pack;

	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		model = "language datatypetests\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"generate metamodel 'http://fooo'\n" +
				"Start:\n" +
				"  id=StartId id2=RecursiveId id3=CalledId value=Value;\n" +
				"StartId returns EInt: ID '.' (ID|INT);\n" +
				"RecursiveId: ID ('/' RecursiveId)?;\n" +
				"CalledId: StartId '-' ID;\n" +
				"Value: name=StartId;";
		grammar = (Grammar) getModel(model);
		pack = grammar.getMetamodelDeclarations().get(1).getEPackage();
	}
	
	public void testSetUp() {
		assertEquals(2, grammar.getMetamodelDeclarations().size());
		assertEquals(5, grammar.getRules().size());
		assertNotNull(pack);
	}
	
	public void testRuleStartId() {
		ParserRule rule = (ParserRule) grammar.getRules().get(1);
		assertNotNull(rule);
		assertEquals("StartId", rule.getName());
		assertEquals(EcorePackage.Literals.EINT, rule.getType().getType());
	}
	
	public void testRuleRecursiveId() {
		ParserRule rule = (ParserRule) grammar.getRules().get(2);
		assertNotNull(rule);
		assertEquals("RecursiveId", rule.getName());
		assertEquals(EcorePackage.Literals.ESTRING, rule.getType().getType());
	}
	
	public void testRuleCalledId() {
		ParserRule rule = (ParserRule) grammar.getRules().get(3);
		assertNotNull(rule);
		assertEquals("CalledId", rule.getName());
		assertEquals(EcorePackage.Literals.ESTRING, rule.getType().getType());
	}
	
	public void testRuleValue() {
		ParserRule rule = (ParserRule) grammar.getRules().get(4);
		assertNotNull(rule);
		assertEquals("Value", rule.getName());
		assertEquals(pack.getEClassifier("Value"), rule.getType().getType());
	}

}
