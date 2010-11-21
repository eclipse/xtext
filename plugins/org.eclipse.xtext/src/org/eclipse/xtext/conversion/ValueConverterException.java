/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("serial")
public class ValueConverterException extends RuntimeException {

	private final AbstractNode node;
	
	private final INode lwNode;
	
	public ValueConverterException(String message, AbstractNode node, Exception cause) {
		super(message == null && cause != null ? cause.getMessage() : message, cause);
		this.node = node;
		this.lwNode = null;
	}

	public AbstractNode getNode() {
		return node;
	}
	
	public INode getNode2() {
		return lwNode;
	}
}
