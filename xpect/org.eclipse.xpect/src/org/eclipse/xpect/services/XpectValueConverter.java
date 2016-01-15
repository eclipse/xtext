/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.services;

import java.util.Set;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.ImmutableSet;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectValueConverter extends DefaultTerminalConverters {

	public class IDConverter extends AbstractNullSafeConverter<String> {

		private Set<String> allKeywords = ImmutableSet.copyOf(GrammarUtil.getAllKeywords(getGrammar()));

		@Override
		protected String internalToValue(String string, INode node) {
			return string.replaceAll("[\\^\\s]", "");
		}

		@Override
		protected String internalToString(String value) {
			if (allKeywords.contains(value))
				return "^" + value;
			return value;
		}
	}

	private IDConverter idValueConverter;

	@ValueConverter(rule = "INVOCATION")
	public IValueConverter<String> INVOCATION() {
		if (idValueConverter == null)
			idValueConverter = new IDConverter();
		return idValueConverter;
	}

}
