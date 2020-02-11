/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion;

import org.eclipse.xtext.nodemodel.INode;

/**
 * A {@link ValueConverterException} indicates an input string or node that cannot be
 * converted to a semantic value.
 * @see ValueConverterWithValueException
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("serial")
public class ValueConverterException extends RuntimeException {

	private final INode node;
	
	public ValueConverterException(String message, INode node, Exception cause) {
		super(message == null && cause != null ? cause.getMessage() : message, cause);
		this.node = node;
	}

	public INode getNode() {
		return node;
	}
}
