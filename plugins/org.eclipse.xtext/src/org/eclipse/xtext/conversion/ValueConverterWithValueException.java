/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	public ValueConverterWithValueException(String message, INode node, Object value, Exception cause) {
		super(message, node, cause);
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

}
