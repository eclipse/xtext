/*******************************************************************************
 * Copyright (c) 2020 Robert Lewis and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.nodemodel.INode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Robert Lewis - Initial contribution and API
 */
public class NodeIterableTest {

	@Test
	public void forEachTest() {
		INode alpha = NodeIteratorTest.nodeWithTwoSiblings();
		NodeIterable iterable = new NodeIterable(alpha);
		
		List<String> tokens = new ArrayList<String>();
		for (INode node : iterable) {
			tokens.add(node.getText());
		}
		
		Assert.assertEquals("alpha", tokens.get(0));
		Assert.assertEquals("beta", tokens.get(1));
		Assert.assertEquals("gamma", tokens.get(2));
	}
	
	@Test
	public void forEachReverseTest() {
		INode alpha = NodeIteratorTest.nodeWithTwoSiblings();
		NodeIterable iterable = new NodeIterable(alpha);
		
		List<String> tokens = new ArrayList<String>();
		for (INode node : iterable.reverse()) {
			tokens.add(node.getText());
		}
		
		Assert.assertEquals("gamma", tokens.get(0));
		Assert.assertEquals("beta", tokens.get(1));
		Assert.assertEquals("alpha", tokens.get(2));
	}
	
	@Test(expected=NullPointerException.class)
	public void testStartWithNullThrowsNPE() {
		new NodeIterable(null);
	}
}
