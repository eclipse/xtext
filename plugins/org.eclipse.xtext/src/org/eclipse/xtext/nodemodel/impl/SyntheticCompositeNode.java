/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.NodeTreeIterator;
import org.eclipse.xtext.nodemodel.util.SingletonBidiIterable;
import org.eclipse.xtext.nodemodel.util.SingletonBidiIterator;

/**
 * Unfolds the array of grammar elements that is associated with a composite node.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntheticCompositeNode implements ICompositeNode {

	private final CompositeNode delegate;
	private final int grammarElementIdx;
	
	protected SyntheticCompositeNode(CompositeNode delegate, int grammarElementIdx) {
		this.delegate = delegate;
		this.grammarElementIdx = grammarElementIdx;
	}
	
	public ICompositeNode getParent() {
		if (grammarElementIdx == 0)
			return delegate.basicGetParent();
		return new SyntheticCompositeNode(delegate, grammarElementIdx - 1);
	}
	
	public boolean hasSiblings() {
		if (grammarElementIdx == 0)
			return delegate.basicHasSiblings();
		return false;
	}

	public boolean hasPreviousSibling() {
		if (grammarElementIdx == 0)
			return delegate.basicHasPreviousSibling();
		return false;
	}

	public boolean hasNextSibling() {
		if (grammarElementIdx == 0)
			return delegate.basicHasNextSibling();
		return false;
	}

	public INode getPreviousSibling() {
		if (grammarElementIdx == 0) {
			if (hasPreviousSibling())
				return delegate.basicGetPreviousSibling().resolve();
		}
		return null;
	}

	public INode getNextSibling() {
		if (grammarElementIdx == 0) {
			if (hasNextSibling())
				return delegate.basicGetNextSibling().resolve();
		}
		return null;
	}

	public ICompositeNode getRootNode() {
		return delegate.getRootNode();
	}

	public int getTotalOffset() {
		return delegate.getTotalOffset();
	}
	
	public int getOffset() {
		return delegate.getOffset();
	}
	
	public int getLength() {
		return delegate.getLength();
	}
	
	public int getTotalStartLine() {
		return delegate.getTotalStartLine();
	}
	
	public int getEndLine() {
		return delegate.getEndLine();
	}
	
	public int getStartLine() {
		return delegate.getStartLine();
	}
	
	public int getTotalEndLine() {
		return delegate.getTotalEndLine();
	}

	public int getTotalLength() {
		return delegate.getTotalLength();
	}

	public int getTotalEndOffset() {
		return delegate.getTotalEndOffset();
	}

	public String getText() {
		return delegate.getText();
	}

	public EObject getGrammarElement() {
		EObject[] array = (EObject[]) delegate.basicGetGrammarElement();
		return array[grammarElementIdx];
	}

	public EObject getSemanticElement() {
		return delegate.basicGetParent().getSemanticElement();
	}
	
	public boolean hasDirectSemanticElement() {
		return false;
	}

	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}

	public BidiIterator<INode> iterator() {
		return SingletonBidiIterator.<INode>create(this);
	}

	public BidiTreeIterator<INode> treeIterator() {
		return new NodeTreeIterator(this);
	}

	public BidiIterable<INode> getChildren() {
		return SingletonBidiIterable.<INode>create(getFirstChild());
	}

	public boolean hasChildren() {
		return true;
	}

	public INode getFirstChild() {
		EObject[] array = (EObject[]) delegate.basicGetGrammarElement();
		if (grammarElementIdx == array.length - 2)
			return delegate;
		return new SyntheticCompositeNode(delegate, grammarElementIdx + 1);
	}

	public INode getLastChild() {
		return getFirstChild();
	}

	public int getLookAhead() {
		return delegate.getLookAhead();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof SyntheticCompositeNode))
			return false;
		SyntheticCompositeNode casted = (SyntheticCompositeNode) obj;
		return delegate == casted.delegate && grammarElementIdx == casted.grammarElementIdx;
	}
	
	@Override
	public int hashCode() {
		return delegate.hashCode() ^ grammarElementIdx;
	}

}
