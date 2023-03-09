/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.antlr.gh1462Test.Gh1462TestPackage;
import org.eclipse.xtext.parser.antlr.gh1462Test.Root;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule1;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule10;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule11;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule12;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule2;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule3;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule4;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule5;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule6;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule7;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule8;
import org.eclipse.xtext.parser.antlr.gh1462Test.Rule9;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GH1462Test extends AbstractXtextTests{

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(GH1462TestLanguageStandaloneSetup.class);
	}

	@Test
	public void test01() throws Exception {
		Root root = (Root) getModelAndExpect("#1 123 s", 1);
		Rule1 rule1 = (Rule1) root.getElement();
		assertEquals(123, rule1.getLeft());
		assertEquals(0, rule1.getRight());
	}
	
	@Test
	public void test02() throws Exception {
		Root root = (Root) getModelAndExpect("#2 123 s", 1);
		Rule2 rule2 = (Rule2) root.getElement();
		assertEquals(0, rule2.getValue());
	}
	
	@Test
	public void test03() throws Exception {
		Root root = (Root) getModelAndExpect("#3 someId s", 1);
		Rule3 rule3 = (Rule3) root.getElement();
		assertEquals("someId", rule3.getLeft());
		assertEquals(null, rule3.getRight());
	}
	
	@Test
	public void test04() throws Exception {
		Root root = (Root) getModelAndExpect("#4 'someString' s", 1);
		Rule4 rule4 = (Rule4) root.getElement();
		assertEquals("someString", rule4.getLeft());
		assertEquals(null, rule4.getRight());
	}
	
	@Test
	public void test05() throws Exception {
		// This invokes the value converter of INTEGER even though there was nothing parsed.
		// Not superb, but ok.
		Root root = (Root) getModelAndExpect("#5 123 s", 1);
		Rule5 rule5 = (Rule5) root.getElement();
		assertEquals(123, rule5.getLeft());
		assertEquals(0, rule5.getRight());
	}
	
	@Test
	public void test06() throws Exception {
		Root root = (Root) getModelAndExpect("#6 123 s", 1);
		Rule6 rule6 = (Rule6) root.getElement();
		assertEquals(123, rule6.getLeft());
		assertNotNull(rule6.getRight());
		assertEquals(0, rule6.getRight().getValue());
	}
	
	@Test
	public void test07() throws Exception {
		Root root = (Root) getModelAndExpect("#7 123 s", 1);
		Rule7 rule7 = (Rule7) root.getElement();
		assertEquals(123, rule7.getLeft());
		assertFalse(rule7.isRight());
	}
	
	@Test
	public void test08() throws Exception {
		Root root = (Root) getModelAndExpect("#8 123 s", 1);
		Rule8 rule8 = (Rule8) root.getElement();
		assertEquals(123, rule8.getLeft());
		assertFalse(rule8.isRight());
	}
	
	@Test
	public void test09() throws Exception {
		Root root = (Root) getModelAndExpect("#9 123 s", 0);
		Rule9 rule9 = (Rule9) root.getElement();
		assertEquals(123, rule9.getLeft());
		assertEquals("", rule9.getRight());
	}
	
	@Test
	public void test10() throws Exception {
		Root root = (Root) getModelAndExpect("#10 123 s", 0);
		Rule10 rule10 = (Rule10) root.getElement();
		assertEquals(123, rule10.getLeft());
		assertTrue(rule10.isRight());
	}
	
	@Test
	public void test11() throws Exception {
		Root root = (Root) getModelAndExpect("#11 123 s", 1);
		Rule11 rule11 = (Rule11) root.getElement();
		assertEquals(123, rule11.getLeft());
		// TODO (sza, cdi): This should be false instead, or an invalid grammar
		assertTrue(rule11.isRight());
	}
	
	@Test
	public void test12a() throws Exception {
		Root root = (Root) getModelAndExpect("#12 123 s", 1);
		Rule12 rule12 = (Rule12) root.getElement();
		assertEquals(123, rule12.getLeft());
		// TODO (sza, cdi): This should be an invalid grammar instead
		assertTrue(rule12.isRight());
		INode featureNode = NodeModelUtils.findNodesForFeature(rule12, Gh1462TestPackage.Literals.RULE12__RIGHT).get(0);
		assertEquals("", featureNode.getText());
		assertTrue(featureNode.hasDirectSemanticElement());
		EObject element = featureNode.getSemanticElement();
		assertNull(element.eResource());
	}
	
	@Test
	public void test12b() throws Exception {
		disableSerializerTest();
		Root root = (Root) getModel("#12 1 2 s");
		Rule12 rule12 = (Rule12) root.getElement();
		assertEquals(1, rule12.getLeft());
		// TODO (sza, cdi): This should be an invalid grammar instead
		assertTrue(rule12.isRight());
		INode featureNode = NodeModelUtils.findNodesForFeature(rule12, Gh1462TestPackage.Literals.RULE12__RIGHT).get(0);
		assertEquals(" 2", featureNode.getText());
		assertTrue(featureNode.hasDirectSemanticElement());
		EObject element = featureNode.getSemanticElement();
		assertNull(element.eResource());
	}
	
	
}
