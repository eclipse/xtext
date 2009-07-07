/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.services;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * Simple converters for Strings, Integers and IDs.
 */
public class DefaultTerminalConverters extends AbstractDeclarativeValueConverterService {

	private Grammar grammar;

	@Inject
	public void setGrammar(IGrammarAccess grammarAccess) {
		this.grammar = grammarAccess.getGrammar();
	}

	protected Grammar getGrammar() {
		return grammar;
	}

	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, AbstractNode node) {
				return string.startsWith("^") ? string.substring(1) : string;
			}

			@Override
			protected String internalToString(String value) {
				if (GrammarUtil.getAllKeywords(getGrammar()).contains(value)) {
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
				return Strings.convertFromJavaString(string.substring(1, string.length() - 1));
			}

			@Override
			protected String internalToString(String value) {
				return '"' + Strings.convertToJavaString(value) + '"';
			}
		};
	}

	@ValueConverter(rule = "INT")
	public IValueConverter<Integer> INT() {
		return new AbstractToStringConverter<Integer>() {
			@Override
			public Integer internalToValue(String string, AbstractNode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to int", node, null);
				try {
					return Integer.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '"+string+"' to int", node, e);
				}
			}
		};
	}

}
