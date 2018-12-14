/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Ignore
import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@Ignore("https://github.com/eclipse/xtext-xtend/issues/345")
class Issue242Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class Test {
				def void m() {
					val ^default = 1
					println(^de<|>''')
			.assertProposalAtCursor('^default')
			.apply
			.expectContent('''
			class Test {
				def void m() {
					val ^default = 1
					println(^default''')
	}
	
}