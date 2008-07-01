/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.impl;

import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class NodeWithCachedOffset {

	private AbstractNode theNode;
	
	private int offset;

	public NodeWithCachedOffset(int offset, AbstractNode theNode) {
		this.offset = offset;
		this.theNode = theNode;
	}

	/**
	 * @return the offset
	 */
	public int getChachedOffset() {
		return offset;
	}
	
	/**
	 * @return the node
	 */
	public AbstractNode getNode() {
		return theNode;
	}
}