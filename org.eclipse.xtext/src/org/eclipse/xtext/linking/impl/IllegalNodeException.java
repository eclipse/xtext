/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IllegalNodeException extends RuntimeException {

	private static final long serialVersionUID = -5736024053937205L;

	private final INode node;

	public IllegalNodeException(INode node) {
		super();
		this.node = node;
	}

	public IllegalNodeException(INode node, String message, Throwable cause) {
		super(message, cause);
		this.node = node;
	}

	public IllegalNodeException(INode node, String message) {
		super(message);
		this.node = node;
	}

	public IllegalNodeException(INode node, Throwable cause) {
		super(cause);
		this.node = node;
	}
	
	public INode getNode() {
		return node;
	}
	
}
