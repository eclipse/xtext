/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.assignmentFinderTest.TestEnum;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class AssignmentFinderTestLanguageRuntimeModule extends AbstractAssignmentFinderTestLanguageRuntimeModule {

	public static class AFValueConverter extends DefaultTerminalConverters {
		@ValueConverter(rule = "DatEnum")
		public IValueConverter<TestEnum> DatEnum() {
			return new IValueConverter<TestEnum>() {

				@Override
				public TestEnum toValue(String string, INode node) throws ValueConverterException {
					if ("lit3".equals(string))
						return TestEnum.LIT3;
					else
						throw new ValueConverterException(null, null, null);
				}

				@Override
				public String toString(TestEnum value) throws ValueConverterException {
					if (value == TestEnum.LIT3)
						return TestEnum.LIT3.getName();
					else
						throw new ValueConverterException(null, null, null);
				}
			};
		}
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return AFValueConverter.class;
	}
}
