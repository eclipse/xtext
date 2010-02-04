/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeContentAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParsetreeFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsetreeUtilTest extends AbstractXtextTests {

	private String modelAsString;
	private Grammar grammar;
	private CompositeNode grammarNode;
	private CompositeNode metamodelNode;
	private CompositeNode parentMetamodelNode;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		modelAsString = "\n" +
				"grammar org.eclipse.xtext.parsetree.impl.LineTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate testLanguage \"http://www.eclipse.org/2009/tmf/xtext/ParsetreeUtilTest\"\n" +
				" \n" +
				"Model:\n" +
				"  name=ID\n" +
				";\n" +
				"\n" +
				"\n";
		grammar = (Grammar) getModel(modelAsString);
		grammarNode = NodeUtil.getNodeAdapter(grammar).getParserNode();
		metamodelNode = NodeUtil.getNodeAdapter(grammar.getMetamodelDeclarations().get(0)).getParserNode();
		parentMetamodelNode = metamodelNode.getParent();
	}
	
	@Override
	protected void tearDown() throws Exception {
		grammar = null;
		modelAsString = null;
		grammarNode = null;
		metamodelNode = null;
		parentMetamodelNode = null;
		super.tearDown();
	}
	
	public void testSetup() {
		assertNotNull(grammar);
		assertNotNull(grammarNode);
		assertNotNull(metamodelNode);
		assertNotNull(parentMetamodelNode);
		assertNotSame(parentMetamodelNode, grammarNode);
		assertTrue(grammar.eResource().getErrors().isEmpty());
	}
	
	public void testLine_01() {
		assertEquals(2, grammarNode.getLine());
	}
	
	public void testLine_02() {
		assertEquals(4, metamodelNode.getLine());
	}
	
	public void testLine_03() {
		assertEquals(4, parentMetamodelNode.getLine());
	}
	
	public void testTotalLine_01() {
		assertEquals(1, grammarNode.getTotalLine());
	}
	
	public void testTotalLine_02() {
		assertEquals(2, metamodelNode.getTotalLine());
	}
	
	public void testTotalLine_03() {
		assertEquals(2, parentMetamodelNode.getTotalLine());
	}
	
	public void testEndLine_01() {
		assertEquals(8, grammarNode.endLine());
	}
	
	public void testEndLine_02() {
		assertEquals(4, metamodelNode.endLine());
	}
	
	public void testEndLine_03() {
		assertEquals(4, parentMetamodelNode.endLine());
	}
	
	public void testTotalEndLine_01() {
		assertEquals(11, grammarNode.totalEndLine());
	}
	
	public void testTotalEndLine_02() {
		assertEquals(4, metamodelNode.totalEndLine());
	}
	
	public void testTotalEndLine_03() {
		assertEquals(4, parentMetamodelNode.totalEndLine());
	}
	
	public void testOffset_01() {
		assertEquals(modelAsString.indexOf("grammar"), grammarNode.getOffset());
	}
	
	public void testOffset_02() {
		assertEquals(modelAsString.indexOf("generate"), metamodelNode.getOffset());
	}
	
	public void testOffset_03() {
		assertEquals(modelAsString.indexOf("generate"), parentMetamodelNode.getOffset());
	}
	
	public void testTotalOffset_01() {
		assertEquals(0, grammarNode.getTotalOffset());
	}
	
	public void testTotalOffset_02() {
		assertEquals(modelAsString.indexOf("\n\ngenerate"), metamodelNode.getTotalOffset());
	}
	
	public void testTotalOffset_03() {
		assertEquals(modelAsString.indexOf("\n\ngenerate"), parentMetamodelNode.getTotalOffset());
	}
	
	public void testLength_01() {
		assertEquals(modelAsString.indexOf(';') - modelAsString.indexOf("grammar") + ";".length(), grammarNode.getLength());
	}
	
	public void testLength_02() {
		assertEquals(
				modelAsString.indexOf("ParsetreeUtilTest\"") - modelAsString.indexOf("generate") + "ParsetreeUtilTest\"".length(),
				metamodelNode.getLength());
	}
	
	public void testLength_03() {
		assertEquals(
				modelAsString.indexOf("ParsetreeUtilTest\"") - modelAsString.indexOf("generate") + "ParsetreeUtilTest\"".length(),
				parentMetamodelNode.getLength());
	}
	
	public void testLength_04() {
		CompositeNode newRootNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
		newRootNode.getChildren().add(grammarNode);
		NodeContentAdapter.createAdapterAndAddToNode(newRootNode);
		assertEquals(
				modelAsString.indexOf(';') - modelAsString.indexOf("grammar") + ";".length(),
				newRootNode.getLength());
	}
	
	public void testTotalLength_01() {
		assertEquals(modelAsString.length(), grammarNode.getTotalLength());
	}
	
	public void testTotalLength_02() {
		assertEquals(
				modelAsString.indexOf("ParsetreeUtilTest\"") - modelAsString.indexOf("\n\ngenerate") + "ParsetreeUtilTest\"".length(),
				metamodelNode.getTotalLength());
	}
	
	public void testTotalLength_03() {
		assertEquals(
				modelAsString.indexOf("ParsetreeUtilTest\"") - modelAsString.indexOf("\n\ngenerate") + "ParsetreeUtilTest\"".length(),
				parentMetamodelNode.getTotalLength());
	}
	
	public void testTotalLength_04() {
		CompositeNode newRootNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
		newRootNode.getChildren().add(grammarNode);
		NodeContentAdapter.createAdapterAndAddToNode(newRootNode);
		assertEquals(modelAsString.length(), grammarNode.getTotalLength());
	}
}
