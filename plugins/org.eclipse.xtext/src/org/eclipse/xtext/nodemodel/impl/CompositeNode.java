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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompositeNode extends AbstractNode implements ICompositeNode {

	private AbstractNode firstChild;
	
	private int lookAhead;
	
	public CompositeNode() {
	}
	
	public BidiIterable<INode> getChildren() {
		if (firstChild != null)
			return firstChild;
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
			AbstractNode lastChild = firstChild.getPrevious();
			return lastChild.getTotalOffset() + lastChild.getTotalLength() - offset;
		}
		return 0;
	}
	
	public int getTotalOffset() {
		if (firstChild != null)
			return firstChild.getTotalOffset();
		CompositeNode composite = this;
		while(composite.getNext() == composite) {
			composite = composite.getParent();
		}
		if (composite.getParent() != null) {
			if (composite.getParent().getLastChild() != composite) {
				CompositeNode composite2 = composite;
				while(composite2.getParent() != null) {
					if (composite2 != composite2.getParent().getLastChild())
						return composite2.getNext().getTotalOffset();
					composite2 = composite.getParent();
				}
			}
			if (composite.getParent().getFirstChild() != composite) {
				CompositeNode composite2 = composite;
				while(composite2.getParent() != null) {
					if (composite2 != composite2.getParent().getFirstChild())
						return composite2.getPrevious().getTotalEndOffset();
					composite2 = composite.getParent();
				}
			}
		}
		return 0;
	}

	protected void setLookAhead(int lookAhead) {
		this.lookAhead = lookAhead;
	}
	
	public AbstractNode getFirstChild() {
		return firstChild;
	}
	
	public AbstractNode getLastChild() {
		if (firstChild == null)
			return null;
		return firstChild.getPrevious();
	}
	
	protected void basicSetFirstChild(AbstractNode firstChild) {
		this.firstChild = firstChild;
	}
	
	protected EObject basicGetSemanticElement() {
		return null;
	}
	
}
