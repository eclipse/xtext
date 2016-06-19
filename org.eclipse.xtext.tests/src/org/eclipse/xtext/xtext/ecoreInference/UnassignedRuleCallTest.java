/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.Model;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.ModelFeatures;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnassignedRuleCallTest extends AbstractXtextTests {

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(UnassignedRuleCallTestLanguageStandaloneSetup.class);
	}

	@Test public void testParseModel_01() throws Exception {
		String modelAsText = "model 7 feature Zonk 1 keyword 1;";
		Model model = (Model) getModel(modelAsText);
		assertNotNull(model);
		assertNotNull(model.getModelFeatures());
		assertEquals("Zonk", model.getModelFeatures().getName());
	}

	@Test public void testParseModel_02() throws Exception {
		String modelAsText = "model 7 13 feature Foo 1 keyword 1 'bar';";
		Model model = (Model) getModel(modelAsText);
		assertNotNull(model);
		assertNotNull(model.getModelFeatures());
		assertEquals("Foo", model.getModelFeatures().getName());
	}

	@Test public void testParseModel_03() throws Exception {
		String modelAsText = "model 7 feature Zonk 1 keyword 1;";
		XtextResource resource = getResourceFromString(modelAsText);
		assertTrue(resource.getErrors().isEmpty());
	}

	@Test public void testParseModel_04() throws Exception {
		String modelAsText = "model 7 13 137 feature Foo 1 keyword 1 'bar';";
		XtextResource resource = getResourceFromString(modelAsText);
		assertTrue(resource.getErrors().isEmpty());
	}

	@Test public void testNodeModel_01() throws Exception {
		String modelAsText = "model 7 feature Zonk 1 keyword 1;";
		Model model = (Model) getModel(modelAsText);
		ICompositeNode node = NodeModelUtils.getNode(model);
		assertEquals(4, Iterables.size(node.getChildren()));
		ModelFeatures modelFeatures = model.getModelFeatures();
		ICompositeNode featuresNode = NodeModelUtils.getNode(modelFeatures);
		assertSame(featuresNode, Iterables.get(node.getChildren(), 3));
		assertEquals(6, Iterables.size(featuresNode.getChildren()));
		ICompositeNode dataTypeNode = (ICompositeNode) Iterables.get(featuresNode.getChildren(), 4);
		assertEquals(6, Iterables.size(dataTypeNode.getChildren()));
	}

	@Test public void testNodeModel_02() throws Exception {
		String modelAsText = "model 7 13 137 feature Foo 1 keyword 1 'bar';";
		Model model = (Model) getModel(modelAsText);
		ICompositeNode node = NodeModelUtils.getNode(model);
		assertEquals(8, Iterables.size(node.getChildren()));
		ModelFeatures modelFeatures = model.getModelFeatures();
		ICompositeNode featuresNode = NodeModelUtils.getNode(modelFeatures);
		assertSame(featuresNode, Iterables.get(node.getChildren(), 7));
		assertEquals(6, Iterables.size(featuresNode.getChildren()));
		ICompositeNode dataTypeNode = (ICompositeNode) Iterables.get(featuresNode.getChildren(), 4);
		assertEquals(8, Iterables.size(dataTypeNode.getChildren()));
	}
}
