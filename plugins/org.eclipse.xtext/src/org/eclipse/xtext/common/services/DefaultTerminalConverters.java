/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.services;

import java.util.Set;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableSet;

/**
 * Simple converters for Strings, Integers and IDs.
 */
public class DefaultTerminalConverters extends AbstractDeclarativeValueConverterService {

	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		return new AbstractNullSafeConverter<String>() {
			
			private Set<String> allKeywords = ImmutableSet.copyOf(GrammarUtil.getAllKeywords(getGrammar()));
			
			@Override
			protected String internalToValue(String string, AbstractNode node) {
				return string.startsWith("^") ? string.substring(1) : string;
			}

			@Override
			protected String internalToString(String value) {
				if (allKeywords.contains(value)) {
					return "^" + value;
				}
				return value;
			}
		};
	}

	@ValueConverter(rule = "STRING")
	public IValueConverter<String> STRING() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, AbstractNode node) {
				try {
					return Strings.convertFromJavaString(string.substring(1, string.length() - 1), false);
				} catch(IllegalArgumentException e) {
					throw new ValueConverterException(e.getMessage(), node, e);
				}
			}

			@Override
			protected String internalToString(String value) {
				return '"' + Strings.convertToJavaString(value, false) + '"';
			}
		};
	}

	@ValueConverter(rule = "INT")
	public IValueConverter<Integer> INT() {
		return new IValueConverter<Integer>() {
			
			public Integer toValue(String string, AbstractNode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to int", node, null);
				try {
					return Integer.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '"+string+"' to int", node, e);
				}
			}

			public String toString(Integer value) {
				return value.toString();
			}

		};
	}

}
