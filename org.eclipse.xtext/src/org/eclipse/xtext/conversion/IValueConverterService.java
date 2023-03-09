/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion;

import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public interface IValueConverterService {
	
	/**
	 * @see org.eclipse.xtext.nodemodel.util.NodeModelUtils#getTokenText(INode)
	 */
	Object toValue(String string, String lexerRule, INode node) throws ValueConverterException;

	String toString(Object value, String lexerRule);
	
	/**
	 * Extension interface to the value converter service. Clients that need to access
	 * the very same value converter very often, may obtain it and cache it locally.
	 * 
	 * @since 2.7
	 */
	interface Introspectable {
		IValueConverter<Object> getConverter(String lexerRule);
	}

}
