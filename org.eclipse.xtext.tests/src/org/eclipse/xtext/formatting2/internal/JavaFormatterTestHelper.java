/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;

import com.google.inject.Inject;

/**
 * @author Arne Deutsch - Initial contribution and API
 */
public class JavaFormatterTestHelper extends FormatterTestHelper {

	@Inject
	private FormatterTestLanguageJavaFormatter formatter;

	public void assertFormatted(String original, String expectation) {
		assertFormatted(r -> r.setToBeFormatted(original).setExpectation(expectation));
	}

	@Override
	protected IFormatter2 createFormatter(FormatterTestRequest request) {
		return formatter;
	}

}
