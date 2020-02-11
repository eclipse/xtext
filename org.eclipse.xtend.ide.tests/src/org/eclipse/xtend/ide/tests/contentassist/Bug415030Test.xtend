/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class Bug415030Test extends AbstractXtendContentAssistBugTest {

	@Test def void testMethodOverrides() {
		newBuilder.append('''
			class A {

				to''')
			.assertText("\n\toverride toString() {\n\t\tsuper.toString()\n\t}")
			.applyProposal
			.expectContent('''
			class A {

				override toString() {
					super.toString()
				}''')
	}

	@Test def void testMethodOverrides_2() {
		newBuilder.append('''
			class A {

				to''')
			.assertText("\n\toverride toString() {\n\t\tsuper.toString()\n\t}")
			.appendAndApplyProposal("Str")
			.expectContent('''
			class A {

				override toString() {
					super.toString()
				}''')
	}

}
