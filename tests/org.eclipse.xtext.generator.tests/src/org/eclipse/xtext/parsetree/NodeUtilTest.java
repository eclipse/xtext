/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.List;

import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class NodeUtilTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
	}
	
	public void testFindNodesForFeature() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model : name=ID;");
		List<AbstractNode> nodes = NodeUtil.findNodesForFeature(model, XtextPackage.eINSTANCE.getGrammar_Name());
		assertEquals(1, nodes.size());
		assertEquals("foo.Bar", nodes.get(0).serialize().trim());
		
		nodes = NodeUtil.findNodesForFeature(model, XtextPackage.eINSTANCE.getGrammar_Rules());
		assertEquals(1, nodes.size());
		assertEquals("Model : name=ID;", nodes.get(0).serialize().trim());
		
		AbstractMetamodelDeclaration declaration = model.getMetamodelDeclarations().get(0);
		nodes = NodeUtil.findNodesForFeature(declaration, XtextPackage.eINSTANCE.getGeneratedMetamodel_Name());
		assertEquals(1, nodes.size());
		assertEquals("foo", nodes.get(0).serialize().trim());
		
		
	}
	
	public void testFindNodesForFeature_MultipleFeature() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo.Bar with org.eclipse.xtext.common.Terminals generate foo 'bar' Model : foo=Foo; Foo : name=ID; ");
		List<AbstractNode> nodes = NodeUtil.findNodesForFeature(model, XtextPackage.eINSTANCE.getGrammar_Rules());
		assertEquals(2, nodes.size());
		assertEquals("Model : foo=Foo;", nodes.get(0).serialize().trim());
		assertEquals("Foo : name=ID;", nodes.get(1).serialize().trim());
	}
}
