/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.parameters;

import org.eclipse.xtext.util.Strings;
import org.xpect.util.ITypedProvider;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractExpectation implements ITypedProvider {
	private final String document;
	private final int length;
	private final int offset;

	public AbstractExpectation(String document, int offset, int length) {
		super();
		Preconditions.checkElementIndex(offset, document.length());
		Preconditions.checkElementIndex(offset + length, document.length());
		this.document = document;
		this.offset = offset;
		this.length = length;
	}

	public boolean canProvide(Class<?> expectedType) {
		return expectedType.isInstance(this);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType) {
		if (expectedType.isInstance(this))
			return (T) this;
		return null;
	}

	protected String getExpectation(String indentation) {
		if (length < 0)
			return "";
		String[] lines = document.substring(offset, offset + length).split("\\n");
		if (lines.length == 1)
			return lines[0];
		else {
			String newLines[] = new String[lines.length];
			for (int i = 0; i < lines.length; i++)
				if (lines[i].startsWith(indentation))
					newLines[i] = lines[i].substring(indentation.length());
				else
					newLines[i] = lines[i];
			return Joiner.on("\n").join(newLines);
		}
	}

	protected String getIndentation() {
		int nl = document.lastIndexOf("\n", offset);
		if (nl < 0)
			nl = 0;
		StringBuilder result = new StringBuilder();
		for (int i = nl + 1; i < document.length() && Character.isWhitespace(document.charAt(i)) && document.charAt(i) != '\n'; i++)
			result.append(document.charAt(i));
		return result.toString();
	}

	public int getLength() {
		return length;
	}

	public int getOffset() {
		return offset;
	}

	protected String replaceInDocument(String indentation, String value) {
		String indented;
		if (!Strings.isEmpty(indentation))
			indented = indentation + value.replace("\n", "\n" + indentation);
		else
			indented = value;
		String before = document.substring(0, offset);
		String after = document.substring(offset + length, document.length());
		return before + indented + after;
	}
}