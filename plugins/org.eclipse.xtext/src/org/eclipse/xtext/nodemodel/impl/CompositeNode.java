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
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.EmptyBidiIterable;
import org.eclipse.xtext.nodemodel.util.NodeIterable;
import org.eclipse.xtext.nodemodel.util.SingletonBidiIterable;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompositeNode extends AbstractNode implements ICompositeNode {

	private AbstractNode firstChild;
	
	private int lookAhead;
	
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
	
	public BidiIterable<AbstractNode> basicGetChildren() {
		if (firstChild != null) {
			if (firstChild.hasSiblings()) {
				return new BasicNodeIterable(firstChild);
			} else {
				return SingletonBidiIterable.create(basicGetFirstChild());
			}
		}
		return EmptyBidiIterable.instance();
	}
	
	public boolean hasChildren() {
		return firstChild != null || isFolded();
	}

	public int getLookAhead() {
		return lookAhead;
	}
	
	public int getTotalLength() {
		if (firstChild != null) {
			int offset = firstChild.getTotalOffset();
			AbstractNode lastChild = firstChild.basicGetPreviousSibling();
			return lastChild.getTotalOffset() + lastChild.getTotalLength() - offset;
		}
		return 0;
	}
	
	public int getTotalOffset() {
		if (firstChild != null)
			return firstChild.getTotalOffset();
		CompositeNode compositeWithSiblings = this;
		while(!compositeWithSiblings.hasSiblings() && compositeWithSiblings.basicGetParent() != null) {
			compositeWithSiblings = compositeWithSiblings.basicGetParent();
		}
		if (compositeWithSiblings.basicHasNextSibling()) {
			AbstractNode sibling = compositeWithSiblings.basicGetNextSibling();
			return sibling.getTotalOffset();
		}
		// expensive fallback - should never happen in a valid node model
		BidiTreeIterator<INode> iter = getRootNode().getAsTreeIterable().iterator();
		ILeafNode lastSeen = null;
		while(iter.hasNext()) {
			INode next = iter.next();
			if (next == this) {
				if (lastSeen == null)
					return 0;
				else
					return lastSeen.getTotalEndOffset();
			}
			if (next instanceof ILeafNode) {
				lastSeen = (ILeafNode) next;
			}
		}
		return 0;
	}

	protected void basicSetLookAhead(int lookAhead) {
		this.lookAhead = lookAhead;
	}
	
	public INode getFirstChild() {
		if (isFolded()) {
			return new SyntheticCompositeNode(this, 1);
		}
		return firstChild;
	}
	
	protected AbstractNode basicGetFirstChild() {
		return firstChild;
	}
	
	protected void basicSetFirstChild(AbstractNode firstChild) {
		this.firstChild = firstChild;
	}
	
	public INode getLastChild() {
		if (isFolded()) {
			return new SyntheticCompositeNode(this, 1);
		}
		return basicGetLastChild();
	}
	
	protected AbstractNode basicGetLastChild() {
		if (firstChild == null)
			return null;
		return firstChild.basicGetPreviousSibling();
	}
	
	protected boolean isFolded() {
		Object grammarElementOrArray = basicGetGrammarElement();
		return isFolded(grammarElementOrArray);
	}

	protected boolean isFolded(Object grammarElementOrArray) {
		return !(grammarElementOrArray == null || grammarElementOrArray instanceof EObject);
	}
	
	public ICompositeNode resolveAsParent() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (!isFolded())
			return this;
		EObject[] grammarElements = (EObject[]) grammarElementOrArray;
		return new SyntheticCompositeNode(this, grammarElements.length - 1);
	}	
	
	@Override
	public EObject getGrammarElement() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (!isFolded())
			return (EObject) grammarElementOrArray;
		EObject[] grammarElements = (EObject[]) grammarElementOrArray;
		return grammarElements[0];
	}
	
}
