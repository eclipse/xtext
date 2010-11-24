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
import org.eclipse.xtext.nodemodel.ICompositeNode;
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
		if (firstChild != null) {
			if (firstChild.hasSiblings()) {
				return new NodeIterable(getFirstChild());
			} else {
				return SingletonBidiIterable.<INode>create(getFirstChild());
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
		return firstChild != null;
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
		CompositeNode composite = this;
		while(!composite.hasSiblings() && composite.basicGetParent() != null) {
			composite = composite.basicGetParent();
		}
		if (composite.basicGetParent() != null) {
			if (composite.basicHasNextSibling()) {
				CompositeNode composite2 = composite;
				while(composite2.basicGetParent() != null) {
					if (composite2.basicHasNextSibling())
						return composite2.basicGetNextSibling().getTotalOffset();
					composite2 = composite.basicGetParent();
				}
			}
			if (composite.basicHasPreviousSibling()) {
				CompositeNode composite2 = composite;
				while(composite2.basicGetParent() != null) {
					if (composite2.basicHasPreviousSibling())
						return composite2.basicGetPreviousSibling().getTotalEndOffset();
					composite2 = composite.basicGetParent();
				}
			}
		}
		return 0;
	}

	protected void basicSetLookAhead(int lookAhead) {
		this.lookAhead = lookAhead;
	}
	
	public INode getFirstChild() {
		if (hasChildren())
			return firstChild.resolve();
		return null;
	}
	
	protected AbstractNode basicGetFirstChild() {
		return firstChild;
	}
	
	protected void basicSetFirstChild(AbstractNode firstChild) {
		this.firstChild = firstChild;
	}
	
	public INode getLastChild() {
		if (firstChild == null)
			return null;
		return firstChild.basicGetPreviousSibling();
	}
	
	protected AbstractNode basicGetLastChild() {
		if (firstChild == null)
			return null;
		return firstChild.basicGetPreviousSibling();
	}
	
	@Override
	protected ICompositeNode resolve() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (grammarElementOrArray == null || grammarElementOrArray instanceof EObject)
			return this;
		return new SyntheticCompositeNode(this, 0);
	}
	
	@Override
	public ICompositeNode getParent() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (grammarElementOrArray == null || grammarElementOrArray instanceof EObject)
			return basicGetParent();
		EObject[] grammarElements = (EObject[]) grammarElementOrArray;
		return new SyntheticCompositeNode(this, grammarElements.length - 2);
	}
	
	@Override
	public EObject getGrammarElement() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (grammarElementOrArray == null || grammarElementOrArray instanceof EObject)
			return (EObject) grammarElementOrArray;
		EObject[] grammarElements = (EObject[]) grammarElementOrArray;
		return grammarElements[grammarElements.length - 1];
	}
	
	@Override
	public boolean hasNextSibling() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (grammarElementOrArray == null || grammarElementOrArray instanceof EObject)
			return super.hasNextSibling();
		return false;
	}
	
	@Override
	public boolean hasSiblings() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (grammarElementOrArray == null || grammarElementOrArray instanceof EObject)
			return super.hasSiblings();
		return false;
	}
	
	@Override
	public INode getNextSibling() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (grammarElementOrArray == null || grammarElementOrArray instanceof EObject)
			return super.getNextSibling();
		return null;
	}
	
	@Override
	public boolean hasPreviousSibling() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (grammarElementOrArray == null || grammarElementOrArray instanceof EObject)
			return super.hasPreviousSibling();
		return false;
	}
	
	@Override
	public INode getPreviousSibling() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (grammarElementOrArray == null || grammarElementOrArray instanceof EObject)
			return super.getPreviousSibling();
		return null;
	}	
	
}
