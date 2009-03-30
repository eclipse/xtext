/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IllegalNodeException extends RuntimeException {

	private static final long serialVersionUID = -5736024053937205L;

	private final AbstractNode node;

	public IllegalNodeException(AbstractNode node) {
		super();
		this.node = node;
	}

	public IllegalNodeException(AbstractNode node, String message, Throwable cause) {
		super(message, cause);
		this.node = node;
	}

	public IllegalNodeException(AbstractNode node, String message) {
		super(message);
		this.node = node;
	}

	public IllegalNodeException(AbstractNode node, Throwable cause) {
		super(cause);
		this.node = node;
	}
	
	public AbstractNode getNode() {
		return node;
	}
	
}
