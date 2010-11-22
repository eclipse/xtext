/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Iterator;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeModelComparator {
	
	public static class UnequalNodeException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public UnequalNodeException(String message, Throwable cause) {
			super(message, cause);
		}

		public UnequalNodeException(String message) {
			super(message);
		}
		
	}
	
	public void assertEquals(org.eclipse.xtext.nodemodel.impl.CompositeNode newNode, CompositeNode oldNode) {
		if (newNode.basicGetSemanticElement() != oldNode.getElement())
			throw new UnequalNodeException("node's semantic element is not the same");
		if (newNode.getGrammarElement() != oldNode.getGrammarElement())
			throw new UnequalNodeException("node's grammar element is not the same");
		if (newNode.getSyntaxErrorMessage() != null) {
			if (oldNode.getSyntaxError() == null)
				throw new UnequalNodeException("node's syntax error state is not the same");
			if (!newNode.getSyntaxErrorMessage().getMessage().equals(oldNode.getSyntaxError().getMessage()))
				throw new UnequalNodeException("node's syntax error message is not the same");
		} else if (oldNode.getSyntaxError() != null) {
			throw new UnequalNodeException("node's syntax error state is not the same");
		}
		Iterator<INode> iterator = newNode.getChildren().iterator();
		int childIndex = 0;
		while(iterator.hasNext()) {
			INode newChildNode = iterator.next();
			AbstractNode oldChildNode = oldNode.getChildren().get(childIndex);
			assertEqualChild(newChildNode, oldChildNode);
			childIndex++;
		}
		if (childIndex != oldNode.getChildren().size()) {
			throw new UnequalNodeException("node's child count is not the same");
		}
	}

	protected void assertEqualChild(INode newChildNode, AbstractNode oldChildNode) {
		if (newChildNode instanceof ILeafNode) {
			assertEquals((ILeafNode)newChildNode, (LeafNode)oldChildNode);
		} else {
			assertEquals((org.eclipse.xtext.nodemodel.impl.CompositeNode) newChildNode, (CompositeNode) oldChildNode);
		}
	}

	protected void assertEquals(ILeafNode newNode, LeafNode oldNode) {
		if (newNode.getGrammarElement() != oldNode.getGrammarElement())
			throw new UnequalNodeException("node's grammar element is not the same");
		if (newNode.getSyntaxErrorMessage() != null) {
			if (oldNode.getSyntaxError() == null)
				throw new UnequalNodeException("node's syntax error state is not the same");
			if (!newNode.getSyntaxErrorMessage().getMessage().equals(oldNode.getSyntaxError().getMessage()))
				throw new UnequalNodeException("node's syntax error message is not the same");
		} else if (oldNode.getSyntaxError() != null) {
			throw new UnequalNodeException("node's syntax error state is not the same");
		}
		if (newNode.isHidden() != oldNode.isHidden())
			throw new UnequalNodeException("node's hidden state is not the same");
		if (!newNode.getText().equals(oldNode.getText()))
			throw new UnequalNodeException("node's text is not the same");
	}
	
	

}
