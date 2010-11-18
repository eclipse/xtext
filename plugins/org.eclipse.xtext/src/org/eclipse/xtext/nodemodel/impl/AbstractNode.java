/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractNode implements INode {
	
	private ICompositeNode parent;

	private AbstractNode prev;
	
	private AbstractNode next;
	
	private EObject grammarElement;
	
	public ICompositeNode getParent() {
		return parent;
	}

	public Iterator<INode> iterator() {
		throw new UnsupportedOperationException();
	}
	
	public TreeIterator<INode> treeIterator() {
		throw new UnsupportedOperationException();
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
		INode candidate = this;
		while(candidate.getSemanticElement() == null && candidate.getParent() != null)
			candidate = candidate.getParent();
		return candidate.getSemanticElement();
	}
	
	public EObject getGrammarElement() {
		return grammarElement;
	}
	
	protected void setGrammarElement(EObject grammarElement) {
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
	
	public void basicSetParent(ICompositeNode parent) {
		this.parent = parent;
	}
	
}
