/*******************************************************************************
 * Copyright (c) 2020 Robert Lewis and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Robert Lewis - Initial contribution and API
 */
public class NodeIteratorTest {
	
	private static INode getSingleNode() {
		return new RootNode();
	}
	
	public static INode nodeWithTwoSiblings() {
		NodeModelBuilder builder = new NodeModelBuilder();
		String text = "alpha beta gamma";
		
		ICompositeNode root = builder.newRootNode(text);

		EObject alpha = new EObjectImpl() {};
		ILeafNode alphaNode = builder.newLeafNode(text.indexOf("alpha"), "alpha".length(), alpha, false, null, root);
		
		EObject beta = new EObjectImpl() {};
		builder.newLeafNode(text.indexOf("beta"), "beta".length(), beta, false, null, root);
		
		EObject gamma = new EObjectImpl() {};
		builder.newLeafNode(text.indexOf("gamma"), "gamma".length(), gamma, false, null, root);
		
		return alphaNode;
	}
		
	@Test(expected=NullPointerException.class)
	public void testStartWithNullThrowsNPE() {
		new NodeIterator(null);
	}
	
	@Test
	public void testSingleNodeHasNext() {
		INode single = getSingleNode();
		NodeIterator it = new NodeIterator(single);
		
		Assert.assertTrue(it.hasNext());
		it.next();
		
		Assert.assertFalse(it.hasNext());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testNextTooFarThrowsException() {
		INode single = getSingleNode();
		NodeIterator it = new NodeIterator(single);
		
		it.next();

		it.next();
	}
	
	@Test
	public void testIterateThreeNodes() {
		INode alpha = nodeWithTwoSiblings();
		NodeIterator it = new NodeIterator(alpha);
		
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
		INode single = getSingleNode();
		NodeIterator it = new NodeIterator(single);
		
		Assert.assertTrue(it.hasPrevious());
		it.previous();
		
		Assert.assertFalse(it.hasPrevious());
	}
	
	@Test
	public void testIteratePreviousStartsWithLastNode() {
		INode alpha = nodeWithTwoSiblings();
		NodeIterator it = new NodeIterator(alpha);

		INode result = it.previous();
		
		Assert.assertEquals("gamma", result.getText());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testPreviousTooFarThrowsException() {
		INode single = getSingleNode();
		NodeIterator it = new NodeIterator(single);
		
		it.previous();

		it.previous();
	}
	
	@Test
	public void testIterateThreeNodesInReverse() {
		INode alpha = nodeWithTwoSiblings();
		NodeIterator it = new NodeIterator(alpha);
		
		Assert.assertTrue(it.hasPrevious());
		it.previous();
		
		Assert.assertTrue(it.hasPrevious());
		it.previous();

		Assert.assertTrue(it.hasPrevious());
		it.previous();
		
		Assert.assertFalse(it.hasPrevious());
	}
}
