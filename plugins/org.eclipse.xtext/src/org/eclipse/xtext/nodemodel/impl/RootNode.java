/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.xtext.nodemodel.BidiIterator;
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
	public BidiIterator<INode> iterator() {
		return SingletonBidiIterator.<INode>create(this);
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
	
	public void setCompleteContent(String completeContent) {
		this.completeContent = completeContent;
	}

	public String getCompleteContent() {
		return completeContent;
	}
	
	@Override
	public void basicSetNext(AbstractNode next) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void basicSetPrevious(AbstractNode prev) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void basicSetParent(CompositeNode parent) {
		throw new UnsupportedOperationException();
	}

}
