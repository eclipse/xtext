/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.util.List;

import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class NodeModelUtilsTest extends AbstractXtextTests {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
	}
	
	public void testFindNodesForFeature() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model : name=ID;");
		List<INode> nodes = NodeModelUtils.findNodesForFeature(model, XtextPackage.eINSTANCE.getGrammar_Name());
		assertEquals(1, nodes.size());
		assertEquals("foo.Bar", nodes.get(0).getText().trim());
		
		nodes = NodeModelUtils.findNodesForFeature(model, XtextPackage.eINSTANCE.getGrammar_Rules());
		assertEquals(1, nodes.size());
		assertEquals("Model : name=ID;", nodes.get(0).getText().trim());
		
		AbstractMetamodelDeclaration declaration = model.getMetamodelDeclarations().get(0);
		nodes = NodeModelUtils.findNodesForFeature(declaration, XtextPackage.eINSTANCE.getGeneratedMetamodel_Name());
		assertEquals(1, nodes.size());
		assertEquals("foo", nodes.get(0).getText().trim());
	}
	
	public void testFindNodesForFeature_MultipleFeature() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model : foo=Foo; Foo : name=ID; ");
		List<INode> nodes = NodeModelUtils.findNodesForFeature(model, XtextPackage.eINSTANCE.getGrammar_Rules());
		assertEquals(2, nodes.size());
		assertEquals("Model : foo=Foo;", nodes.get(0).getText().trim());
		assertEquals("Foo : name=ID;", nodes.get(1).getText().trim());
	}
	
	public void testFindNodesForFeature_CallToConcreteRule() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model returns X: name='foo';");
		AbstractRule rule = model.getRules().get(0);
		List<INode> nodes = NodeModelUtils.findNodesForFeature(rule, XtextPackage.eINSTANCE.getAbstractRule_Type());
		assertEquals(1, nodes.size());
		assertEquals("X", nodes.get(0).getText().trim());
	}
	
	public void testFindNodesForFeature_Cardinality_0() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model: name+='foo'*;");
		Assignment assignment = (Assignment) model.getRules().get(0).getAlternatives();
		List<INode> nodes = NodeModelUtils.findNodesForFeature(assignment, XtextPackage.eINSTANCE.getAbstractElement_Cardinality());
		assertEquals(1, nodes.size());
		assertEquals("*", nodes.get(0).getText().trim());
	}
	
	public void testFindNodesForFeature_Cardinality_1() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model: name+='foo'* name+='bar'*;");
		Group group = (Group) model.getRules().get(0).getAlternatives();
		List<INode> nodes = NodeModelUtils.findNodesForFeature(group, XtextPackage.eINSTANCE.getAbstractElement_Cardinality());
		assertEquals(0, nodes.size());
	}
	
	public void testFindNodesForFeature_Cardinality_2() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model: (name+='foo'*)?;");
		Assignment assignment = (Assignment) model.getRules().get(0).getAlternatives();
		List<INode> nodes = NodeModelUtils.findNodesForFeature(assignment, XtextPackage.eINSTANCE.getAbstractElement_Cardinality());
		assertEquals(2, nodes.size());
		assertEquals("*", nodes.get(0).getText());
		assertEquals("?", nodes.get(1).getText());
	}
	
	public void testFindNodesForFeature_Elements() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model:name='foo'|name='bar';");
		Alternatives body = (Alternatives) model.getRules().get(0).getAlternatives();
		List<INode> nodes = NodeModelUtils.findNodesForFeature(body, XtextPackage.eINSTANCE.getCompoundElement_Elements());
		assertEquals(2, nodes.size());
		assertEquals("name='foo'", nodes.get(0).getText());
		assertEquals("name='bar'", nodes.get(1).getText());
	}
	
}
