/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.EmptyBidiIterable;
import org.eclipse.xtext.nodemodel.util.NodeIterable;
import org.eclipse.xtext.nodemodel.util.NodeTreeIterator;
import org.eclipse.xtext.nodemodel.util.ReversedBidiTreeIterable;
import org.eclipse.xtext.nodemodel.util.SingletonBidiIterable;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

/**
 * Unfolds the array of grammar elements that is associated with a composite node.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
public class SyntheticCompositeNode implements ICompositeNode, BidiTreeIterable<INode> {

	private final CompositeNode delegate;
	private final int grammarElementIdx;
	
	protected SyntheticCompositeNode(CompositeNode delegate, int grammarElementIdx) {
		this.delegate = delegate;
		this.grammarElementIdx = grammarElementIdx;
	}
	
	@Override
	public ICompositeNode getParent() {
		if (grammarElementIdx == 1)
			return delegate;
		return new SyntheticCompositeNode(delegate, grammarElementIdx - 1);
	}
	
	@Override
	public boolean hasSiblings() {
		return false;
	}

	@Override
	public boolean hasPreviousSibling() {
		return false;
	}

	@Override
	public boolean hasNextSibling() {
		return false;
	}

	@Override
	public INode getPreviousSibling() {
		return null;
	}

	@Override
	public INode getNextSibling() {
		return null;
	}

	@Override
	public ICompositeNode getRootNode() {
		return delegate.getRootNode();
	}

	@Override
	public int getTotalOffset() {
		return delegate.getTotalOffset();
	}
	
	@Override
	public int getOffset() {
		return delegate.getOffset();
	}
	
	@Override
	public int getLength() {
		return delegate.getLength();
	}
	
	@Override
	public int getTotalStartLine() {
		return delegate.getTotalStartLine();
	}
	
	@Override
	public int getEndLine() {
		return delegate.getEndLine();
	}
	
	@Override
	public int getStartLine() {
		return delegate.getStartLine();
	}
	
	@Override
	public int getTotalEndLine() {
		return delegate.getTotalEndLine();
	}

	@Override
	public int getTotalLength() {
		return delegate.getTotalLength();
	}

	@Override
	public int getTotalEndOffset() {
		return delegate.getTotalEndOffset();
	}

	@Override
	public String getText() {
		return delegate.getText();
	}

	@Override
	public EObject getGrammarElement() {
		EObject[] array = (EObject[]) delegate.basicGetGrammarElement();
		return array[grammarElementIdx];
	}

	@Override
	public EObject getSemanticElement() {
		return delegate.getSemanticElement();
	}
	
	@Override
	public boolean hasDirectSemanticElement() {
		return false;
	}

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}
	
	@Override
	public BidiTreeIterable<INode> getAsTreeIterable() {
		return this;
	}

	@Override
	public BidiTreeIterator<INode> iterator() {
		return new NodeTreeIterator(this);
	}
	
	@Override
	public Iterable<ILeafNode> getLeafNodes() {
		return delegate.getLeafNodes();
	}
	
	@Override
	public BidiTreeIterable<INode> reverse() {
		return new ReversedBidiTreeIterable<INode>(this);
	}

	@Override
	public BidiIterable<INode> getChildren() {
		if (hasChildren()) {
			INode firstChild = getFirstChild();
			if (firstChild.hasSiblings()) {
				return new NodeIterable(firstChild);
			} else {
				return SingletonBidiIterable.<INode>create(firstChild);
			}
		}
		return EmptyBidiIterable.instance();
	}

	@Override
	public boolean hasChildren() {
		EObject[] array = (EObject[]) delegate.basicGetGrammarElement();
		if (array.length == grammarElementIdx + 1)
			return delegate.basicGetFirstChild() != null;
		return true;
	}

	@Override
	public INode getFirstChild() {
		EObject[] array = (EObject[]) delegate.basicGetGrammarElement();
		if (array.length == grammarElementIdx + 1)
			return delegate.basicGetFirstChild();
		return new SyntheticCompositeNode(delegate, grammarElementIdx + 1);
	}

	@Override
	public INode getLastChild() {
		EObject[] array = (EObject[]) delegate.basicGetGrammarElement();
		if (array.length == grammarElementIdx + 1)
			return delegate.basicGetLastChild();
		return new SyntheticCompositeNode(delegate, grammarElementIdx + 1);
	}

	@Override
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

	/**
	 * @since 2.5
	 */
	@Override
	public ITextRegion getTextRegion() {
		return delegate.getTextRegion();
	}

	/**
	 * @since 2.5
	 */
	@Override
	public ITextRegion getTotalTextRegion() {
		return delegate.getTotalTextRegion();
	}

	/**
	 * @since 2.5
	 */
	@Override
	public ITextRegionWithLineInformation getTextRegionWithLineInformation() {
		return delegate.getTextRegionWithLineInformation();
	}

	/**
	 * @since 2.5
	 */
	@Override
	public ITextRegionWithLineInformation getTotalTextRegionWithLineInformation() {
		return delegate.getTotalTextRegionWithLineInformation();
	}

	/**
	 * @since 2.5
	 */
	@Override
	public int getEndOffset() {
		return delegate.getEndOffset();
	}

}
