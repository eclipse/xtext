/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.valueconverter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * used to register components to be used at runtime.
 */
public class Bug250313RuntimeModule extends AbstractBug250313RuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return Converters.class;
	}

	public static class Converters extends DefaultTerminalConverters {

		@ValueConverter(rule = "Datatype")
		public IValueConverter<String> Datatype() {
			return new AbstractNullSafeConverter<String>() {
				@Override
				protected String internalToValue(String string, INode node) {
					return "str";
				}

				@Override
				protected String internalToString(String value) {
					throw new UnsupportedOperationException();
				}
			};
		}

		@ValueConverter(rule = "NestedDatatype")
		public IValueConverter<String> NestedDatatype() {
			return new AbstractNullSafeConverter<String>() {
				@Override
				protected String internalToValue(String string, INode node) {
					return "str";
				}

				@Override
				protected String internalToString(String value) {
					throw new UnsupportedOperationException();
				}
			};
		}

	}

}
