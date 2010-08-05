/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.Model;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.ModelFeatures;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnassignedRuleCallTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(UnassignedRuleCallTestLanguageStandaloneSetup.class);
	}
	
	public void testParseModel_01() throws Exception {
		String modelAsText = "model 7 feature Zonk 1 keyword 1;";
		Model model = (Model) getModel(modelAsText);
		assertNotNull(model);
		assertNotNull(model.getModelFeatures());
		assertEquals("Zonk", model.getModelFeatures().getName());
	}
	
	public void testParseModel_02() throws Exception {
		String modelAsText = "model 7 13 feature Foo 1 keyword 1 'bar';";
		Model model = (Model) getModel(modelAsText);
		assertNotNull(model);
		assertNotNull(model.getModelFeatures());
		assertEquals("Foo", model.getModelFeatures().getName());
	}
	
	public void testParseModel_03() throws Exception {
		String modelAsText = "model 7 feature Zonk 1 keyword 1;";
		XtextResource resource = getResourceFromString(modelAsText);
		assertTrue(resource.getErrors().isEmpty());
	}
	
	public void testParseModel_04() throws Exception {
		String modelAsText = "model 7 13 137 feature Foo 1 keyword 1 'bar';";
		XtextResource resource = getResourceFromString(modelAsText);
		assertTrue(resource.getErrors().isEmpty());
	}
	
	public void testNodeModel_01() throws Exception {
		String modelAsText = "model 7 feature Zonk 1 keyword 1;";
		Model model = (Model) getModel(modelAsText);
		CompositeNode node = NodeUtil.getNode(model);
		assertEquals(4, node.getChildren().size());
		ModelFeatures modelFeatures = model.getModelFeatures();
		CompositeNode featuresNode = NodeUtil.getNode(modelFeatures);
		assertSame(featuresNode, node.getChildren().get(3));
		assertEquals(6, featuresNode.getChildren().size());
		CompositeNode dataTypeNode = (CompositeNode) featuresNode.getChildren().get(4);
		assertEquals(6, dataTypeNode.getChildren().size());
	}
	
	public void testNodeModel_02() throws Exception {
		String modelAsText = "model 7 13 137 feature Foo 1 keyword 1 'bar';";
		Model model = (Model) getModel(modelAsText);
		CompositeNode node = NodeUtil.getNode(model);
		assertEquals(8, node.getChildren().size());
		ModelFeatures modelFeatures = model.getModelFeatures();
		CompositeNode featuresNode = NodeUtil.getNode(modelFeatures);
		assertSame(featuresNode, node.getChildren().get(7));
		assertEquals(6, featuresNode.getChildren().size());
		CompositeNode dataTypeNode = (CompositeNode) featuresNode.getChildren().get(4);
		assertEquals(8, dataTypeNode.getChildren().size());
	}
}
