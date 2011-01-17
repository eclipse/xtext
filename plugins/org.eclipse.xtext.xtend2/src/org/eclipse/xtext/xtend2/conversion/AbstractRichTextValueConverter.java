/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.conversion;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractRichTextValueConverter extends AbstractLexerBasedConverter<String> {
	
	protected abstract String getLeadingTerminal();
	protected abstract String getTrailingTerminal();
	
	@Override
	protected String toEscapedString(String value) {
		return getLeadingTerminal() + value + getTrailingTerminal();
	}
	
	@Override
	protected void assertValidValue(String value) {
		super.assertValidValue(value);
		if (value.indexOf('«') >= 0) {
			throw new ValueConverterException("Rich string may not contain \"«\".", null, null);
		}
		if (value.indexOf("'''") >= 0) {
			throw new ValueConverterException("Rich string may not contain \"'''\".", null, null);
		}
	}
	
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			String result = string.substring(getLeadingTerminal().length(), string.length() - getTrailingTerminal().length());
			return result;
		} catch (StringIndexOutOfBoundsException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
}