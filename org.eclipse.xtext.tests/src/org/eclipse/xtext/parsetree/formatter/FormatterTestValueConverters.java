/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

public class FormatterTestValueConverters extends DefaultTerminalConverters {

	@ValueConverter(rule = "FQN")
	public IValueConverter<String> FQN() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToString(String value) {
				return value;
			}

			@Override
			protected String internalToValue(String string, INode node) {
				if (!string.equals(string.trim()))
					throw new RuntimeException();
				StringBuffer b = new StringBuffer();
				for (ILeafNode leaf : node.getLeafNodes()) {
					if (!leaf.isHidden()) {
						b.append(leaf.getText());
					}
				}
				return b.toString();
			}
		};
	}

	@ValueConverter(rule = "WrappingDataType")
	public IValueConverter<String> WrappingDataType() {
		return new AbstractNullSafeConverter<String>() {

			@Override
			protected String internalToString(String value) {
				return value;
			}

			@Override
			protected String internalToValue(String string, INode node) throws ValueConverterException {
				return node.getText().trim();
			}
		};

	}

}
