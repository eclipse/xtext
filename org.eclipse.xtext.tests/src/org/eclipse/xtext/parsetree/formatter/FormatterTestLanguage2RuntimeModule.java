/*******************************************************************************
 * Copyright (c) 2019, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.formatting.IFormatter;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class FormatterTestLanguage2RuntimeModule extends AbstractFormatterTestLanguage2RuntimeModule {

	@Override
	public Class<? extends IFormatter> bindIFormatter() {
		return FormatterTestConfig2.class;
	}

}
