/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.NodeTreeIterator;
import org.eclipse.xtext.nodemodel.util.SingletonBidiIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractNode implements INode {
	
	private CompositeNode parent;

	private AbstractNode prev;
	
	private AbstractNode next;
	
	private Object grammarElementOrArray;
	
	public ICompositeNode getParent() {
		return parent;
	}
	
	protected CompositeNode basicGetParent() {
		return parent;
	}
	
	protected void basicSetParent(CompositeNode parent) {
		this.parent = parent;
	}
	
	public BidiIterator<INode> iterator() {
		return SingletonBidiIterator.<INode>create(this);
	}
	
	protected BidiIterator<AbstractNode> basicIterator() {
		return SingletonBidiIterator.create(this);
	}
	
	public BidiTreeIterator<INode> treeIterator() {
		return new NodeTreeIterator(this);
	}
	
	protected BidiTreeIterator<AbstractNode> basicTreeIterator() {
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
		return prev.resolve();
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
		return next.resolve();
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
		return prev != this;
	}

	protected INode resolve() {
		return this;
	}
}
