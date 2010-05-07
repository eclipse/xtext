/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.services;

import java.util.Set;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.base.Join;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Default converters for Strings, Integers and IDs.
 */
public class DefaultTerminalConverters extends AbstractDeclarativeValueConverterService {

	/**
	 * @deprecated use {@link IDValueConverter} instead.
	 */
	@Deprecated
	public static class IDValueConverter extends AbstractValueConverter<String> {

		private Set<String> toEscape;

		public IDValueConverter(Set<String> toEscape) {
			super();
			this.toEscape = toEscape;
		}

		protected Set<String> getToEscape() {
			return toEscape;
		}

		public String toString(String value) {
			if (value == null)
				throw new ValueConverterException("ID may not be null.", null, null);
			if (value.length() == 0)
				throw new ValueConverterException("ID may not be empty.", null, null);
			Set<Character> invalidChars = null;
			for (int i = 0; i < value.length(); i++) {
				char c = value.charAt(i);
				if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
					continue;
				if (i != 0 && c >= '0' && c <= '9')
					continue;
				if (c == '_')
					continue;
				if (invalidChars == null)
					invalidChars = Sets.newHashSet();
				invalidChars.add(c);
			}
			if (invalidChars != null) {
				String chars = Join.join(", ", Iterables.transform(invalidChars, new Function<Character, String>() {
					public String apply(Character from) {
						return "'" + from + "' (0x" + Integer.toHexString(from) + ")";
					}
				}));
				throw new ValueConverterException("ID '" + value + "' contains invalid characters: " + chars, null,
						null);
			}
			if (toEscape.contains(value)) {
				return "^" + value;
			}
			return value;
		}

		public String toValue(String string, AbstractNode node) {
			if (string == null)
				return null;
			return string.startsWith("^") ? string.substring(1) : string;
		}
	}

	/**
	 * @deprecated use {@link INTValueConverter} instead.
	 */
	@Deprecated
	public static class INTValueConverter extends AbstractValueConverter<Integer> {

		public String toString(Integer value) {
			if (value == null)
				throw new ValueConverterException("INT-value may not be null. (null indeed, zero is ok)", null, null);
			if (value < 0)
				throw new ValueConverterException("INT-value may not be negative. (value:" + value + ").", null, null);
			return value.toString();
		}

		public Integer toValue(String string, AbstractNode node) {
			if (Strings.isEmpty(string))
				throw new ValueConverterException("Couldn't convert empty string to int.", node, null);
			try {
				return Integer.valueOf(string);
			} catch (NumberFormatException e) {
				throw new ValueConverterException("Couldn't convert '" + string + "' to int.", node, e);
			}
		}

	}

	/**
	 * @deprecated use {@link STRINGValueConverter} instead.
	 */
	@Deprecated
	public static class STRINGValueConverter extends AbstractValueConverter<String> {
		public String toString(String value) {
			if (value == null)
				throw new ValueConverterException("STRING-value may not be null.", null, null);
			return '"' + Strings.convertToJavaString(value, false) + '"';
		}

		public String toValue(String string, AbstractNode node) {
			if (string == null)
				return null;
			try {
				return Strings.convertFromJavaString(string.substring(1, string.length() - 1), false);
			} catch (IllegalArgumentException e) {
				throw new ValueConverterException(e.getMessage(), node, e);
			}
		}
	}
	
	@Inject
	private AbstractIDValueConverter idValueConverter;

	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		return idValueConverter;
	}

	@Inject
	private INTValueConverter intValueConverter;
	
	@ValueConverter(rule = "INT")
	public IValueConverter<Integer> INT() {
		return intValueConverter;
	}

	@Inject
	private STRINGValueConverter stringValueConverter;
	
	@ValueConverter(rule = "STRING")
	public IValueConverter<String> STRING() {
		return stringValueConverter;
	}

}
