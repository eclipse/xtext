/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
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
	
	public int getNodeType() {
		return COMPOSITE;
	}

	public Iterable<INode> getChildren() {
		if (firstChild != null)
			return firstChild;
		return Collections.emptyList();
	}

	public EObject getSemanticElement() {
		return null;
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
		throw new IllegalStateException();
	}
	
	public int getTotalOffset() {
		if (firstChild != null)
			return firstChild.getTotalOffset();
		throw new IllegalStateException();
	}

	public void setLookAhead(int lookAhead) {
		this.lookAhead = lookAhead;
	}
	
	public AbstractNode getFirstChild() {
		return firstChild;
	}
	
	public void setFirstChild(AbstractNode firstChild) {
		if (this.firstChild != null) {
			this.firstChild.setParent(null);
		}
		this.firstChild = firstChild;
		firstChild.setParent(this);
	}
	
	public void addChild(AbstractNode child) {
		if (firstChild == null)
			setFirstChild(child);
		else {
			firstChild.addPrevious(child);
		}
	}
	
}
