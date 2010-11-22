/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Iterator;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;

import com.google.common.collect.Iterators;

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
	
	public void assertEquals(ICompositeNode newNode, CompositeNode oldNode) {
		Iterator<INode> newIterator = newNode.treeIterator();
		Iterator<AbstractNode> oldIterator = Iterators.filter(EcoreUtil2.eAll(oldNode), AbstractNode.class);
		while(newIterator.hasNext()) {
			if (!oldIterator.hasNext())
				throw new UnequalNodeException("node's element cound is not the same");
			INode newChildNode = newIterator.next();
			AbstractNode oldChildNode = oldIterator.next();
			assertEqualChild(newChildNode, oldChildNode);
		}
	}

	protected void assertEqualChild(INode newNode, AbstractNode oldNode) {
		if (newNode.getTotalOffset() != oldNode.getTotalOffset())
			throw new UnequalNodeException("node's offset is not the same");
		if (newNode.getTotalLength() != oldNode.getTotalLength())
			throw new UnequalNodeException("node's length is not the same");
		if (newNode instanceof ILeafNode) {
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
			if (((ILeafNode) newNode).isHidden() != ((LeafNode) oldNode).isHidden())
				throw new UnequalNodeException("node's hidden state is not the same");
			if (!newNode.getText().equals(((LeafNode) oldNode).getText()))
				throw new UnequalNodeException("node's text is not the same");
		} else {
			if (oldNode.getElement() != null) {
				if (newNode.getSemanticElement() != oldNode.getElement())
					throw new UnequalNodeException("node's semantic element is not the same");
			}
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
		}
	}

}
