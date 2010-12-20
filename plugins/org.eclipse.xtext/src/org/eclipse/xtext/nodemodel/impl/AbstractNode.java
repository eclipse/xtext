/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.NodeTreeIterator;
import org.eclipse.xtext.nodemodel.util.ReversedBidiTreeIterable;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractNode implements INode, BidiTreeIterable<INode> {
	
	private CompositeNode parent;

	private AbstractNode prev;
	
	private AbstractNode next;
	
	private Object grammarElementOrArray;
	
	public ICompositeNode getParent() {
		if (parent != null)
			return parent.resolveAsParent();
		return null;
	}
	
	protected CompositeNode basicGetParent() {
		return parent;
	}
	
	protected void basicSetParent(CompositeNode parent) {
		this.parent = parent;
	}
	
	public BidiTreeIterable<INode> getAsTreeIterable() {
		return this;
	}
	
	public BidiTreeIterator<INode> iterator() {
		return new NodeTreeIterator(this);
	}
	
	public BidiTreeIterable<INode> reverse() {
		return new ReversedBidiTreeIterable<INode>(this);
	}
	
	public Iterable<ILeafNode> getLeafNodes() {
		return new Iterable<ILeafNode>() {
			public Iterator<ILeafNode> iterator() {
				return Iterators.filter(basicIterator(), ILeafNode.class);
			}
		};
	}
	
	public BidiTreeIterator<AbstractNode> basicIterator() {
		return new BasicNodeTreeIterator(this);
	}

	public String getText() {
		INode rootNode = getRootNode();
		if (rootNode != null) {
			int offset = getTotalOffset();
			int length = getTotalLength();
			return rootNode.getText().substring(offset, offset + length);
		}
		return null;
	}
	
	public int getTotalStartLine() {
		INode rootNode = getRootNode();
		if (rootNode != null) {
			int offset = getTotalOffset();
			String leadingText = rootNode.getText().substring(0, offset);
			int result = Strings.countLines(leadingText);
			return result + 1;
		}
		return 1;
	}
	
	public int getStartLine() {
		INode rootNode = getRootNode();
		if (rootNode != null) {
			int offset = getOffset();
			String leadingText = rootNode.getText().substring(0, offset);
			int result = Strings.countLines(leadingText);
			return result + 1;
		}
		return 1;
	}
	
	public int getEndLine() {
		int offset = getOffset();
		int length = getLength();
		INode rootNode = getRootNode();
		String text = rootNode.getText().substring(offset, offset + length);
		int myLineCount = Strings.countLines(text);
		return getStartLine() + myLineCount;
	}
	
	public int getTotalEndLine() {
		String text = getText();
		int myLineCount = Strings.countLines(text);
		return getTotalStartLine() + myLineCount;
	}
	
	public int getOffset() {
		Iterator<ILeafNode> leafIter = Iterators.filter(basicIterator(), ILeafNode.class);
		int firstLeafOffset = -1;
		while(leafIter.hasNext()) {
			ILeafNode leaf = leafIter.next();
			if (firstLeafOffset == -1) {
				firstLeafOffset = leaf.getTotalOffset();
			}
			if (!leaf.isHidden())
				return leaf.getTotalOffset();
		}
		if (firstLeafOffset != -1)
			return firstLeafOffset;
		return getTotalOffset();
	}
	
	public int getLength() {
		BidiIterator<AbstractNode> iter = basicIterator();
		while(iter.hasPrevious()) {
			INode prev = iter.previous();
			if (prev instanceof ILeafNode && !((ILeafNode) prev).isHidden()) {
				int offset = getOffset();
				return prev.getTotalEndOffset() - offset;
			}
		}
		return getTotalLength();
	}
	
	public int getTotalEndOffset() {
		return getTotalOffset() + getTotalLength();
	}

	public ICompositeNode getRootNode() {
		if (parent == null)
			return null;
		CompositeNode candidate = parent;
		while(candidate.basicGetParent() != null)
			candidate = candidate.basicGetParent();
		return candidate.getRootNode();
	}
	
	public EObject getSemanticElement() {
		if (parent == null)
			return null;
		return parent.getSemanticElement();
	}
	
	protected EObject basicGetSemanticElement() {
		return null;
	}
	
	public boolean hasDirectSemanticElement() {
		return basicGetSemanticElement() != null;
	}
	
	public EObject getGrammarElement() {
		return (EObject) grammarElementOrArray;
	}
	
	protected Object basicGetGrammarElement() {
		return grammarElementOrArray;
	}
	
	protected void basicSetGrammarElement(Object grammarElementOrArray) {
		this.grammarElementOrArray = grammarElementOrArray;
	}

	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}
	
	public INode getPreviousSibling() {
		if (!hasPreviousSibling())
			return null;
		return prev;
	}
	
	protected AbstractNode basicGetPreviousSibling() {
		return prev;
	}
	
	protected void basicSetPreviousSibling(AbstractNode prev) {
		this.prev = prev;
	}
	
	public INode getNextSibling() {
		if (!hasNextSibling())
			return null;
		return next;
	}
	
	protected AbstractNode basicGetNextSibling() {
		return next;
	}
	
	protected void basicSetNextSibling(AbstractNode next) {
		this.next = next;
	}
	
	public boolean hasPreviousSibling() {
		return basicHasPreviousSibling();
	}
	
	protected boolean basicHasPreviousSibling() {
		if (parent == null)
			return false;
		return parent.basicGetFirstChild() != this;
	}
	
	public boolean hasNextSibling() {
		return basicHasNextSibling();
	}
	
	protected boolean basicHasNextSibling() {
		if (parent == null)
			return false;
		return parent.basicGetLastChild() != this;
	}
	
	public boolean hasSiblings() {
		return basicHasSiblings();
	}
	
	protected boolean basicHasSiblings() {
		return prev != this;
	}

}
