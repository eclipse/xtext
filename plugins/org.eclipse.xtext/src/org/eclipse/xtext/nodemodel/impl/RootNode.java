/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RootNode extends CompositeNodeWithSemanticElement {

	private String completeContent;
	
	/**
	 * @return <code>null</code> the root node does not have any parent.
	 */
	@Override
	public CompositeNode getParent() {
		return null;
	}

	@Override
	public ICompositeNode getRootNode() {
		return this;
	}
	
	@Override
	public int getTotalOffset() {
		return 0;
	}

	@Override
	public int getTotalLength() {
		return getCompleteContent().length();
	}

	@Override
	public String getText() {
		return getCompleteContent();
	}

	public int getIndex() {
		return 0;
	}
	
	protected void basicSetCompleteContent(String completeContent) {
		this.completeContent = completeContent;
	}

	public String getCompleteContent() {
		return completeContent;
	}
	
	@Override
	public INode getNextSibling() {
		return null;
	}
	
	@Override
	public INode getPreviousSibling() {
		return null;
	}
	
	@Override
	public AbstractNode basicGetNextSibling() {
		return this;
	}
	
	@Override
	public AbstractNode basicGetPreviousSibling() {
		return this;
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
	public boolean hasSiblings() {
		return false;
	}
	
	@Override
	public void basicSetNextSibling(AbstractNode next) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void basicSetPreviousSibling(AbstractNode prev) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void basicSetParent(CompositeNode parent) {
		throw new UnsupportedOperationException();
	}

}
