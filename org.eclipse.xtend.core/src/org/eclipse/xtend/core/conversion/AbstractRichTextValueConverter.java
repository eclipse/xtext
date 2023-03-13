/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.conversion;

import java.io.StringReader;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractRichTextValueConverter extends AbstractLexerBasedConverter<String> {
	
	@Inject
	private FlexerFactory flexerFactory;
	
	/**
	 * A list of possible trailing subsequence sorted by length in descending order.
	 */
	private List<String> trailingSubsequences;
	
	protected abstract String getLeadingTerminal();
	protected abstract String getTrailingTerminal();
	
	@Override
	protected String toEscapedString(String value) {
		return getLeadingTerminal() + value + getTrailingTerminal();
	}
	
	@Override
	protected TokenSource getTokenSource(String escapedValue) {
		return flexerFactory.createTokenSource(new StringReader(escapedValue));
	}
	
	@Override
	protected void assertValidValue(String value) {
		super.assertValidValue(value);
		if (value.indexOf('\u00AB') >= 0) {
			throw new ValueConverterException("Rich string may not contain \"\u00AB\".", null, null);
		}
		if (value.indexOf("'''") >= 0) {
			throw new ValueConverterException("Rich string may not contain \"'''\".", null, null);
		}
	}
	
	protected List<String> getTrailingSubsequences() {
		if (trailingSubsequences != null)
			return trailingSubsequences;
		String trailingTerminal = getTrailingTerminal();
		List<String> result = Collections.emptyList();
		if (trailingTerminal.length() >= 1) {
			Set<String> unique = Sets.newLinkedHashSet();
			for(int i = 0; i < trailingTerminal.length() - 1; i++) {
				addIfAbsent(trailingTerminal.substring(i + 1), unique);
				addIfAbsent(trailingTerminal.substring(0, i + 1), unique);
			}
			result = ImmutableList.copyOf(unique);
		}
		trailingSubsequences = result;
		return result;
	}
	
	protected void addIfAbsent(String value, Set<String> set) {
		if (!set.contains(value))
			set.add(value);
	}
	
	@Override
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			String leadingTerminal = getLeadingTerminal();
			if (string.length() <= leadingTerminal.length()) {
				throw stringLiteralIsNotClosed(node, "");
			}
			String withoutLeadingTerminal = getWithoutLeadingTerminal(string);
			String trailingTerminal = getTrailingTerminal();
			if (withoutLeadingTerminal.endsWith(trailingTerminal)) {
				String result = withoutLeadingTerminal.substring(0, withoutLeadingTerminal.length() - trailingTerminal.length());
				return result;	
			}
			List<String> trailingSubsequences = getTrailingSubsequences();
			for(String subsequence: trailingSubsequences) {
				if (withoutLeadingTerminal.endsWith(subsequence)) {
					throw stringLiteralIsNotClosed(node, withoutLeadingTerminal.substring(0, withoutLeadingTerminal.length() - subsequence.length()));
				}
			}
			throw stringLiteralIsNotClosed(node, withoutLeadingTerminal.substring(0, withoutLeadingTerminal.length()));
		} catch (StringIndexOutOfBoundsException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
	
	private ValueConverterWithValueException stringLiteralIsNotClosed(INode node, String value) {
		return new ValueConverterWithValueException("String literal is not closed", node, value, null);
	}
	
	protected String getWithoutLeadingTerminal(String string) {
		return string.substring(getLeadingTerminal().length());
	}
}