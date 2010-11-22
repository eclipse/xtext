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
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractNode implements INode {
	
	private CompositeNode parent;

	private AbstractNode prev;
	
	private AbstractNode next;
	
	private EObject grammarElement;
	
	public CompositeNode getParent() {
		return parent;
	}

	public BidiIterator<INode> iterator() {
		return new NodeListIterator(this);
	}
	
	public BidiTreeIterator<INode> treeIterator() {
		return new NodeTreeIterator(this);
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

	protected INode getRootNode() {
		if (parent == null)
			return null;
		INode candidate = parent;
		while(candidate.getParent() != null)
			candidate = candidate.getParent();
		return candidate;
	}
	
	public EObject getSemanticElement() {
		if (parent == null)
			return null;
		return parent.getSemanticElement();
	}
	
	public EObject getGrammarElement() {
		return grammarElement;
	}
	
	public void setGrammarElement(EObject grammarElement) {
		this.grammarElement = grammarElement;
	}

	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}
	
	public AbstractNode getPrevious() {
		return prev;
	}
	
	public AbstractNode getNext() {
		return next;
	}
	
	public void basicSetPrevious(AbstractNode prev) {
		this.prev = prev;
	}
	
	public void basicSetNext(AbstractNode next) {
		this.next = next;
	}
	
	public void basicSetParent(CompositeNode parent) {
		this.parent = parent;
	}
	
}
