/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.formatter.FormatterTestHelper

class FormatterTest extends AbstractTest {

	@Inject extension FormatterTestHelper

	override protected test(CharSequence document) {
		assertFormatted[
			toBeFormatted = document
		]
	}

}