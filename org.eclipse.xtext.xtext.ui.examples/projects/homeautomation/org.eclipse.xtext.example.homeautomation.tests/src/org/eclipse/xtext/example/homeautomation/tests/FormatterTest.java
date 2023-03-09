/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.tests;

import org.eclipse.xtext.testing.formatter.FormatterTestHelper;

import com.google.inject.Inject;

public class FormatterTest extends AbstractTest {
	@Inject
	private FormatterTestHelper formatterTestHelper;

	@Override
	protected void test(CharSequence document) throws Exception {
		formatterTestHelper.assertFormatted(req -> req.setToBeFormatted(document));
	}
}
