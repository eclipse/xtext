/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.tests;

import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;

import com.google.inject.Inject;

public class ParserTest extends AbstractTest {
	@Inject
	private ParseHelper<Model> parseHelper;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Override
	protected void test(CharSequence document) throws Exception {
		validationTestHelper.assertNoErrors(parseHelper.parse(document));
	}
}
