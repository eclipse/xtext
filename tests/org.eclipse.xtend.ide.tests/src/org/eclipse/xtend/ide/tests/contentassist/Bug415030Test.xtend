/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

				t''')
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

				t''')
			.assertText("\n\toverride toString() {\n\t\tsuper.toString()\n\t}")
			.appendAndApplyProposal("oStr")
			.expectContent('''
			class A {

				override toString() {
					super.toString()
				}''')
	}

}
