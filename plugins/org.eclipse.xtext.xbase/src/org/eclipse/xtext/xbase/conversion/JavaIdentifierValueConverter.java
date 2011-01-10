/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.conversion;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.IDValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaIdentifierValueConverter extends IDValueConverter {

	@Override
	protected Set<Character> collectInvalidCharacters(String value) {
		Set<Character> result = null;
		char[] charArray = value.toCharArray();
		if(!Character.isJavaIdentifierStart(charArray[0])) {
			result = newHashSet();
			result.add(charArray[0]);
		}
		for (int i=1; i< charArray.length; ++i) {
			if (!Character.isJavaIdentifierPart(charArray[i])) {
				if (result == null)
					result = newHashSet();
				result.add(charArray[i]);
			}
		}
		return result;
	}
	
	@Override
	public String toValue(String string, INode node) {
		try {
			String unescaped = Strings.convertFromJavaString((string.startsWith("^")) ? string.substring(1) : string, true);
			Set<Character> invalidChars = collectInvalidCharacters(unescaped);
			if (invalidChars != null) {
				throw new ValueConverterException(getInvalidCharactersMessage(unescaped, invalidChars), null, null);
			}
			return unescaped;
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}

}
