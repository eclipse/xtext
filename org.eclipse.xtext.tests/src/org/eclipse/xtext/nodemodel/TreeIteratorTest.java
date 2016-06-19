/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TreeIteratorTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testTreeIteratorForSyntheticNodes_Forward() throws Exception {
		EObject object = getModel("(d - e) / e * d // fasdf s");
		ICompositeNode root = NodeModelUtils.getNode(object).getRootNode();
		INode firstChild = root.getFirstChild();
		INode firstGrandChild = ((ICompositeNode) firstChild).getFirstChild();
		INode firstGrandGrandChild = ((ICompositeNode) firstGrandChild).getFirstChild();
		INode firstGrandGrandGrandChild = ((ICompositeNode) firstGrandGrandChild).getFirstChild();
		INode synthetic = ((ICompositeNode) firstGrandGrandGrandChild).getFirstChild();
		assertTrue(synthetic instanceof SyntheticCompositeNode);
		INode expectedLastChild = ((ICompositeNode)synthetic).getLastChild();
		while(expectedLastChild instanceof ICompositeNode)
			expectedLastChild = ((ICompositeNode)expectedLastChild).getLastChild();
		INode lastChild = null;
		for(INode child: synthetic.getAsTreeIterable())
			lastChild = child;
		assertEquals(expectedLastChild, lastChild);
	}

	@Test public void testTreeIteratorForSyntheticNodes_Backwards() throws Exception {
		EObject object = getModel("d - e / e * d");
		ICompositeNode root = NodeModelUtils.getNode(object).getRootNode();
		INode firstChild = root.getFirstChild();
		INode firstGrandChild = ((ICompositeNode) firstChild).getFirstChild();
		INode sibling = firstGrandChild.getNextSibling().getNextSibling().getNextSibling();
		INode siblingChild = ((ICompositeNode) sibling).getFirstChild();
		INode siblingGrandChild = ((ICompositeNode) siblingChild).getFirstChild();
		INode synthetic = ((ICompositeNode) siblingGrandChild).getFirstChild();
		assertTrue(synthetic instanceof SyntheticCompositeNode);
		INode expectedFirstChild = ((ICompositeNode)synthetic).getFirstChild();
		while(expectedFirstChild instanceof ICompositeNode)
			expectedFirstChild = ((ICompositeNode)expectedFirstChild).getFirstChild();
		INode actualFirstChild = null;
		for(INode child: synthetic.getAsTreeIterable().reverse())
			actualFirstChild = child;
		assertEquals(expectedFirstChild, actualFirstChild);
	}
}
