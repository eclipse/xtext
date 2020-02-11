/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion;

import org.eclipse.xtext.nodemodel.INode;

/**
 * A value converter exception that carries the value around, that was
 * recoverable from a badly formatted string or erroneous node.
 * 
 * @see IValueConverter#toValue(String, INode)
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.0
 */
public class ValueConverterWithValueException extends ValueConverterException {

	private static final long serialVersionUID = 1788826768192460480L;
	
	private final Object value;

	private final int offset;

	private final int length;

	public ValueConverterWithValueException(String message, INode node, Object value, Exception cause) {
		super(message, node, cause);
		this.value = value;
		this.offset = -1;
		this.length = -1;
	}
	
	/**
	 * Creates a ranged value converter exception.
	 * @since 2.7
	 * @param offset the offset relative to the total offset of the node
	 * @param length the length of the error 
	 */
	public ValueConverterWithValueException(String message, INode node, Object value, int offset, int length, Exception cause) {
		super(message, node, cause);
		this.value = value;
		this.offset = offset;
		this.length = length;
	}
	
	/**
	 * @since 2.7
	 */
	public boolean hasRange() {
		return offset != -1;
	}
	
	/**
	 * @since 2.7
	 */
	public int getOffset() {
		return offset;
	}
	
	/**
	 * @since 2.7
	 */
	public int getLength() {
		return length;
	}

	public Object getValue() {
		return value;
	}

}
