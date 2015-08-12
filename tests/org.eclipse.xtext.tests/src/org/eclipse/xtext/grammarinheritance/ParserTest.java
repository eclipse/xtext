/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import java.util.List;

import org.eclipse.xtext.grammarinheritance.inheritanceTest.Element;
import org.eclipse.xtext.grammarinheritance.inheritanceTest.InheritanceTestPackage;
import org.eclipse.xtext.grammarinheritance.inheritanceTest.Model;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new InheritanceTest3LanguageStandaloneSetup());
	}
	
	@Test public void test_01() throws Exception {
		Model model = (Model) getModel("model id { element id }");
		assertEquals("id", model.getName());
		Element element = model.getElements().get(0);
		assertEquals("id", element.getName());
		List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(element, InheritanceTestPackage.Literals.ELEMENT__NAME);
		assertTrue(nodesForFeature.size() == 1);
		assertEquals("id", nodesForFeature.get(0).getText());
	}
	
	@Test public void test_02() throws Exception {
		Model model = (Model) getModel("model id { element inheritedIdSyntax }");
		assertEquals("id", model.getName());
		Element element = model.getElements().get(0);
		assertEquals("inheritedIdSyntax", element.getName());
		List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(element, InheritanceTestPackage.Literals.ELEMENT__NAME);
		assertTrue(nodesForFeature.size() == 1);
		assertEquals("inheritedIdSyntax", nodesForFeature.get(0).getText());
	}
	
	@Test public void test_03() throws Exception {
		Model model = (Model) getModel("model id { element 'string' }");
		assertEquals("id", model.getName());
		Element element = model.getElements().get(0);
		assertEquals("string", element.getName());
		List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(element, InheritanceTestPackage.Literals.ELEMENT__NAME);
		assertTrue(nodesForFeature.size() == 1);
		assertEquals("'string'", nodesForFeature.get(0).getText());
	}
	
	@Test public void test_04() throws Exception {
		Model model = (Model) getModel("model id { element 'with spaces' }");
		assertEquals("id", model.getName());
		Element element = model.getElements().get(0);
		assertEquals("with spaces", element.getName());
		List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(element, InheritanceTestPackage.Literals.ELEMENT__NAME);
		assertTrue(nodesForFeature.size() == 1);
		assertEquals("'with spaces'", nodesForFeature.get(0).getText());
	}
}
