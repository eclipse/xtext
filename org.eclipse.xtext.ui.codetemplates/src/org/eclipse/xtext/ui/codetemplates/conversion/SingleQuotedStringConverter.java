/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.conversion;

import org.eclipse.xtext.conversion.impl.STRINGValueConverter;
import org.eclipse.xtext.util.Strings;

public class SingleQuotedStringConverter extends STRINGValueConverter {

	@Override
	protected String toEscapedString(String value) {
		return '\'' + Strings.convertToJavaString(value, false) + '\'';
	}
	
}
