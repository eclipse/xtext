/*******************************************************************************
 * Copyright (c) 2020 Robert Lewis and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Robert Lewis - Initial contribution and API
 */
public class BasicNodeIteratorTest {
	
	private static AbstractNode getSingleNode() {
		return new RootNode();
	}
	
	public static AbstractNode nodeWithTwoSiblings() {
		NodeModelBuilder builder = new NodeModelBuilder();
		String text = "alpha beta gamma";
		
		RootNode root = new RootNode();
		root.basicSetCompleteContent(text);
		
		EObject alpha = new EObjectImpl() {};
		builder.newLeafNode(text.indexOf("alpha"), "alpha".length(), alpha, false, null, root);
		
		EObject beta = new EObjectImpl() {};
		builder.newLeafNode(text.indexOf("beta"), "beta".length(), beta, false, null, root);
		
		EObject gamma = new EObjectImpl() {};
		builder.newLeafNode(text.indexOf("gamma"), "gamma".length(), gamma, false, null, root);
		
		return root.basicGetFirstChild();

	}
		
	@Test(expected=NullPointerException.class)
	public void testStartWithNullThrowsNPE() {
		new BasicNodeIterator(null);
	}
	
	@Test
	public void testSingleNodeHasNext() {
		AbstractNode single = getSingleNode();
		BasicNodeIterator it = new BasicNodeIterator(single);
		
		Assert.assertTrue(it.hasNext());
		it.next();
		
		Assert.assertFalse(it.hasNext());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testNextTooFarThrowsException() {
		AbstractNode single = getSingleNode();
		BasicNodeIterator it = new BasicNodeIterator(single);
		
		it.next();

		it.next();
	}

	@Test
	public void testIterateThreeNodes() {
		AbstractNode alpha = nodeWithTwoSiblings();
		BasicNodeIterator it = new BasicNodeIterator(alpha);
		
		Assert.assertTrue(it.hasNext());
		it.next();
		
		Assert.assertTrue(it.hasNext());
		it.next();

		Assert.assertTrue(it.hasNext());
		it.next();
		
		Assert.assertFalse(it.hasNext());
	}
	
	@Test
	public void testSingleNodeHasPrevious() {
		AbstractNode single = getSingleNode();
		BasicNodeIterator it = new BasicNodeIterator(single);
		
		Assert.assertTrue(it.hasPrevious());
		it.previous();
		
		Assert.assertFalse(it.hasPrevious());
	}
	
	@Test
	public void testIteratePreviousStartsWithLastNode() {
		AbstractNode alpha = nodeWithTwoSiblings();
		BasicNodeIterator it = new BasicNodeIterator(alpha);

		INode result = it.previous();
		
		Assert.assertEquals("gamma", result.getText());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testPreviousTooFarThrowsException() {
		AbstractNode single = getSingleNode();
		BasicNodeIterator it = new BasicNodeIterator(single);
		
		it.previous();

		it.previous();
	}
	
	@Test
	public void testIterateThreeNodesInReverse() {
		AbstractNode alpha = nodeWithTwoSiblings();
		BasicNodeIterator it = new BasicNodeIterator(alpha);
		
		Assert.assertTrue(it.hasPrevious());
		it.previous();
		
		Assert.assertTrue(it.hasPrevious());
		it.previous();

		Assert.assertTrue(it.hasPrevious());
		it.previous();
		
		Assert.assertFalse(it.hasPrevious());
	}
}
