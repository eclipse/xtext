/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;

/**
 * used to register components to be used within the IDE.
 */
public class FormatterTestLanguageRuntimeModule extends
		AbstractFormatterTestLanguageRuntimeModule {

	@Override
	public Class<? extends IFormatter> bindIFormatter() {
		return FormatterTestConfig.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return FormatterTestValueConverters.class;
	}

	public Class<? extends ILineSeparatorInformation> bindILineSeparatorInformation() {
		return FormatterTestLineSeparatorInformation.class;
	} 
}
