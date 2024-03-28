/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.formatter;

import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 * @since 2.35
 */
@Beta
public abstract class AbstractFormatterTest {

	@Inject @Extension
	protected FormatterTestHelper formatterTestHelper;

	protected void assertFormattedTo(CharSequence formatterInput, CharSequence formatterExpectation) {
		formatterTestHelper.assertFormatted(request -> {
			request.setToBeFormatted(formatterInput);
			request.setExpectation(formatterExpectation);
		});
	}
}
