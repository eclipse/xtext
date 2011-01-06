/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class STRINGValueConverter extends AbstractLexerBasedConverter<String> {
	
	@Override
	protected String toEscapedString(String value) {
		return '"' + Strings.convertToJavaString(value, false) + '"';
	}
	
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			return Strings.convertFromJavaString(string.substring(1, string.length() - 1), true);
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
}