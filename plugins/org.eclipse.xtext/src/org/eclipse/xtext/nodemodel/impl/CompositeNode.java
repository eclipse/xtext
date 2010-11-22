/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

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
			if (composite.hasNextSibling()) {
				CompositeNode composite2 = composite;
				while(composite2.basicGetParent() != null) {
					if (composite2.hasNextSibling())
						return composite2.basicGetNextSibling().getTotalOffset();
					composite2 = composite.basicGetParent();
				}
			}
			if (composite.hasPreviousSibling()) {
				CompositeNode composite2 = composite;
				while(composite2.basicGetParent() != null) {
					if (composite2.hasPreviousSibling())
						return composite2.basicGetPreviousSibling().getTotalEndOffset();
					composite2 = composite.basicGetParent();
				}
			}
		}
		return 0;
	}

	protected void setLookAhead(int lookAhead) {
		this.lookAhead = lookAhead;
	}
	
	public INode getFirstChild() {
		return firstChild;
	}
	
	public AbstractNode basicGetFirstChild() {
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
	
	public AbstractNode basicGetLastChild() {
		if (firstChild == null)
			return null;
		return firstChild.basicGetPreviousSibling();
	}
	
}
